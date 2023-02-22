/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

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

        //var profesores = new ArrayList<Profesor>();
        //model.addAttribute("profesores", profesores);
        
        return "/paginasDeudas/listarProfesores"; 
    }
}
