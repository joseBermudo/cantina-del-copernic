/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.DAO.TareaDAO;
import cat.copernic.cantinadelcopernic.modelo.Tarea;
import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorListarTareas {
    
    @Autowired
    TareaDAO tareaDAO;
    @GetMapping("/listarTareas")
    public String inici(Model model) {

        model.addAttribute("listadoTareaWord", "Llista de tasques");
        
        model.addAttribute("listadoTarea", tareaDAO.findAll());
        
        model.addAttribute("tareaWord", "Tasca");
        model.addAttribute("fechaWord", "Data");
        model.addAttribute("alumnoWord", "Alumne");
        model.addAttribute("horarioWord", "Horari");
        model.addAttribute("editarWord", "Editar");
        model.addAttribute("crearTareaWord", "Crear nova tasca");
        model.addAttribute("verTipoTareaWord", "Veure tipus de tasques");
        model.addAttribute("noHayTareasWord", "No hi ha tasques");

        return "/paginasTareas/listarTareas";
    }
}
