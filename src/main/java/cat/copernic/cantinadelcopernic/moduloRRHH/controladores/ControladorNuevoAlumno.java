/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorNuevoAlumno {
  @GetMapping("/nouAlumne")
    public String inici(Model model){
        
        var tituloPagina = "REGISTRAR ALUMNE";
        
        var correo = "Correu electronic:";
        
        var contrasenya = "Contrasenya:";
        
        var confirmarContrasenya = "Confirmar contrasenya:";
        
        model.addAttribute("tituloPagina", tituloPagina);
        
        model.addAttribute("correo", correo);
        
        model.addAttribute("contrasenya", contrasenya);
        
        model.addAttribute("confirmarContrasenya", confirmarContrasenya);
        
        return "/paginasRRHH/nuevoAlumno"; 
    }  
}
