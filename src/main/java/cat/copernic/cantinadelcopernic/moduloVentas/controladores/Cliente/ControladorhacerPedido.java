/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
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
    private BebidaDAO bebDAO;

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
        var bebidas = bebDAO.findAll();

        model.addAttribute("bocsemana", bocadillosDeLaSemana);
        model.addAttribute("bebidas", bebidas);

        return "/paginasVentas/ventasCliente/hacerPedidoCliente"; //Retorna la pàgina iniciEnviarDades
    }

    @GetMapping("/cancelarPedido/{id_pedido}")
    public String cancelarPedido(Pedido pedido) {

        serVentas.eliminarPedido(pedido);

        return "redirect:/pedidosCliente";
    }

    @PostMapping("/guardarPedido")
    public String guardarPedidos(Pedido pedido) {

        var bebida = bebDAO.findById(pedido.getBebida().getId()).get();
        pedido.setBebida(bebida);

        var bocadilloSemana = serVentas.buscarBocadilloSemana(pedido.getBocadilloSemana());
        pedido.setBocadilloSemana(bocadilloSemana);

        //var precio = bocadilloSemana.getPrecio() + bebida.getPrecio();
        pedido.setProfesores(profSer.listarProfesores().get(0));

        serVentas.addPedidos(pedido);

        return "redirect:/pedidosCliente";

    }

}
