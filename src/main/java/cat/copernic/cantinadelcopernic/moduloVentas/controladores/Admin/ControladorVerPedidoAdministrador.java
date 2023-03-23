/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.PedidoDAO;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorVerPedidoAdministrador {

    @Autowired
    private VentasService ventasSer;

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista*/
    @GetMapping("/verPedidoAdministrador/{id_pedido}")
    public String inici(Model model, Pedido pedido) {

       double  precioBebida = ventasSer.buscarPedido(pedido).getBebida().getPrecio();
       double precioBocata = ventasSer.buscarPedido(pedido).getBocadilloSemana().getPrecio();
       double precioTotal = precioBebida + precioBocata;
        model.addAttribute("pedido", ventasSer.buscarPedido(pedido));
        model.addAttribute("preciototal", precioTotal);
        return "/paginasVentas/ventasAdministrador/verPedidoAdministrador"; //Retorna la pàgina iniciEnviarDades
    }

    @GetMapping("/eliminarPedido/{id_pedido}")
    public String eliminar(Pedido pedido) {

        ventasSer.eliminarPedido(pedido);

        return "redirect:/pedidosAdministrador";
    }
    
    

}
