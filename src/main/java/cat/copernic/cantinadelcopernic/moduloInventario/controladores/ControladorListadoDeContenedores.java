/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;

import cat.copernic.cantinadelcopernic.moduloInventario.servicios.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Esta clase es un controlador que maneja la página de listado de contenedores
 * del inventario.
 *
 * Utiliza la anotación "@Controller" para indicar que es un controlador de
 * Spring MVC.
 */
@Controller
public class ControladorListadoDeContenedores {

    /**
     *
     * Esta variable de instancia utiliza la anotación "@Autowired" para
     * inyectar la dependencia de InventarioService.
     */
    @Autowired
    private InventarioService invSer;

    /**
     *
     * Este método maneja la solicitud GET para la página de listado de
     * contenedores.
     *
     * Utiliza la anotación "@GetMapping" para mapear la URL
     * "/listadoDeContenedores".
     *
     * @param model El modelo de Spring utilizado para pasar datos a la vista.
     *
     * @return La vista "paginasInventario/listadoDeContenedores".
     */
    @GetMapping("/listadoDeContenedores")
    public String inici(Model model) {

// Llama al método listarContenedores() de InventarioService para obtener una lista de contenedores.
        var contenedor = invSer.listarContenedores();

// Añade la lista de contenedores al modelo para que se pueda utilizar en la vista.
        model.addAttribute("contenedor", contenedor);

// Retorna el nombre de la vista que se debe mostrar al usuario.
        return "/paginasInventario/listadoDeContenedores";
    }
}
