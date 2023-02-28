/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;

import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorEditarSugerencia {

    @GetMapping("/editarSuggeriment")
    public String inici(Model model) {

        var sugerencia = new Sugerencia();
        sugerencia.setTitulo("titulo sugerencia");
        sugerencia.setDescripcion("descripción sugerencia");
        
        
        model.addAttribute("sugerencia", sugerencia);
        
        var titulo = "EDITAR SUGGERIMENT";
        var tituloSugerencia = "Titul del suggeriment:";
        var descripcionSugerencia = "Descripció del suggeriment:";
        
        model.addAttribute("titulo", titulo);
        
        model.addAttribute("tituloSugerencia", tituloSugerencia);
        
        model.addAttribute("descripcionSugerencia", descripcionSugerencia);

        return "/paginasSugerencias/EDITARSugerencia";
    }
}
