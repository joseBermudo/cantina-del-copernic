/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.DAO.DeudaDAO;
import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloDeudas.servicios.DeudaService;
import java.sql.Date;
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
public class ControladorListarDeudasAlumno {
    
    @Autowired
    private DeudaService deudaService;
    @GetMapping("/listarDeudasAlumno")
    public String listarDeudasAlumno(Model model) {
        
        model.addAttribute("listadoDeudas", deudaService.listarDeudas());
        
        return "/paginasDeudas/listarDeudasAlumno"; 
    }
}