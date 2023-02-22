/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorEditarBebida {
    
    @GetMapping("/editarBebida")
    public String inici(Model model) {
        return "/paginasProduccion/editarBebida";
    }
    
}
