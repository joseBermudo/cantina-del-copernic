/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloDeudas.servicios.DeudaService;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * Controlador para listar, crear, editar y eliminar deudas desde una cuenta de
 * administrador.
 *
 * @author Enric
 */
@Controller
public class ControladorListarDeudasAdministrador {

    @Autowired
    private DeudaService deudaService;

    @Autowired
    private ProfesorService profesorService;

    /**
     *
     * Obtiene el listado de deudas de un profesor en particular y los muestra
     * en una vista.
     *
     * @param model El modelo que se usará para enviar datos a la vista.
     *
     * @param profesor El profesor del que se desean obtener las deudas.
     *
     * @return La vista con el listado de deudas.
     */
    @GetMapping("/listarDeudasAdministrador/{correo}")
    public String listarDeudasAdministrador(Model model, Profesor profesor) {

        var profe = profesorService.buscarProfesores(profesor);

        model.addAttribute("datosProfesor", profe);
        model.addAttribute("listadoDeudas", profe.getDeudas());

        return "/paginasDeudas/listarDeudasAdministrador";
    }

    /**
     *
     * Muestra la vista para crear una nueva deuda asociada a un profesor en
     * particular.
     *
     * @param model El modelo que se usará para enviar datos a la vista.
     *
     * @param deuda La nueva deuda a crear.
     *
     * @param profesor El profesor asociado a la nueva deuda.
     *
     * @return La vista para crear una nueva deuda.
     */
    @GetMapping("/crearDeuda/{correo}")
    public String crearDeuda(Model model, Deuda deuda, Profesor profesor) {

        model.addAttribute("correo", deudaService.buscarProfesor(profesor).getCorreo());
        return "/paginasDeudas/crearDeuda";
    }

    /**
     *
     * Guarda una nueva deuda asociada a un profesor en particular.
     *
     * @param deuda La nueva deuda a guardar.
     *
     * @param profesor El profesor asociado a la nueva deuda.
     *
     * @param errors Los errores que se hayan presentado al validar la nueva
     * deuda.
     *
     * @param model El modelo que se usará para enviar datos a la vista.
     *
     * @return Una redirección al listado de deudas actualizado.
     */
    @PostMapping("/guardarDeuda/{correo}")
    public String guardarDeuda(@Valid Deuda deuda, Profesor profesor, Errors errors, Model model) {

        System.out.println(deudaService.buscarProfesor(profesor).getCorreo());

        if (errors.hasErrors()) {
            model.addAttribute("correo", deudaService.buscarProfesor(profesor).getCorreo());
            return "/paginasDeudas/crearDeuda";
        }
        deuda.setProfesor(deudaService.buscarProfesor(profesor));
        deudaService.anadirDeuda(deuda);

        return "redirect:/listarDeudasAdministrador/{correo}";
    }

    /**
     *
     * Elimina una deuda en particular.
     *
     * @param deuda La deuda a eliminar.
     *
     * @return Una redirección al listado de deudas actualizado.
     */
    @GetMapping("/eliminarDeuda/{idDeuda}")
    public String eliminarDeuda(Deuda deuda) {

        var objetoDeuda = deudaService.buscarDeudaPorId(deuda.getIdDeuda());
        var correoProfesor = objetoDeuda.getProfesor().getCorreo();
        deudaService.eliminarDeuda(objetoDeuda);

        return "redirect:/listarDeudasAdministrador/" + correoProfesor;
    }
    /**
     *
     * Edita una deuda en particular.
     *
     * @param deuda La deuda a editar.
     * @param model
     *
     * @return Una redirección al listado de deudas actualizado.
     */
    @GetMapping("/editarDeuda/{idDeuda}")
    public String editarDeuda(Deuda deuda, Model model) {

        model.addAttribute("deuda", deudaService.buscarDeuda(deuda));

        return "/paginasDeudas/editarDeuda";
    }
}
