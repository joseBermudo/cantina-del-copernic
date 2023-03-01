/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.modelo.Bebida;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joseb
 */
@Controller
@Slf4j
public class ControladorListaBebidas {
    
    @Autowired
    BebidaDAO bebidaDAO;
    
    @GetMapping("/listaBebidas")
    public String inici(Model model) {
        
       
        model.addAttribute("bebidas", bebidaDAO.findAll());
        return "/paginasProduccion/listaBebidas";
    }
    
}
