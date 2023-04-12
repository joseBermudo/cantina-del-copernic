/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.PedidoDAO;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Esta clase es un controlador de Spring que maneja las solicitudes HTTP
 * relacionadas con los pedidos del administrador.
 */
@Controller
public class ControladorPedidosAdministrador {

    @Autowired
    private VentasService serVentas;

    /**
     *
     * Este método maneja una solicitud HTTP GET para mostrar los pedidos del
     * administrador.
     *
     * @param model El objeto Model que se utiliza para transferir datos entre
     * el controlador y la vista.
     *
     * @return La vista que muestra los pedidos del administrador.
     */
    @GetMapping("/pedidosAdministrador")
    public String inici(Model model) {

        String com = "Comandes";
        model.addAttribute("com1", com);

        var pedidos = serVentas.listarPedidos();

        model.addAttribute("pedidos", pedidos);

        String Comandes = "Comandes";
        model.addAttribute("comand", Comandes);

        return "/paginasVentas/ventasAdministrador/pedidosAdministrador"; //Retorna la pàgina iniciEnviarDades
    }

}
