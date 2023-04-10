/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;


import cat.copernic.cantinadelcopernic.modelo.Contenedor;
import cat.copernic.cantinadelcopernic.moduloInventario.servicios.InventarioService;
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
public class ControladorContenedorNuevo {
    
    @Autowired
    private InventarioService invSer;
    
    @GetMapping("/contenedorNuevo")
    public String inici(Model model,Contenedor contenedor) { 
        return "/paginasInventario/contenedorNuevo";
    }
    
    @PostMapping("/guardarContenedor")
    public String guardarContenedor(@Valid Contenedor contenedor, Errors errors) {
        
          if (errors.hasErrors()) {
            return "/paginasInventario/contenedorNuevo";
        }
               
        invSer.addContenedor(contenedor);
        return "redirect:/listadoDeContenedores";
    }
    
        
    @PostMapping("/guardarEditarContenedor")
    public String guardarEditarContenedor(@Valid Contenedor contenedor, Errors errors) {
        
          if (errors.hasErrors()) {
            return "/paginasInventario/contenedorEditar";
        }
               
        invSer.addContenedor(contenedor);
        return "redirect:/listadoDeContenedores";
    }
    
    @GetMapping("/editarContenedor/{idcontenedor}")
    public String editarContenedor(Contenedor contenedor, Model model) {  
        model.addAttribute("contenedor", invSer.buscarContenedor(contenedor));
        return "/paginasInventario/contenedorEditar";
    }
    
    
    
    
    
    @GetMapping("/eliminarContenedor/{idcontenedor}")
    public String eliminarContenedor(Contenedor contenedor) {
        var elimContenedor = invSer.buscarContenedor(contenedor);
        invSer.eliminarContenedor(elimContenedor);
        return "redirect:/listadoDeContenedores";
    }
    
}
