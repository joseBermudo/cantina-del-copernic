/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.modelo.Tarea;
import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorListarTareas {

    @GetMapping("/listarTareas")
    public String inici(Model model) {

        model.addAttribute("listadoTareaWord", "Llista de tasques");
        
        //EJEMPLO
        //Si el format final fos aquest, podria fer un mètode i quedaria millor
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEjemplo = null;
        try {
            fechaEjemplo = sdf.parse("01-03-2023");
        } catch (ParseException e) {
            System.out.println("Error al analizar la fecha: " + e.getMessage());
        }
        Tarea tareaEjemplo = new Tarea();
        tareaEjemplo.setId(1);
        tareaEjemplo.setAlumno("JuanAlberto");
        tareaEjemplo.setFecha(fechaEjemplo);
        TipoTarea tipoTareaEjemplo = new TipoTarea();
        tipoTareaEjemplo.setId(1);
        tipoTareaEjemplo.setNombre("Tarea de ejemplo");
        tareaEjemplo.setTipo(tipoTareaEjemplo);
        
        ArrayList<Tarea> listadoTarea = new ArrayList<>();
        listadoTarea.add(tareaEjemplo);

        model.addAttribute("listadoTarea", listadoTarea);
        //EJEMPLO
        
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
