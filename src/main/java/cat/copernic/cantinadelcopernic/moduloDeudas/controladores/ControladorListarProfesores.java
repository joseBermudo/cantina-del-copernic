/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.DAO.ProfesorDAO;
import cat.copernic.cantinadelcopernic.DAO.UsuarioDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    @GetMapping("/listarProfesores")
    public String listarProfesores(Model model) {
        
        model.addAttribute("listadoProfesores", profesorDAO.findAll());
        //Profesor 3, alumno 2, admin 1
        String correo = getCurrentUser();
        Usuario user = usuarioDAO.findByUsername(correo);
        
        int tipoDeUser = 2;// per si un cas
        tipoDeUser = user.getRols().getIdroles();
        //En teoria només pot haver accedit aqui un usuari administrador o alumne
        if(tipoDeUser == 1)//Admin
        {
            model.addAttribute("rol", 1);

        }
        else//Alumno-user
        {
            model.addAttribute("rol", 2);
        }
        
        return "/paginasDeudas/listarProfesores"; 
    }

    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return username;
    }
}
