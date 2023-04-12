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
 * Esta clase es un controlador para crear y eliminar tipos de tarea.
 *
 * @author Enric
 */
@Controller
public class ControladorCrearTipoTarea {

    @Autowired
    private TareaService tareaService;

    /**
     *
     * Este método maneja las peticiones GET al endpoint "/crearTipoTarea".
     *
     * Agrega un objeto "tipoTarea" al modelo y devuelve la vista para crear un
     * tipo de tarea.
     *
     * @param model el modelo para agregar el objeto "tipoTarea"
     *
     * @return la vista "/paginasTareas/crearTipoTarea"
     */
    @GetMapping("/crearTipoTarea")
    public String crearTipoTarea(Model model) {

        model.addAttribute("tipoTarea", new TipoTarea(0));
        return "/paginasTareas/crearTipoTarea";
    }

    /**
     *
     * Este método maneja las peticiones POST al endpoint "/guardarTipoTarea".
     *
     * Si el objeto "tipoTarea" es válido, se guarda en la base de datos a
     * través del "tareaService".
     *
     * En caso contrario, se devuelve la vista para crear un tipo de tarea con
     * los errores correspondientes.
     *
     * @param tipoTarea el objeto "tipoTarea" a guardar
     *
     * @param errors los errores de validación del objeto "tipoTarea"
     *
     * @param model el modelo para agregar mensajes de error
     *
     * @return una redirección al endpoint "/listarTiposTarea"
     */
    @PostMapping("/guardarTipoTarea")
    public String guardarTipoTarea(@Valid TipoTarea tipoTarea, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "/paginasTareas/crearTipoTarea";
        }
        tareaService.afegirTipoTarea(tipoTarea);

        return "redirect:/listarTiposTarea";
    }

    /**
     *
     * Este método maneja las peticiones GET al endpoint
     * "/eliminarTipoTarea/{id}".
     *
     * Busca todas las tareas asociadas al objeto "tipoTarea" y las elimina a
     * través del "tareaService".
     *
     * @param tipoTarea el objeto "tipoTarea" a eliminar
     *
     * @return una redirección al endpoint "/listarTiposTarea"
     */
    @GetMapping("/eliminarTipoTarea/{id}")
    public String eliminarTipoTarea(TipoTarea tipoTarea) {

        var todasTareasTipoTarea = tareaService.cercarTipoTarea(tipoTarea);

        tareaService.eliminarTipoTarea(todasTareasTipoTarea);

        return "redirect:/listarTiposTarea";
    }
}
