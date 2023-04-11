/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Clase que representa el controlador de la página para crear una sugerencia
 * @author andre
 */
@Controller
public class ControladorNuevaSugerencia {
    

    @GetMapping("/nouSuggeriment")
    /**
     * función que se utiliza para cargar la página para crear una sugerencia
     * @param sugerencia
     * @param model
     * @return devuelve el html de la página para crear una sugerencia
     */
    public String inici( Sugerencia sugerencia, Model model){
        
        var titulo = "CREAR SUGGERIMENT";
        var tituloSugerencia = "Titul del suggeriment:";
        var descripcionSugerencia = "Descripció del suggeriment:";
        
        var esCrearSugerencia = true;
        var esEditarSugerencia = false; 
        model.addAttribute("titulo", titulo);
        model.addAttribute("tituloSugerencia", tituloSugerencia);
        model.addAttribute("descripcionSugerencia", descripcionSugerencia);
        model.addAttribute("esCrearSugerencia", esCrearSugerencia);
         model.addAttribute("esEditarSugerencia", esEditarSugerencia);
            
        return "/paginasSugerencias/nuevaSugerencia"; 
    }
    
   
    
}

