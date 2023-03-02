/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.DAO.TipoTareaDAO;
import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTarea {

    @Autowired
    TipoTareaDAO tipoTareaDAO;
    @GetMapping("/crearTarea")
    public String inici(Model model) {
        
        model.addAttribute("listaTiposTarea", tipoTareaDAO.findAll());

        model.addAttribute("crearTareaWord", "Crear nova tasca");
        model.addAttribute("alumneWord", "Alumne: ");
        model.addAttribute("fechaWord", "Data: ");
        model.addAttribute("tipoTareaWord", "Tipus de tasca: ");
        model.addAttribute("cancelarWord", "Cancel·lar");
        
        return "/paginasTareas/crearTarea";
    }
}
