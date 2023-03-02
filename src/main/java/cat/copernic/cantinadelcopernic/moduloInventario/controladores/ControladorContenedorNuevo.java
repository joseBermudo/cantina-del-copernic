/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.controladores;

import cat.copernic.cantinadelcopernic.DAO.ContenedorDAO;
import cat.copernic.cantinadelcopernic.DAO.UtensilioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorContenedorNuevo {

    @Autowired
    private ContenedorDAO contDAO;

    @Autowired
    private UtensilioDAO utenDAO;

    @GetMapping("/contenedorNuevo")
    public String inici(Model model) {

        var contenedor = contDAO.findAll();
        model.addAttribute("contenedor", contenedor);

        var utensilios = utenDAO.findAll();
        model.addAttribute("utensilios", utensilios);

        return "/paginasInventario/contenedorNuevo";
    }
}

