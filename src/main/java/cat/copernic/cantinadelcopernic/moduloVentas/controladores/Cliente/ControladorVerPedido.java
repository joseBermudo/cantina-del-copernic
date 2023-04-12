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
 * Esta clase es el controlador encargado de manejar la visualización de un
 * pedido en concreto realizado por un cliente.
 */
@Controller
public class ControladorVerPedido {

    /**
     *
     * Este atributo es una instancia de la interfaz VentasService que nos
     * permite acceder a los servicios relacionados con la venta de productos.
     */
    @Autowired
    private VentasService serVentas;
    /**
     *
     * Este atributo es una instancia de la clase BebidaDAO que nos permite
     * acceder a la base de datos de bebidas.
     */
    @Autowired
    private BebidaDAO bebDAO;

    /**
     *
     * Este método maneja la petición GET "/verPedidoClient/{id_pedido}" y se
     * encarga de mostrar un pedido concreto
     *
     * realizado por un cliente en la vista.
     *
     * @param model es un objeto de la clase Model que nos permite transferir
     * datos entre el controlador y la vista.
     *
     * @param pedido es el objeto de la clase Pedido que se desea visualizar.
     *
     * @return la página "/paginasVentas/ventasCliente/verPedidoCliente".
     */
    @GetMapping("/verPedidoClient/{id_pedido}")
    public String inici(Model model, Pedido pedido) {

        String com = "COMANDA: " + pedido.getId_pedido();
        model.addAttribute("comanda", com);

        model.addAttribute("precio", obtenerPrecio(serVentas.buscarPedido(pedido)));

        pedido = serVentas.buscarPedido(pedido);

        model.addAttribute("precio", pedido.getBebida().getPrecio() + pedido.getBocadilloSemana().getPrecio());

        model.addAttribute("pedido", serVentas.buscarPedido(pedido));

        return "/paginasVentas/ventasCliente/verPedidoCliente";
    }

    /**
     *
     * Este método calcula y devuelve el precio total de un pedido.
     *
     * @param pedido es el objeto de la clase Pedido del que se quiere calcular
     * el precio.
     * @return el precio total del pedido.
     */
    public Double obtenerPrecio(Pedido pedido) {
        Double precio = pedido.getBebida().getPrecio() + pedido.getBocadilloSemana().getPrecio();
//PRECIO
        return precio;
    }
}
