/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;


import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorlistaProfesors {
    
    @GetMapping("/listaProfesors")
   public String inici(Model model){
        
        var profesor = new Profesor();
        profesor.setCorreo("ftsdtdtt");
        var profesor2 = new Profesor();
        profesor2.setCorreo("tdtsndtn");
  
        
        var profesores = new ArrayList<Profesor>();
        
        profesores.add(profesor);
        profesores.add(profesor2);
        
        model.addAttribute("profesores", profesores);
        return "/RRHH/listaProfesores";
    }
}
