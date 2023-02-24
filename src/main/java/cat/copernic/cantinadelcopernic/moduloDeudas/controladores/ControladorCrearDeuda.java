/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearDeuda {
    
    @GetMapping("/crearDeuda")
    public String inici(Model model) {
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("crearDeudaWord", "Crear deute");
        model.addAttribute("quantitatWord", "Quantitat:");
        model.addAttribute("dataWord", "Data:");
        model.addAttribute("cancelarWord", "Cancel·lar");
        
        return "/paginasDeudas/crearDeuda"; 
    }
}