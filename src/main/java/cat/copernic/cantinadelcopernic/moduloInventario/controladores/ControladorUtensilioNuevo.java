/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;

import cat.copernic.cantinadelcopernic.modelo.Contenedor;
import cat.copernic.cantinadelcopernic.modelo.Utensilio;
import cat.copernic.cantinadelcopernic.moduloInventario.servicios.InventarioService;
import cat.copernic.cantinadelcopernic.utilities.ContenedorSingleton;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * Esta clase es un controlador que maneja la creación y eliminación de
 * utensilios en el inventario.
 *
 * Utiliza la anotación "@Controller" para indicar que es un controlador de
 * Spring MVC.
 */
@Controller
public class ControladorUtensilioNuevo {

    /**
     *
     * Esta variable de instancia utiliza la anotación "@Autowired" para
     * inyectar la dependencia de InventarioService.
     */
    @Autowired
    private InventarioService invSer;

    /**
     *
     * Este método maneja la solicitud GET para la creación de un nuevo
     * utensilio.
     *
     * Utiliza la anotación "@GetMapping" para mapear la URL
     * "/utensilioNuevo/{idcontenedor}".
     *
     * @param model El modelo de Spring utilizado para pasar datos a la vista.
     *
     * @param contenedor El objeto Contenedor utilizado para obtener el id del
     * contenedor actual.
     *
     * @param utensilio El objeto Utensilio utilizado para crear un nuevo
     * utensilio.
     *
     * @return La vista "paginasInventario/UtensilioNuevo".
     */
    @GetMapping("/utensilioNuevo/{idcontenedor}")
    public String inici(Model model, Contenedor contenedor, Utensilio utensilio) {
//model.addAttribute("contenedor",contenedor);
        ContenedorSingleton.getInstance();
        ContenedorSingleton.setInformacion(contenedor.getIdcontenedor());

        return "/paginasInventario/UtensilioNuevo";
    }

    /**
     *
     * Este método maneja la solicitud POST para guardar un nuevo utensilio en
     * el inventario.
     *
     * Utiliza la anotación "@PostMapping" para mapear la URL
     * "/guardarUtensilio".
     *
     * @param utensilio El objeto Utensilio que se va a guardar en el
     * inventario.
     *
     * @param errors Objeto Errors utilizado para validar si hay errores en la
     * creación del utensilio.
     *
     * @return Redirige a la URL "/editarContenedor/{idcontenedor}" si el
     * utensilio se guarda correctamente, de lo contrario redirige a la URL
     * "/utensilioNuevo/{idcontenedor}".
     */
    @PostMapping("/guardarUtensilio")
    public String guardarUtensilio(@Valid Utensilio utensilio, Errors errors) {
        Contenedor c = new Contenedor();
        c.setIdcontenedor(ContenedorSingleton.getInformacion());
        if (errors.hasErrors()) {
            return "redirect:/utensilioNuevo/" + c.getIdcontenedor();
        }

        Contenedor contenedorB = invSer.buscarContenedor(c);
        utensilio.setContenedor(contenedorB);
        invSer.addUtensilio(utensilio);
        return "redirect:/editarContenedor/" + contenedorB.getIdcontenedor();
    }

    /**
     *
     * Este método maneja la solicitud GET para eliminar un utensilio del
     * inventario.
     *
     * Utiliza la anotación "@GetMapping" para mapear la URL
     * "/eliminarUtensilio/{idutensilio}".
     *
     * @param utensilio El objeto Utensilio que se va a eliminar del inventario.
     *
     * @return Redirige a la URL "/editarContenedor/{idcontenedor}" del
     * contenedor al que pertenece el utensilio.
     */
    @GetMapping("/eliminarUtensilio/{idutensilio}")
    public String eliminarUtensilio(Utensilio utensilio) {

        Utensilio u = invSer.buscarUtensilio(utensilio);
        Contenedor c = invSer.buscarContenedor(u.getContenedor());
        invSer.eliminarUtensilio(utensilio);

        return "redirect:/editarContenedor/" + c.getIdcontenedor();
    }

}
