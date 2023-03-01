/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTipoTarea {
    
    @GetMapping("/crearTipoTarea")
    public String inici(Model model) {
        
        model.addAttribute("crearTipoTareaWord", "Crear tipus de tasca");
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("nombreTipoTareaWord", "Nom tipus de tasca");
        model.addAttribute("cancelarWord", "Cancel·lar");
        
        return "/paginasTareas/crearTipoTarea"; 
    }
}