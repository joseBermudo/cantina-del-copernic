/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.sql.Date;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorListarDeudasAlumno {
    
    @GetMapping("/listarDeudasAlumno")
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
        
        var listadoDeudas = new ArrayList<Deuda>();
        model.addAttribute("listadoDeudas", listadoDeudas);
        
        Profesor datosProfesor = new Profesor();
        datosProfesor.setCorreo("correo@ejemplo.com");
        datosProfesor.setNombre("Nombre");
        datosProfesor.setApellidos("Apellido1 Apellido2");
        
        model.addAttribute("datosProfesor", datosProfesor);
        
        return "/paginasDeudas/listarDeudasAlumno"; 
    }
}