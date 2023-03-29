/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;

import cat.copernic.cantinadelcopernic.DAO.ContenedorDAO;
import cat.copernic.cantinadelcopernic.DAO.UtensilioDAO;
import cat.copernic.cantinadelcopernic.modelo.Contenedor;
import cat.copernic.cantinadelcopernic.moduloInventario.servicios.InventarioService;
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
public class ControladorContenedorNuevo {
    
    @Autowired
    private InventarioService invSer;
    
    @GetMapping("/contenedorNuevo")
    public String inici(Model model,Contenedor contenedor) { 
        model.addAttribute("contenedor",new Contenedor());
        return "/paginasInventario/contenedorNuevo";
    }
    
    @PostMapping("/guardarContenedor")
    public String guardarContenedor(Contenedor contenedor) {
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
