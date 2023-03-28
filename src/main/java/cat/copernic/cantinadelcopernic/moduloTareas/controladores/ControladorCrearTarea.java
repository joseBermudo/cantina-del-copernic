/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.DAO.TipoTareaDAO;
import cat.copernic.cantinadelcopernic.modelo.Tarea;
import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import cat.copernic.cantinadelcopernic.moduloTareas.controladores.servicios.TareaService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTarea {

    @Autowired 
    private TareaService tareaService;
    
    @PostMapping("/guardarTarea")
    public String guardarTarea(@Valid Tarea tarea, Errors errors, Model model) {
        
        if(errors.hasErrors()){
            model.addAttribute("listaTiposTarea", tareaService.llistarTipoTarea());
            model.addAttribute("tarea", new Tarea());

            return "/paginasTareas/crearTarea";
        }
        
        tareaService.afegirTarea(tarea);

        return "redirect:/listarTareas";
    }
    
    @GetMapping("/crearTarea")
    public String crearTarea(Model model) {

        model.addAttribute("listaTiposTarea", tareaService.llistarTipoTarea());
        model.addAttribute("tarea", new Tarea());
        
        return "/paginasTareas/crearTarea";
    }
    @GetMapping("/eliminarTarea/{id}") 
    public String eliminarTarea(Tarea tarea) {

        var todasTareasTarea = tareaService.cercarTarea(tarea);
        
        tareaService.eliminarTarea(todasTareasTarea);
        
        return "redirect:/listarTareas"; 
    }

    @GetMapping("/editarTarea/{id}")
    public String editarTarea(Tarea tarea, Model model) {
        
        model.addAttribute("listaTiposTarea", tareaService.llistarTipoTarea());
        model.addAttribute("tarea", tareaService.cercarTarea(tarea));
        
        return "/paginasTareas/editarTarea";
    }
}
