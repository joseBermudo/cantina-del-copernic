/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;

import cat.copernic.cantinadelcopernic.DAO.ContenedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */

@Controller
public class ControladorListadoDeContenedores {
    @Autowired
    private ContenedorDAO contDAO;
    
    @GetMapping("/listadoDeContenedores")
    public String inici(Model model) {
        
        
           
        var contenedor = contDAO.findAll();
        model.addAttribute("contenedor", contenedor);
        
        
        
        return "/paginasInventario/listadoDeContenedores";
    }
}
