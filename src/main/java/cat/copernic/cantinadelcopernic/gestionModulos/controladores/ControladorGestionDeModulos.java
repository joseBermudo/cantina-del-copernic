/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.gestionModulos.controladores;

import cat.copernic.cantinadelcopernic.DAO.ModuloDAO;
import cat.copernic.cantinadelcopernic.gestionModulos.servicios.GestionModulosService;
import cat.copernic.cantinadelcopernic.modelo.Modulo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorGestionDeModulos {
    
    @Autowired
    private GestionModulosService servModulos;
    
    private String nombreBoton = "Guardar cambis";
    private String tituloPagina="Llista de móduls";
    
     @GetMapping("/gestioModuls")
      public String inici(Model model){
          
          List<Modulo> modulos = servModulos.listarModulos();
         
          model.addAttribute("modulos",modulos);
          model.addAttribute("nombreBoton",nombreBoton);
          model.addAttribute("tituloPagina",tituloPagina);
          return "/paginasGestionModulos/listadoModulos"; 
      }
}
