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
public class ControladorEditarPerfil {
    
    @Autowired
    private ProfesorService profesorService;
    
    @PostMapping("/guardarPerfil")
    public String guardarProfesor(@Valid Profesor profesor, Errors errors){
        
        if(errors.hasErrors()){ 
           return "paginasRRHH/perfil";
        }
        
        profesorService.anadirProfesores(profesor);
        
        return "redirect:/listaProfesors";
    
    }
}
