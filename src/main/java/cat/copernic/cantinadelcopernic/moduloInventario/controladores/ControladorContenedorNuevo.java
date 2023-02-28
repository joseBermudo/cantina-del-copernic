/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
public class ControladorContenedorNuevo {
     @GetMapping("/contenedorNuevo")
    public String inici(Model model) {
        
        
        return "/paginasUtensilios/contenedorNuevo";
    }
}
