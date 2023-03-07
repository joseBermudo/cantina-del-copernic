/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
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
public class ControladorVerPedidoAdministrador {

    @Autowired
    private BocadilloSemanaDAO bsDAO;

    @Autowired
    private PedidoDAO pedDAO;
    
     @Autowired
    private BebidaDAO bebDAO;
     
     // @Autowired
    //private RRHHDAO bebDAO;
     
     

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista*/
    @GetMapping("/verPedidoAdministrador")
    public String inici(Model model) {

        var pedidoPorId = pedDAO.findById(1);
        var pedido = pedidoPorId.get();
        model.addAttribute("pedido", pedido);

        var bocadilloPorId = bsDAO.findById(pedido.getId_pedido());
        model.addAttribute("com1", bocadilloPorId.get());
        
        
        //bocadillosSemana
         var bocadillosDeLaSemana = bsDAO.findAll();
        
         //bebidas
         var bebidas = bebDAO.findAll(); 
        model.addAttribute("bocsemana", bocadillosDeLaSemana);
        model.addAttribute("begudes", bebidas);
        
        
        
        //ver observaciones del usuario que ha hecho el pedido:
        //var usuario = bebDAO.findById(pedido.getCorreo()); 
        //var observ = usuario.get().getObservaciones;
        // model.addAttribute("observaciones", observ);
        
        String correoStr="Correo:";
        model.addAttribute("correostr", correoStr);
        
        String entrepaStr="Entrepà de la setmana:";
        model.addAttribute("entrepastr", entrepaStr);

        return "/paginasVentas/ventasAdministrador/verPedidoAdministrador"; //Retorna la pàgina iniciEnviarDades
    }

}
