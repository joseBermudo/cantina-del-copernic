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
 * @author Enric
 */
@Controller
public class ControladorListarDeudasAdministrador {

    @Autowired
    private DeudaService deudaService;

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/listarDeudasAdministrador/{correo}")
    public String inici(Model model, Profesor profesor) {

        var profe = profesorService.buscarProfesores(profesor);

        model.addAttribute("datosProfesor", profe);
        model.addAttribute("listadoDeudas", profe.getDeudas());

        return "/paginasDeudas/listarDeudasAdministrador";
    }

    @GetMapping("/crearDeuda/{correo}")
    public String crearDeuda(Model model, Deuda deuda, Profesor profesor) {

        model.addAttribute("correo", deudaService.buscarProfesor(profesor).getCorreo());
        return "/paginasDeudas/crearDeuda";
    }

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

    @GetMapping("/eliminarDeuda/{idDeuda}")
    public String eliminarDeuda(Deuda deuda) {

        var objetoDeuda = deudaService.buscarDeudaPorId(deuda.getIdDeuda());
        var correoProfesor = objetoDeuda.getProfesor().getCorreo();
        deudaService.eliminarDeuda(objetoDeuda);

        return "redirect:/listarDeudasAdministrador/" + correoProfesor;
    }

    @GetMapping("/editarDeuda/{idDeuda}")
    public String editarDeuda(Deuda deuda, Model model) {

        model.addAttribute("deuda", deudaService.buscarDeuda(deuda));

        return "/paginasDeudas/editarDeuda";
    }
}
