/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author joseb
 */
@Controller
@Slf4j
public class ControladorListaBebidas {
    
    private String tituloEditar ="Editar beguda";
    private String tituloCrear ="Crear beguda";
    
    @Autowired 
    private ProduccionService proServ;
    
    @GetMapping("/listaBebidas")
    public String inici(Model model) {
        
       
        model.addAttribute("bebidas", proServ.obtenerBebidas());
        return "/paginasProduccion/listaBebidas";
    }
    
    
    
    @GetMapping("/crearBebida")
    public String formularioBebida(Bebida bebida,Model model) {
        model.addAttribute("titulo", tituloCrear);
        return "/paginasProduccion/editarBebida";
    }
    
    @GetMapping("/editarBebida/{id}")
    public String editarBebida(Bebida bebida, Model model){
   
        model.addAttribute("bebida", proServ.buscarBebida(bebida));
        model.addAttribute("titulo",tituloEditar);
        return "/paginasProduccion/editarBebida";
    }
    
    @PostMapping("/guardarBebida")
    public String guardarBebida(@Valid Bebida bebida,Errors errors){
        if(errors.hasErrors()){
            return "/paginasProduccion/editarBebida";
        }
        proServ.guardarBebida(bebida);
        return "redirect:/listaBebidas";
    }
    
}
