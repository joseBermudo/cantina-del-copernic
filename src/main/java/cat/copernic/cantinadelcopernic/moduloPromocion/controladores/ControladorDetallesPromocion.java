/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import cat.copernic.cantinadelcopernic.moduloPromocion.servicios.PromocionService;
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
public class ControladorDetallesPromocion {
    
    @Autowired
    PromocionService promServ;
    
    @GetMapping("/detallesPromocion/{id}")
    public String inici(Promocion promocion,Model model) {
        
     
        model.addAttribute("promocion",promServ.buscarPromocion(promocion));
        
        
        
        return "/paginasPromocion/detallesPromocion";
    }
}
