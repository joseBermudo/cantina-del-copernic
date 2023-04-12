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
 * Controlador encargado de mostrar y eliminar pedidos en la vista del
 * administrador.
 */
@Controller
public class ControladorVerPedidoAdministrador {

    @Autowired
    private VentasService ventasSer;

    /**
     *
     * Método que permite mostrar el detalle de un pedido en la vista del
     * administrador.
     *
     * @param model objeto de la interface Model de Spring Boot que permite
     * transferir datos entre el controlador y la vista
     *
     * @param pedido objeto de tipo Pedido que representa el pedido a mostrar
     *
     * @return String con la dirección de la página que muestra el detalle del
     * pedido
     */
    @GetMapping("/verPedidoAdministrador/{id_pedido}")
    public String inici(Model model, Pedido pedido) {

        double precioBebida = ventasSer.buscarPedido(pedido).getBebida().getPrecio();
        double precioBocata = ventasSer.buscarPedido(pedido).getBocadilloSemana().getPrecio();
        double precioTotal = precioBebida + precioBocata;
        model.addAttribute("pedido", ventasSer.buscarPedido(pedido));
        model.addAttribute("preciototal", precioTotal);
        return "/paginasVentas/ventasAdministrador/verPedidoAdministrador"; //Retorna la página de detalle del pedido
    }

    /**
     *
     * Método que permite eliminar un pedido de la lista de pedidos en la vista
     * del administrador.
     *
     * @param pedido objeto de tipo Pedido que representa el pedido a eliminar
     *
     * @return String con la dirección de la página de la lista de pedidos del
     * administrador
     */
    @GetMapping("/eliminarPedido/{id_pedido}")
    public String eliminar(Pedido pedido) {

        ventasSer.eliminarPedido(pedido);

        return "redirect:/pedidosAdministrador";
    }
}
