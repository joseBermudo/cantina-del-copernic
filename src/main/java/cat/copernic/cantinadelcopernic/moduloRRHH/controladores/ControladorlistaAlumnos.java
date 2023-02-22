/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;


import cat.copernic.cantinadelcopernic.moduloRRHH.modelo.Alumno;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorlistaAlumnos {
    
    @GetMapping("/listaAlumnes")
    public String inici(Model model){
        
        var alumno = new Alumno();
        alumno.setCorreo("ftsdtdtt");
        var alumno2 = new Alumno();
        alumno2.setCorreo("tdtsndtn");
        
        var alumnos = new ArrayList<Alumno>();
        
        alumnos.add(alumno2);
        alumnos.add(alumno);
        
        model.addAttribute("alumnos", alumnos);
        return "/RRHH/listaAlumnos"; 
    }
}
