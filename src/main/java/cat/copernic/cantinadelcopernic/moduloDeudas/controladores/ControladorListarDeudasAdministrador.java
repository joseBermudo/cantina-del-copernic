/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.DAO.DeudaDAO;
import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloDeudas.servicios.DeudaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorListarDeudasAdministrador {

    @Autowired
    private DeudaService deudaService;
    @GetMapping("/listarDeudasAdministrador")
    public String inici(Model model) {
        
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("listadoDeudasWord", "Llistat deutes");
        model.addAttribute("deudasWord", "Deutes");
        model.addAttribute("fechaWord", "Data");
        model.addAttribute("deudaWord", "Deuda");
        model.addAttribute("marcarComoPagadaWord", "Marcar com a pagada");
        model.addAttribute("noHayDeudasWord", "No hi ha deutes");
        model.addAttribute("aplicarCambiosWord", "Aplicar canvis");
        model.addAttribute("cancelarWord", "Cancel·lar");
        model.addAttribute("crearDeuteWord", "Crear deute");
        model.addAttribute("profesorWord", "Professor:");
        model.addAttribute("correoWord", "Email: ");
        
        model.addAttribute("listadoDeudas",deudaService.listarDeudas());
        
        
        //Exemple
        Profesor datosProfesor = new Profesor();
        datosProfesor.setCorreo("correo@ejemplo.com");
        datosProfesor.setNombre("Nombre");
        datosProfesor.setApellidos("Apellido1 Apellido2");
        
        model.addAttribute("datosProfesor", datosProfesor);
        
        return "/paginasDeudas/listarDeudasAdministrador";
    }
    
    @GetMapping("/crearDeuda")
    public String crearDeuda(Model model) {
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("crearDeudaWord", "Crear deute");
        model.addAttribute("quantitatWord", "Quantitat:");
        model.addAttribute("dataWord", "Data:");
        model.addAttribute("cancelarWord", "Cancel·lar");
        
        return "/paginasDeudas/crearDeuda"; 
    }
}
