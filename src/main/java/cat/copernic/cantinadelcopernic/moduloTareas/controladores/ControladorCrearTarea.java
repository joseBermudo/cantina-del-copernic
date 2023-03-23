/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.DAO.TipoTareaDAO;
import cat.copernic.cantinadelcopernic.modelo.Tarea;
import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import cat.copernic.cantinadelcopernic.moduloTareas.controladores.servicios.TareaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTarea {

    @Autowired 
    private TareaService tareaService;

    @GetMapping("/crearTarea")
    public String inici(Model model) {

        model.addAttribute("listaTiposTarea", tareaService.llistarTipoTarea());

        model.addAttribute("tarea", new Tarea());

        model.addAttribute("crearTareaWord", "Crear nova tasca");
        model.addAttribute("alumneWord", "Alumne: ");
        model.addAttribute("fechaWord", "Data: ");
        model.addAttribute("tipoTareaWord", "Tipus de tasca: ");
        model.addAttribute("cancelarWord", "Cancel·lar");

        return "/paginasTareas/crearTarea";
    }

    
    @PostMapping("/guardarTarea")
    public String guardarTarea(Tarea tarea) {

        tareaService.afegirTarea(tarea);

        return "redirect:/listarTareas";
    }
    
    @GetMapping("/eliminarTarea/{id}") 
    public String eliminarTarea(Tarea tarea) {

        var todasTareasTarea = tareaService.cercarTarea(tarea);
        
        tareaService.eliminarTarea(todasTareasTarea);
        
        return "redirect:/listarTareas"; 
    }
}
