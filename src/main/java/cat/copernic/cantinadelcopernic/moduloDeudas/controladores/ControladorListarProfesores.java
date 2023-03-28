/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.DAO.ProfesorDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
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
public class ControladorListarProfesores {

    @Autowired
    ProfesorDAO profesorDAO;
    @GetMapping("/listarProfesores")
    public String listarProfesores(Model model) {
        
        model.addAttribute("listadoProfesores", profesorDAO.findAll());
        
        return "/paginasDeudas/listarProfesores"; 
    }
}
