/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;

import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *Clase que actua de controlador para hacer la función de elimniar una sugerencia
 * @author andre
 */
@Controller
public class ControladorEliminarSugerencia {
    
    @Autowired
    private SugerenciaService sugerenciaService;
    
    /**
     *
     * @param sugerencia
     * @return
     */
    @GetMapping("/eliminarSuggeriment/{idSugerencia}") 
    /**
     * función para eliminiar la sugerencia 
     * @param sugerencia
     * @return una redirección a la lista de sugerencias
     */
    public String eliminar(Sugerencia sugerencia) {
        
        sugerenciaService.eliminarSugerencia(sugerencia);
        
        return "redirect:/listaSuggeriments"; 
    }
    
}
