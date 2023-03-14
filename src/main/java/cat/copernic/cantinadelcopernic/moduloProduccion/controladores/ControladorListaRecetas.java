/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joseb
 */
@Controller
@Slf4j
public class ControladorListaRecetas {
    @Autowired 
    private ProduccionService proServ;
    @GetMapping("/listaRecetas")
    public String page(Model model) {
        
        model.addAttribute("recetas", proServ.obtenerRecetas());
        return "/paginasProduccion/listaRecetas";
    }

}
