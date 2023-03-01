/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorEditarTarea {

    @GetMapping("/editarTarea")
    public String inici(Model model) {
        
        //EJEMPLO
        ArrayList<TipoTarea> listaTiposTarea = new ArrayList<>();
        TipoTarea tipoTarea1 = new TipoTarea();
        TipoTarea tipoTarea2 = new TipoTarea();
        tipoTarea1.setId(1);
        tipoTarea2.setId(2);
        tipoTarea1.setNombre("Fregar");
        tipoTarea2.setNombre("Barrer");
        
        listaTiposTarea.add(tipoTarea1);
        listaTiposTarea.add(tipoTarea2);
        //EJEMPLO
        
        
        model.addAttribute("editarTareaWord", "Editar tasca");
        model.addAttribute("alumneWord", "Alumne: ");
        model.addAttribute("fechaWord", "Data: ");
        model.addAttribute("tipoTareaWord", "Tipus de tasca: ");
        model.addAttribute("cancelarWord", "Cancel·lar");
        model.addAttribute("listaTiposTarea", listaTiposTarea);
        
        return "/paginasTareas/editarTarea";
    }
}
