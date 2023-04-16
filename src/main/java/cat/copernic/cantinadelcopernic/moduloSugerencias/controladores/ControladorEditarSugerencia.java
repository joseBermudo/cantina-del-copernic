    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;

import cat.copernic.cantinadelcopernic.DAO.SugerenciaDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Clase que actua de controlador para la página de editar una sugerencia
 * @author andre
 */
@Controller
public class ControladorEditarSugerencia {

    @Autowired
    private SugerenciaService sugerenciaService;
    
    
    @GetMapping("/editarSuggeriment/{idSugerencia}")
    /**
     * función que sirve para guardar los cambios de una sugerencia
     * @param sugerencia sugerencia que se va editar
     * @param model 
     * @return la pantalla html para editar las sugerencias
     */
    public String inici(Sugerencia sugerencia, Model model) {

        /*var sugerencia = new Sugerencia();
        sugerencia.setTitulo("titulo sugerencia");
        sugerencia.setDescripcion("descripción sugerencia");*/
 /*var sugerenciaX = SugerenciaDao.findById(4);
        
        var sugerencia2X = sugerenciaX.get();
        
        model.addAttribute("sugerencia", sugerencia2X);*/
        model.addAttribute("sugerencia", sugerenciaService.buscarSugerencia(sugerencia));

        var titulo = "EDITAR SUGGERIMENT";
        var tituloSugerencia = "Titul del suggeriment:";
        var descripcionSugerencia = "Descripció del suggeriment:";
        
        var esCrearSugerencia = false;
        var esEditarSugerencia = true;

        model.addAttribute("titulo", titulo);

        model.addAttribute("tituloSugerencia", tituloSugerencia);

        model.addAttribute("descripcionSugerencia", descripcionSugerencia);
        
        model.addAttribute("esCrearSugerencia", esCrearSugerencia);
        
        model.addAttribute("esEditarSugerencia", esEditarSugerencia);

        return "/paginasSugerencias/nuevaSugerencia";
    }
    
}
