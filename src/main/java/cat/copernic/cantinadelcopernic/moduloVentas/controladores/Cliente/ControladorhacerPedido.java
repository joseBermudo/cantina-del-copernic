/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;

import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorhacerPedido {

    @Autowired
    private ProduccionService prodSer;

    @Autowired
    private VentasService serVentas;

    @Autowired
    private ProfesorService profSer;

    @GetMapping("/hacerPedidoCliente")
    public String inici(Model model, Pedido pedido) {

        String fc = "FER COMANDA";
        model.addAttribute("ferComanda", fc);

        //lista de bocadillos de la semana
        var bocadillosDeLaSemana = serVentas.listarBocadilloSemana();

        //recetas
        var bebidas = prodSer.obtenerBebidas();

        model.addAttribute("bocsemana", bocadillosDeLaSemana);
        model.addAttribute("bebidas", bebidas);

        return "/paginasVentas/ventasCliente/hacerPedidoCliente"; //Retorna la pàgina iniciEnviarDades
    }

    @GetMapping("/cancelarPedido/{id_pedido}")
    public String cancelarPedido(Pedido pedido) {
        serVentas.eliminarPedido(pedido);
        return "redirect:/pedidosCliente";
    }

//    @GetMapping("/mostrarPrecio/{id_pedido}")
//    public String mostrarPrecio(Pedido pedido, Model model) {
//
//        Double precio = pedido.getBebida().getPrecio() + pedido.getBocadilloSemana().getPrecio();
//           //PRECIO
//        model.addAttribute("precio", precio);
//        
//        
//        
//         String fc = "FER COMANDA";
//        model.addAttribute("ferComanda", fc);
//
//        //lista de bocadillos de la semana
//        var bocadillosDeLaSemana = serVentas.listarBocadilloSemana();
//
//        //recetas
//        var bebidas = prodSer.obtenerBebidas();
//
//        model.addAttribute("bocsemana", bocadillosDeLaSemana);
//        model.addAttribute("bebidas", bebidas);
//
//        return "/paginasVentas/ventasCliente/hacerPedidoCliente";
//    }
    @PostMapping("/guardarPedido")
    public String guardarPedidos(Pedido pedido) {

        var bebida = prodSer.buscarBebida(pedido.getBebida());
        pedido.setBebida(bebida);

        var bocadilloSemana = serVentas.buscarBocadilloSemana(pedido.getBocadilloSemana());
        pedido.setBocadilloSemana(bocadilloSemana);

        //var precio = bocadilloSemana.getPrecio() + bebida.getPrecio();
        Profesor prof = new Profesor();
        prof.setCorreo(getCurrentUser());
        pedido.setProfesores(profSer.buscarProfesores(prof));

        serVentas.addPedidos(pedido);

        return "redirect:/pedidosCliente";

    }
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return username;
    }

}
