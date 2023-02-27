/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearBocadilloDeLaSemana {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @GetMapping("/crearBocadilloDeLaSemana")
    public String inici(Model model) {

        String ces = "Crear Entrepà de la setmana";
        model.addAttribute("crearES", ces);

        var be = new Receta();
        be.setNombre("EntrepaPernil");
        be.setDescripcion("Entrepa de pernil");

        var be2 = new Receta();
        be2.setNombre("EntrepaDeFormatge");
        be2.setDescripcion("Entrepa de formatge");

        var recetas = new ArrayList<Receta>();
        recetas.add(be);
        recetas.add(be2);

        model.addAttribute("recetas", recetas);
        return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana"; //Retorna la pàgina iniciEnviarDades
    }

}
