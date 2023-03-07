/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.PedidoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorPedidosAdministrador {

    @Autowired
    private BocadilloSemanaDAO bsDAO;

    @Autowired
    private PedidoDAO pedDAO;

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @GetMapping("/pedidosAdministrador")
    public String inici(Model model) {

        String com = "Comandes";
        model.addAttribute("com1", com);

        var pedidos = pedDAO.findAll();
        model.addAttribute("pedidos", pedidos);

        
        
        String Comandes = "Comandes";
        model.addAttribute("comand", Comandes);

        return "/paginasVentas/ventasAdministrador/pedidosAdministrador"; //Retorna la pàgina iniciEnviarDades
    }

}
