/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloLimpieza.controladores;

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
public class ControladorListarTiposTarea {

    @GetMapping("/listarTiposTarea")
    public String inici(Model model) {

        model.addAttribute("listadoTipoTareaWord", "Llistat tipus de tasques");
        model.addAttribute("atrasWord", "Enrrere");
        model.addAttribute("eliminarWord", "Eliminar");
        
        TipoTarea tipoTareaEjemplo = new TipoTarea();
        tipoTareaEjemplo.setId(1);
        tipoTareaEjemplo.setNombre("Ejemplo de nombre para tipo de tarea");
        ArrayList<TipoTarea> listadoTiposTarea = new ArrayList<>();
        listadoTiposTarea.add(tipoTareaEjemplo); // Agregar el objeto a la lista

        model.addAttribute("listadoTiposTarea", listadoTiposTarea);

        model.addAttribute("tiposTareaWord", "Tipus de tasques");
        model.addAttribute("noHayTiposTareaWord", "No hi ha tipus de tasques");

        model.addAttribute("cancelarWord", "Cancel·lar");
        model.addAttribute("listaTareasWord", "Llistat de Tasques");
        model.addAttribute("crearTipoTareaWord", "Crear nou tipus de tasca");

        return "/paginasTareas/listarTiposTarea";
    }
}
