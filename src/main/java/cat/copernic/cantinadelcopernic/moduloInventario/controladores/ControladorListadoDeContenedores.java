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


@Controller
public class ControladorListadoDeContenedores {
    
    @Autowired
    private InventarioService invSer;
    
    @GetMapping("/listadoDeContenedores")
    public String inici(Model model) {
        
        
           
        var contenedor = invSer.listarContenedores();
        model.addAttribute("contenedor", contenedor);
        
        
        
        return "/paginasInventario/listadoDeContenedores";
    }
}
