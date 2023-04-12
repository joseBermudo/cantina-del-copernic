/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Clase que represena el controllador para eliminar un profesor
 * @author andre
 */
@Controller
public class ControladorEliminarProfesor {
    
    @Autowired
    private ProfesorService profesorService;
    
    @GetMapping("/eliminarProfesor/{correo}") 
    /**
     * función que se utiliza para eliminar el profesor
     * @param profesor
     * @return devuelve un redirect a la pantalla donde se muestra un listdo de los profesores
     */
    public String eliminar(Profesor profesor) {
        
        var profesorCompleto = profesorService.buscarProfesores(profesor);
        
        profesorService.eliminarProfesores(profesorCompleto);
        
        return "redirect:/listaProfesors";
    }
    
}
