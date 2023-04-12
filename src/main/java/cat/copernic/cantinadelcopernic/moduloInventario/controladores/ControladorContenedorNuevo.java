/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;

import cat.copernic.cantinadelcopernic.modelo.Contenedor;
import cat.copernic.cantinadelcopernic.moduloInventario.servicios.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Esta clase es un controlador Spring MVC para manejar las operaciones de alta,
 * modificación y eliminación de contenedores en el inventario de una empresa.
 */
@Controller
public class ControladorContenedorNuevo {

    @Autowired
    private InventarioService invSer;

    /**
     * Método para mostrar la página de creación de un nuevo contenedor.
     *
     * @param model el modelo de datos para la vista.
     * @param contenedor el objeto Contenedor a crear.
     * @return la vista para la página de creación de un nuevo contenedor.
     */
    @GetMapping("/contenedorNuevo")
    public String inici(Model model, Contenedor contenedor) {
        return "/paginasInventario/contenedorNuevo";
    }

    /**
     * Método para guardar un nuevo contenedor creado a través del formulario de
     * creación.
     *
     * @param contenedor el objeto Contenedor a guardar.
     * @param errors los errores de validación del formulario.
     * @return la vista para el listado de contenedores si el contenedor se
     * guardó correctamente, o la vista para la página de creación de un nuevo
     * contenedor si hubo errores de validación.
     */
    @PostMapping("/guardarContenedor")
    public String guardarContenedor(@Valid Contenedor contenedor, Errors errors) {

        if (errors.hasErrors()) {
            return "/paginasInventario/contenedorNuevo";
        }

        invSer.addContenedor(contenedor);
        return "redirect:/listadoDeContenedores";
    }

    /**
     * Método para guardar los cambios realizados en la edición de un contenedor
     * existente.
     *
     * @param contenedor el objeto Contenedor a guardar.
     * @param errors los errores de validación del formulario.
     * @return la vista para el listado de contenedores si el contenedor se
     * guardó correctamente, o la vista para la página de edición de un
     * contenedor si hubo errores de validación.
     */
    @PostMapping("/guardarEditarContenedor")
    public String guardarEditarContenedor(@Valid Contenedor contenedor, Errors errors) {

        if (errors.hasErrors()) {
            return "/paginasInventario/contenedorEditar";
        }

        invSer.addContenedor(contenedor);
        return "redirect:/listadoDeContenedores";
    }

    /**
     * Método para mostrar la página de edición de un contenedor existente.
     *
     * @param contenedor el objeto Contenedor a editar.
     * @param model el modelo de datos para la vista.
     * @return la vista para la página de edición de un contenedor existente.
     */
    @GetMapping("/editarContenedor/{idcontenedor}")
    public String editarContenedor(Contenedor contenedor, Model model) {
        model.addAttribute("contenedor", invSer.buscarContenedor(contenedor));
        return "/paginasInventario/contenedorEditar";
    }

    /**
     *
     * Método para para eliminar un contenedor.
     *
     * @param contenedor el contenedor a eliminar.
     * @return una cadena de redirección a la página del listado de
     * contenedores.
     */
    @GetMapping("/eliminarContenedor/{idcontenedor}")
    public String eliminarContenedor(Contenedor contenedor) {
        var elimContenedor = invSer.buscarContenedor(contenedor);
        invSer.eliminarContenedor(elimContenedor);
        return "redirect:/listadoDeContenedores";
    }

}
