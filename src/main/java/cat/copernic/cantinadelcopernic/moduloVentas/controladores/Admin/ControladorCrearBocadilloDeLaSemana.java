/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
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
 * Esta clase es un controlador encargado de manejar las peticiones relacionadas
 * con la creación de bocadillos de la semana.
 */
@Controller
public class ControladorCrearBocadilloDeLaSemana {

    /**
     *
     * Esta anotación permite la inyección automática de una instancia de la
     * clase VentasService al controlador.
     */
    @Autowired
    private VentasService ventasSer;
    /**
     *
     * Esta anotación permite la inyección automática de una instancia de la
     * clase ProduccionService al controlador.
     */
    @Autowired
    private ProduccionService prodSer;

    /**
     *
     * Maneja las peticiones GET relacionadas con la creación de un formulario
     * de bocadillo de la semana.
     *
     * @param bocadillosemana objeto de la clase BocadilloSemana
     * @param model objeto de la clase Model, que permite transferir datos entre
     * el controlador y la vista
     * @return la vista que contiene el formulario para crear el bocadillo de la
     * semana
     */
    @GetMapping("/crearFormularioBocadilloSemana")
    public String crearFormularioBocadilloSemana(BocadilloSemana bocadillosemana, Model model) {
        model.addAttribute("recetas", prodSer.obtenerRecetas());
        return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana";
    }

    /**
     *
     * Maneja las peticiones POST relacionadas con la creación y guardado de un
     * nuevo bocadillo de la semana.
     *
     * @param bocadilloSemana objeto de la clase BocadilloSemana, validado con
     * la anotación @Valid
     *
     * @param errors objeto de la clase Errors, que contiene los errores de
     * validación del objeto BocadilloSemana
     *
     * @param model objeto de la clase Model, que permite transferir datos entre
     * el controlador y la vista
     *
     * @return la vista que muestra la lista de bocadillos de la semana si la
     * creación fue exitosa, o la vista del formulario de creación si hubo
     * errores de validación.
     */
    @PostMapping("/guardarBocaSemana")
    public String guardarBocadilloSemana(@Valid BocadilloSemana bocadilloSemana, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("recetas", prodSer.obtenerRecetas());
            return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana";
        }

// Guardar la imagen en el sistema de archivos
        bocadilloSemana.setImagen("asdasdasdasdasdasdasdasd");

        var receta = prodSer.buscarReceta(bocadilloSemana.getReceta());

        bocadilloSemana.setReceta(receta);
        ventasSer.addBocadilloSemana(bocadilloSemana);

        return "redirect:/listaBocadilloSemana";
    }

    /**
     *
     * Método que se encarga de cargar el formulario para editar un bocadillo de
     * la semana.Recibe como parámetros el objeto BocadilloSemana y el objeto
 Model.Se agrega al modelo la lista de recetas disponibles para seleccionar.
     *
     * @param bocadilloSemana
     * @param model
     * @return la vista para crear un bocadillo de la semana.
     */
    @GetMapping("/editar/{idbocadillo_semana}")
    public String editarBocadilloSemana(BocadilloSemana bocadilloSemana, Model model) {

        model.addAttribute("recetas", prodSer.obtenerRecetas());
        model.addAttribute("bocadilloSemana", ventasSer.buscarBocadilloSemana(bocadilloSemana));

        return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana";
    }

    /**
     *
     * Método que se encarga de eliminar un bocadillo de la semana.Recibe como
 parámetro el objeto BocadilloSemana. Se busca el bocadillo a eliminar y se llama al método de eliminación de
 la capa de servicio.
     *
     * @param bocadilloSemana
     * @return la vista de la lista de bocadillos de la semana.
     */
    @GetMapping("/eliminarbocadillo/{idbocadillo_semana}")
    public String eliminarBocadilloSemana(BocadilloSemana bocadilloSemana) {

        var bocadilloeliminar = ventasSer.buscarBocadilloSemana(bocadilloSemana);
        ventasSer.eliminarBocadilloSemana(bocadilloeliminar);
        return "redirect:/listaBocadilloSemana";
    }
}
