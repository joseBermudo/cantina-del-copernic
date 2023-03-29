/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorPedidosCliente {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @Autowired
    private VentasService serVentas;

    @Autowired
    private ProfesorService profesorService;

    
    @Autowired
    private ProduccionService prodSer;

    @GetMapping("/pedidosCliente")
    public String inici(Model model) {

        model.addAttribute("bocadillo", serVentas.listarBocadilloSemana().get(0));

        Profesor prof = new Profesor();
        prof.setCorreo(getCurrentUser());
        Profesor profBuscado= profesorService.buscarProfesores(prof);
        
        List<Pedido> prueba =  serVentas.findByProfesores(profBuscado);
        model.addAttribute("pedidos", serVentas.findByProfesores(profBuscado));

        return "/paginasVentas/ventasCliente/pedidosCliente"; //Retorna la pàgina iniciEnviarDades
    }
    
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return username;
    }

}
