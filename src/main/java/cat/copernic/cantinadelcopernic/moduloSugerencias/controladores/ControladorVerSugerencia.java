/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;

import cat.copernic.cantinadelcopernic.DAO.SugerenciaDAO;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
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
     private SugerenciaDAO SugerenciaDao;
    
    @GetMapping("/verSuggeriment")
    public String inici(Model model){
        
        /*var sugerencia2 = new Sugerencia();
        sugerencia2.setTitulo("titulo sugerencia");
        sugerencia2.setDescripcion("descripción sugerencia");*/
        
       var sugerencia = SugerenciaDao.findById(4);
        
        var sugerencia2 = sugerencia.get();
        
        model.addAttribute("sugerencia", sugerencia2);
        
        var titulo = "VEURE SUGGERIMENT";
        
        var tituloSugerencia = "Titul del suggeriment:";
        
        var descripcioSuggerimrnt = "Descripció del suggeriment:";
        
        model.addAttribute("titulo", titulo);
        
        model.addAttribute("tituloSugerencia", tituloSugerencia);
        
        model.addAttribute("descripcioSuggerimrnt", descripcioSuggerimrnt);
        
        return "/paginasSugerencias/verSugerencia"; 
    }
}
