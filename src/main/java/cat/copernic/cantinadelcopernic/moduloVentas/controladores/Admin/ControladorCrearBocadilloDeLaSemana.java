/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/crearBocadilloDeLaSemana")
    public String inici(Model model) {

        String ces = "Crear Entrepà de la setmana";
        model.addAttribute("crearES", ces);

        //bocadilloSemana
        var bocadillosDeLaSemana = ventasSer.listarBocadilloSemana();
        
        var b = bocadillosDeLaSemana.get(1).getImagen();
        //recetas
        var recetas = ventasSer.listarRecetas();

        model.addAttribute("listboca", bocadillosDeLaSemana);
        model.addAttribute("listrecetas", recetas);
         model.addAttribute("imagen", b);

        return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana"; //Retorna la pàgina iniciEnviarDades
    }
    
    @PostMapping("/guardarBocaSemana") //action=guardarGos
    public String guardarGos(BocadilloSemana bocaSemana) {

        ventasSer.addBocadilloSemana(bocaSemana); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/pedidosAdministrador"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }

}
