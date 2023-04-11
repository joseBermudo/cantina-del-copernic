/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.utilities.RolSigleton;
import cat.copernic.cantinadelcopernic.utilities.UsuarioActual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Clase que representa el controlador de la página para mostar la información de un profesor
 * @author andre
 */
@Controller
public class ControladorPerfilProfesor {
    
    @Autowired
    private ProfesorService profesorService;
    
    @GetMapping("/perfil")
    /**
     * funmción que e utiliza para recuperar la información del profesor logueado y mostarla
     * @param model
     * @return devuelve una pantalla donse se muestra el la información del profesor 
     */
    public String inici( Model model){
        
        model.addAttribute("nombre", "Nom del professor");
        model.addAttribute("apellidos", "Cognoms del professor");
        model.addAttribute("apellidos", "Cognoms del professor");
        model.addAttribute("intoleranciaLactosa", "intolerància a la lactosa");
        model.addAttribute("intoleranciaGluten", "intolerància al gluten");
        model.addAttribute("intoleranciaHismatico", "intolerància a l'histaminic");
        model.addAttribute("intoleranciaFodmaps", "intolerància al FODMAP's");
        model.addAttribute("observaciones", "observaciones");
        var correo = UsuarioActual.getCurrentUser();
        var profesor = new Profesor();
        profesor.setCorreo(correo);
        var profesor2 = profesorService.buscarProfesores(profesor); 
        model.addAttribute("profesor",profesor2);
        RolSigleton.getInstance();
        RolSigleton.setInformacion(profesor2.getRols().getIdroles());
        
        return "/paginasRRHH/perfil";
    }
}
