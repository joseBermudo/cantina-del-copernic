/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import cat.copernic.cantinadelcopernic.moduloTareas.controladores.servicios.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTipoTarea {
    
    @Autowired 
    private TareaService tareaService;

    
    @GetMapping("/crearTipoTarea")
    public String crearTipoTarea(Model model) {
        
        model.addAttribute("tipoTarea", new TipoTarea(0));
        return "/paginasTareas/crearTipoTarea"; 
    }
    
    @PostMapping("/guardarTipoTarea")
    public String guardarTipoTarea(@Valid TipoTarea tipoTarea, Errors errors, Model model) {

        if(errors.hasErrors()){
            return "/paginasTareas/crearTipoTarea";
        }
        tareaService.afegirTipoTarea(tipoTarea);

        return "redirect:/listarTiposTarea";
    }
    
    @GetMapping("/eliminarTipoTarea/{id}") 
    public String eliminarTipoTarea(TipoTarea tipoTarea) {

        var todasTareasTipoTarea = tareaService.cercarTipoTarea(tipoTarea);
        
        tareaService.eliminarTipoTarea(todasTareasTipoTarea);
        
        return "redirect:/listarTiposTarea"; 
    }
}
