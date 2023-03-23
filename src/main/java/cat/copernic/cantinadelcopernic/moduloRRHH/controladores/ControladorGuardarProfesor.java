/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorGuardarProfesor {
    
    @Autowired
    private ProfesorService profesorService;
    
    @PostMapping("/guardarProfesor")
    public String guardarProfesor(@Valid Profesor profesor, Errors errors){
        
        if(errors.hasErrors()){ 
           return "paginasRRHH/nuevoProfesor";
        }
        
        profesorService.anadirProfesores(profesor);
        
        return "redirect:/listaProfesors";
    
    }
    
}
