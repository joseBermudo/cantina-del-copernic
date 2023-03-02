/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.DAO.PromocionDAO;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorListaPromociones {
    
    @Autowired
    private PromocionDAO promocionDAO;

    @GetMapping("/listaPromociones")
    public String inici(Model model) {

       
        model.addAttribute("promociones", promocionDAO.findAll());
        return "/paginasPromocion/listaPromociones";
    }
}
