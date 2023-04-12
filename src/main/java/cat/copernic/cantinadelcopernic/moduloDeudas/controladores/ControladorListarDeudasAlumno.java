/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.DAO.DeudaDAO;
import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloDeudas.servicios.DeudaService;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import java.sql.Date;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Controlador encargado de listar las deudas de un alumno en particular.
 *
 * Inyecta los servicios de DeudaService y ProfesorService para obtener la
 * información necesaria.
 *
 * Contiene dos métodos GET, uno para listar todas las deudas de todos los
 * alumnos y otro para listar
 *
 * las deudas de un alumno en particular identificado por su correo electrónico.
 *
 * Ambos métodos retornan la vista "listarDeudasAlumno" que muestra el listado
 * de deudas correspondiente.
 *
 * @author Enric
 */
@Controller
public class ControladorListarDeudasAlumno {

    /**
     *
     * Servicio encargado de la gestión de las deudas.
     */
    @Autowired
    private DeudaService deudaService;
    /**
     *
     * Servicio encargado de la gestión de los profesores.
     */
    @Autowired
    private ProfesorService profesorService;

    /**
     *
     * Método GET encargado de listar todas las deudas de todos los alumnos.
     *
     * @param model modelo que se utiliza para pasar información a la vista.
     *
     * @return la vista "listarDeudasAlumno" que muestra el listado de deudas
     * correspondiente.
     */
    @GetMapping("/listarDeudasAlumno")
    public String listarDeudasAlumno(Model model) {

        model.addAttribute("listadoDeudas", deudaService.listarDeudas());

        return "/paginasDeudas/listarDeudasAlumno";
    }

    /**
     *
     * Método GET encargado de listar las deudas de un alumno en particular
     * identificado por su correo electrónico.
     *
     * @param model modelo que se utiliza para pasar información a la vista.
     *
     * @param profesor objeto Profesor que contiene el correo electrónico del
     * alumno del que se quieren listar las deudas.
     *
     * @return la vista "listarDeudasAlumno" que muestra el listado de deudas
     * correspondiente.
     */
    @GetMapping("/listarDeudasAlumno/{correo}")
    public String listarDeudasAlumno(Model model, Profesor profesor) {

        var profe = profesorService.buscarProfesores(profesor);

        model.addAttribute("datosProfesor", profe);
        model.addAttribute("listadoDeudas", profe.getDeudas());

        return "/paginasDeudas/listarDeudasAlumno";
    }
}
