/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Rol;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.utilities.RolSigleton;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.PostMapping;

/**
 *Clase que represena el controllador para guardar los cambios de un perfil de profesor
 * @author andre
 */
@Controller
public class ControladorEditarPerfil {
    
    @Autowired
    private ProfesorService profesorService;
    
    @PostMapping("/guardarPerfil")
    /**
     * función que se utiliza para hacer las validaciones sobre profesor y guardarlo
     * @param profesor
     * @param errors objeto donde se jugardan los errores que se fan al validar profesor
     * @return devuelve un redirect a la pantalla donde se muestra la información del profesor
     */
    public String guardarProfesor(@Valid Profesor profesor, Errors errors){
        
        if(errors.hasErrors()){ 
           return "paginasRRHH/perfil";
        }
        
        var rol = new Rol();
        rol.setIdroles(RolSigleton.getInformacion());
        profesor.setRols(rol);
        profesorService.anadirProfesores(profesor);
        
        return "redirect:/perfil";
    
    }
}
