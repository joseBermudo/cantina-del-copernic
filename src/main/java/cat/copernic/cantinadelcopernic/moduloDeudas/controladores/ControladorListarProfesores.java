/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorListarProfesores {

    
    @GetMapping("/listarProfesores")
    public String inici(Model model) {
        
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("listadoProfesoresWord", "Llistat professors");
        model.addAttribute("deudasWord", "Deutes");
        model.addAttribute("deudaWord", "Deuda");
        model.addAttribute("correoWord", "Email");
        model.addAttribute("noHayProfesoresWord", "No hi ha professors");
        model.addAttribute("verWord", "Veure");
        
        var listadoProfesores = new ArrayList<Profesor>();
        /*
        Profesor datosProfesor = new Profesor();
        datosProfesor.setCorreo("correo@ejemplo.com");
        datosProfesor.setNombre("Juan");
        datosProfesor.setApellidos("Pérez García");
        listadoProfesores.add(datosProfesor);
        */
        model.addAttribute("listadoProfesores", listadoProfesores);
        
        return "/paginasDeudas/listarProfesores"; 
    }
}
