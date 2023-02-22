/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import cat.copernic.cantinadelcopernic.moduloProduccion.modelo.Bebida;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorListaBebidas {
    
    @GetMapping("/listaBebidas")
    public String inici(Model model) {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Bebida bebida = new Bebida();
            bebida.setNombre("Cocacola");
            bebida.setPrecio(12.4);
            bebidas.add(bebida);
        }
        model.addAttribute("bebidas", bebidas);
        return "/paginasProduccion/listaBebidas";
    }
    
}
