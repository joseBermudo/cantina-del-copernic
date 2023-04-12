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
 * Controlador para la vista de listar tareas. Permite obtener todas las tareas
 * almacenadas en la base de datos y
 *
 * enviarlas a la vista para que sean mostradas.
 *
 * @author Enric
 */
@Controller
public class ControladorListarTareas {

    @Autowired
    TareaDAO tareaDAO;

    /**
     *
     * Método que se ejecuta al acceder a la URL "/listarTareas". Obtiene todas
     * las tareas almacenadas en la base de datos y las envía a la vista
     * "listarTareas" para que sean mostradas.
     *
     * @param model objeto Model que permite agregar atributos para que sean
     * usados en la vista.
     * @return un String con el nombre de la vista que se va a mostrar.
     */
    @GetMapping("/listarTareas")
    public String inici(Model model) {
        model.addAttribute("listadoTarea", tareaDAO.findAll());
        return "/paginasTareas/listarTareas";
    }
}
