/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearBocadilloDeLaSemana {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @Autowired
    private VentasService ventasSer;

    @Autowired
    private RecetaDAO recDADO;

    @GetMapping("/crearFormularioBocadilloSemana")
    public String crearFormularioBocadilloSemana(BocadilloSemana bocadillosemana, Model model) {
        model.addAttribute("recetas", recDADO.findAll());
        //model.addAttribute("bocadillosemana", bocadillosemana);
        return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana";
    }

    @PostMapping("/guardarBocaSemana")
    public String guardarBocadilloSemana(@Valid BocadilloSemana bocadilloSemana, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("recetas", recDADO.findAll());

            return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana";
        }
//        try {
//            // Guardar la imagen en el sistema de archivos
//            Files.write(Paths.get("/imagenes/imagen.jpg"), bocadilloSemana.getImagen().getBytes());
        bocadilloSemana.setImagen("asdasdasdasdasdasdasdasd");

        var receta = recDADO.findById(bocadilloSemana.getReceta().getId()).get();

        bocadilloSemana.setReceta(receta);
        ventasSer.addBocadilloSemana(bocadilloSemana);
//            return "redirect:/listadoBocadilloSemana";
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Error al guardar la imagen";
//        }

        return "redirect:/listaBocadilloSemana";

    }

    @GetMapping("/editar/{idbocadillo_semana}")
    public String editarBocadilloSemana(BocadilloSemana bocadilloSemana, Model model) {

        model.addAttribute("recetas", recDADO.findAll());
        model.addAttribute("bocadillosemana", ventasSer.buscarBocadilloSemana(bocadilloSemana));

        return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana";
    }

    @GetMapping("/eliminarbocadillo/{idbocadillo_semana}")
    public String eliminarBocadilloSemana(BocadilloSemana bocadilloSemana) {

        var bocadilloeliminar = ventasSer.buscarBocadilloSemana(bocadilloSemana);
        ventasSer.eliminarBocadilloSemana(bocadilloeliminar);
        return "redirect:/listaBocadilloSemana";
    }

}
