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
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorGuardarSugerencia {
    
    @Autowired
    private SugerenciaService sugerenciaService;
    
    @Autowired
    private ProfesorService profesorService;
    
    @PostMapping("/guardarSuggeriment")
    public String guardarSugerencia(Sugerencia sugerencia){
        if (sugerencia.getProfesor()== null) {
            var profesor = new Profesor();
            profesor.setCorreo("correo");
            var profesorEntrado = profesorService.buscarProfesores(profesor);
            sugerencia.setProfesor(profesorEntrado);   
        }
        
        
        sugerenciaService.anadirSugerencia(sugerencia);
        
        return "redirect:/listaSuggeriments";
    
    
    }
    
}
