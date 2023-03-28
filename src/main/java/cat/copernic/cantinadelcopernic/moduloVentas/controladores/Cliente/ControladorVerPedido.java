/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
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
public class ControladorVerPedido {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @Autowired
    private VentasService serVentas;

    @Autowired
    private BebidaDAO bebDAO;

    @GetMapping("/verPedidoClient/{id_pedido}")
    public String inici(Model model, Pedido pedido) {

        String com = "COMANDA: " + pedido.getId_pedido();
        model.addAttribute("comanda", com);

        model.addAttribute("precio", obtenerPrecio(serVentas.buscarPedido(pedido)));

        pedido = serVentas.buscarPedido(pedido);

        model.addAttribute("precio", pedido.getBebida().getPrecio() + pedido.getBocadilloSemana().getPrecio());

        model.addAttribute("pedido", serVentas.buscarPedido(pedido));

        return "/paginasVentas/ventasCliente/verPedidoCliente"; //Retorna la pàgina iniciEnviarDades
    }

    public Double obtenerPrecio(Pedido pedido) {
        Double precio = pedido.getBebida().getPrecio() + pedido.getBocadilloSemana().getPrecio();
        //PRECIO
        return precio;
    }

}
