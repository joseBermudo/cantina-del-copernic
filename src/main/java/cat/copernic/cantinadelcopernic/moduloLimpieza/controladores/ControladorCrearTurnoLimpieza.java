/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloLimpieza.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTurnoLimpieza {
    
    @GetMapping("/crearTurnoLimpieza")
    public String inici(Model model) {
        
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("crearTornNetejaWord", "Crear Torn de Neteja");
        model.addAttribute("dataWord", "Data:");
        model.addAttribute("cancelarWord", "Cancel·lar");
        model.addAttribute("nomNetejadorWord", "Nom del netejador:");
        
        return "/paginasLimpieza/crearTurnoLimpieza"; 
    }
}