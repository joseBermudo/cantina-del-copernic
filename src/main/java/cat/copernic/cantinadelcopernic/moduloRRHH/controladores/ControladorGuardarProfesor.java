/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Rol;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.utilities.EncriptadorContrasenya;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.PostMapping;

/**
 *Clase que represena el controllador para guardar un profesor
 * @author andre
 */
@Controller
public class ControladorGuardarProfesor {
    
    @Autowired
    private ProfesorService profesorService;
    
    @PostMapping("/guardarProfesor")
    /**
     * función que se utiliza para guardar un profesor
     * @param profesor
     * @param errors objeto donde se guardan los errores que se dan al validar profesor
     * @param result objeto que se utliza para crear un error propio para validar la contraseña
     * @return devuelve un redirect a una pantalla donde se muestra una lista de profesores
     */
    public String guardarProfesor(@Valid Profesor profesor, Errors errors, BindingResult result){
        
        if(errors.hasErrors()){ 
           return "paginasRRHH/nuevoProfesor";
        }
        
        if (!profesor.getPassword().equals(profesor.getConfirmarPassword())) {
        result.rejectValue("confirmarPassword", "error.confirmarPassword", "Las contraseñas no coinciden");
        return "paginasRRHH/nuevoProfesor";
    }
        
        profesor.setUsername(profesor.getCorreo());
        
        profesor.setPassword(EncriptadorContrasenya.encriptarContrasenya(profesor.getPassword()));
        
        var rol = new Rol();
        
        rol.setIdroles(3);
        
        profesor.setRols(rol);
        profesorService.anadirProfesores(profesor);
        
        return "redirect:/listaProfesors";
    
    }
    
}
