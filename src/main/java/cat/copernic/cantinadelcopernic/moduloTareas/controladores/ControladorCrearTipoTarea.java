/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import cat.copernic.cantinadelcopernic.moduloTareas.controladores.servicios.TareaService;
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
public class ControladorCrearTipoTarea {
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private TareaService tareaService;

    
    @GetMapping("/crearTipoTarea")
    public String inici(Model model) {
        
        model.addAttribute("crearTipoTareaWord", "Crear tipus de tasca");
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("nombreTipoTareaWord", "Nom tipus de tasca");
        model.addAttribute("cancelarWord", "Cancel·lar");
        
        // Create a new TipoTarea object with a valid id and add it to the model
        model.addAttribute("tipoTarea", new TipoTarea(0));
        
        return "/paginasTareas/crearTipoTarea"; 
    }
    
    @PostMapping("/guardarTipoTarea")
    public String guardarTipoTarea(TipoTarea tipoTarea) {

        tareaService.afegirTipoTarea(tipoTarea);

        return "redirect:/listarTiposTarea";
    }
    
    @GetMapping("/eliminarTipoTarea/{id}") 
    public String eliminarTipoTarea(TipoTarea tipoTarea) {

        tareaService.eliminarTipoTarea(tipoTarea);
        
        return "redirect:/listarTiposTarea"; 
    }
}
