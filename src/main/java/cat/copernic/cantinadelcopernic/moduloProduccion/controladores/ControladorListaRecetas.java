/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import cat.copernic.cantinadelcopernic.moduloProduccion.modelo.Receta;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorListaRecetas {

    @GetMapping("/listaRecetas")
    public String page(Model model) {
        ArrayList<Receta> recetas = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            var receta = new Receta();
            receta.setNombre("Recepte entrepa de pernil");
            recetas.add(receta);
        }
        model.addAttribute("recetas", recetas);
        return "/paginasProduccion/listaRecetas";
    }

}
