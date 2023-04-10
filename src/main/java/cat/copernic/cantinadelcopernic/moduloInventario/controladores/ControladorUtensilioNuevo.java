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
 * @author Enric
 */
@Controller
public class ControladorUtensilioNuevo {

    @Autowired
    private InventarioService invSer;

    @GetMapping("/utensilioNuevo/{idcontenedor}")
    public String inici(Model model, Contenedor contenedor, Utensilio utensilio) {
        //model.addAttribute("contenedor",contenedor);
        ContenedorSingleton.getInstance();
        ContenedorSingleton.setInformacion(contenedor.getIdcontenedor());

        return "/paginasInventario/UtensilioNuevo";
    }

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

    @GetMapping("/eliminarUtensilio/{idutensilio}")
    public String eliminarUtensilio(Utensilio utensilio) {
        
        Utensilio u = invSer.buscarUtensilio(utensilio);
        Contenedor c = invSer.buscarContenedor(u.getContenedor());
        invSer.eliminarUtensilio(utensilio);
        
        return "redirect:/editarContenedor/" + c.getIdcontenedor();
    }

}
