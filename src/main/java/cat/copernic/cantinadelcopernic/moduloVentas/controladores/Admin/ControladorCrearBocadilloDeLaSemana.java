/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired 
    private BocadilloSemanaDAO bsDAO;
    @Autowired 
    private RecetaDAO recDAO;
    @GetMapping("/crearBocadilloDeLaSemana")
    public String inici(Model model) {

        String ces = "Crear Entrepà de la setmana";
        model.addAttribute("crearES", ces);

        
        
        //bocadilloSemana
         var bocadillosDeLaSemana = bsDAO.findAll();
        
         var bocadilloPernil = bsDAO.findById(1);
          
         var B= bocadilloPernil.get();
        
         
         //recetas
         var recetas = recDAO.findAll();
        
         
        model.addAttribute("bocSemana", B);
        model.addAttribute("recetas", recetas);
        
        return "/paginasVentas/ventasAdministrador/crearBocadilloDeLaSemana"; //Retorna la pàgina iniciEnviarDades
    }

}

