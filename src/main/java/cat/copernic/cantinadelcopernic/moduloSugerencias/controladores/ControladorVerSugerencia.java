/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;


import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorVerSugerencia {
    
    @Autowired
    private SugerenciaService SugerenciaService;
    
    @GetMapping("/verSuggeriment/{idSugerencia}")
    public String inici(Sugerencia sugerencia, Model model){
        
        /*var sugerencia2 = new Sugerencia();
        sugerencia2.setTitulo("titulo sugerencia");
        sugerencia2.setDescripcion("descripción sugerencia");*/
        
       /*var sugerenciaX = SugerenciaDao.findById(4);
        
        var sugerencia2 = sugerenciaX.get();*/
        
        model.addAttribute("sugerencia", SugerenciaService.buscarSugerencia(sugerencia));
        
        var titulo = "VEURE SUGGERIMENT";
        
        var tituloSugerencia = "Titul del suggeriment:";
        
        var descripcioSuggerimrnt = "Descripció del suggeriment:";
        
        model.addAttribute("titulo", titulo);
        
        model.addAttribute("tituloSugerencia", tituloSugerencia);
        
        model.addAttribute("descripcioSuggerimrnt", descripcioSuggerimrnt);
        
        return "/paginasSugerencias/verSugerencia"; 
    }
}
