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
 * Controlador para la creación, edición y eliminación de tareas.
 *
 * El controlador utiliza el framework Spring MVC y se encarga de manejar las
 * peticiones
 *
 * HTTP relacionadas con la gestión de tareas. Permite crear, editar y eliminar
 * tareas.
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTarea {

    @Autowired
    private TareaService tareaService;

    /**
     *
     * Guarda una nueva tarea en la base de datos.
     *
     * @param tarea objeto tarea a guardar
     *
     * @param errors objeto para manejar los errores de validación de los datos
     * de entrada
     *
     * @param model modelo que se utilizará para enviar información a la vista
     *
     * @return redirige a la página que lista todas las tareas después de
     * guardar la nueva tarea
     */
    @PostMapping("/guardarTarea")
    public String guardarTarea(@Valid Tarea tarea, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("listaTiposTarea", tareaService.llistarTipoTarea());

            return "/paginasTareas/crearTarea";
        }

        tareaService.afegirTarea(tarea);

        return "redirect:/listarTareas";
    }

    /**
     *
     * Muestra el formulario para crear una nueva tarea.
     *
     * @param model modelo que se utilizará para enviar información a la vista
     *
     * @return la página que contiene el formulario para crear una nueva tarea
     */
    @GetMapping("/crearTarea")
    public String crearTarea(Model model) {

        model.addAttribute("listaTiposTarea", tareaService.llistarTipoTarea());
        model.addAttribute("tarea", new Tarea());

        return "/paginasTareas/crearTarea";
    }

    /**
     *
     * Elimina una tarea existente.
     *
     * @param tarea objeto tarea a eliminar
     *
     * @return redirige a la página que lista todas las tareas después de
     * eliminar la tarea
     */
    @GetMapping("/eliminarTarea/{id}")
    public String eliminarTarea(Tarea tarea) {

        var todasTareasTarea = tareaService.cercarTarea(tarea);

        tareaService.eliminarTarea(todasTareasTarea);

        return "redirect:/listarTareas";
    }

    /**
     *
     * Muestra el formulario para editar una tarea existente.
     *
     * @param tarea objeto tarea a editar
     *
     * @param model modelo que se utilizará para enviar información a la vista
     *
     * @return la página que contiene el formulario para editar una tarea
     * existente
     */
    @GetMapping("/editarTarea/{id}")
    public String editarTarea(Tarea tarea, Model model) {

        model.addAttribute("listaTiposTarea", tareaService.llistarTipoTarea());
        model.addAttribute("tarea", tareaService.cercarTarea(tarea));

        return "/paginasTareas/editarTarea";
    }
}
