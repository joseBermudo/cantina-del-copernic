/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.utilities.RolSigleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorPerfilProfesor {
    
    @Autowired
    private ProfesorService profesorService;
    
    @GetMapping("/perfil/{correo}")
    public String inici(Profesor profesor, Model model){
        
        model.addAttribute("nombre", "Nom del professor");
        model.addAttribute("apellidos", "Cognoms del professor");
        model.addAttribute("apellidos", "Cognoms del professor");
        model.addAttribute("intoleranciaLactosa", "intolerància a la lactosa");
        model.addAttribute("intoleranciaGluten", "intolerància al gluten");
        model.addAttribute("intoleranciaHismatico", "intolerància a l'histaminic");
        model.addAttribute("intoleranciaFodmaps", "intolerància al FODMAP's");
        model.addAttribute("observaciones", "observaciones");
        var profesor2 = profesorService.buscarProfesores(profesor); 
        model.addAttribute("profesor",profesor2);
        RolSigleton.getInstance();
        RolSigleton.setInformacion(profesor2.getRols().getIdroles());
        
        return "/paginasRRHH/perfil";
    }
}
