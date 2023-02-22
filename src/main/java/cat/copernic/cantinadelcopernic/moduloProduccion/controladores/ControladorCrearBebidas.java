/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorCrearBebidas {
    @GetMapping("/crearBebida")
    public String inici(Model model) {
        return "/paginasProduccion/crearBebida";
    }
}
