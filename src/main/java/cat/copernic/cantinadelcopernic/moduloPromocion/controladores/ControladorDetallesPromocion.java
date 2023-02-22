/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.moduloRRHH.modelo.Profesor;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorDetallesPromocion {
     @GetMapping("/detallesPromocion")
    public String inici(Model model) {
        ArrayList<Profesor> profesores = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Profesor profesor = new Profesor();
            profesor.setCorreo("pepe@gmail.com");
            profesores.add(profesor);
        }
        model.addAttribute("profesores", profesores);
        return "/paginasPromocion/detallesPromocion";
    }
}
