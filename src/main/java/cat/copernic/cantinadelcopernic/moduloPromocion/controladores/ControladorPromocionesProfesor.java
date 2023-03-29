/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.DAO.PromocionDAO;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocion;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import cat.copernic.cantinadelcopernic.moduloPromocion.servicios.PromocionService;
import cat.copernic.cantinadelcopernic.utilities.Utils;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorPromocionesProfesor {

    @Autowired
    private PromocionService promServ;

    @GetMapping("/listaPromocionesNoCompletadas")
    public String inici(Model model) {
        
        String usuario = Utils.getCurrentUser();
        ArrayList<ProfesorPromocion> listaPromocionesProf =(ArrayList<ProfesorPromocion>) promServ.obtenerPromocionesUsuario(usuario);
        listaPromocionesProf = (ArrayList<ProfesorPromocion>) listaPromocionesProf.stream().filter(pf -> pf.getRecuento()<pf.getPromocion().getCondicio()).collect(Collectors.toList());
        model.addAttribute("promocionesProf", listaPromocionesProf);
        
        return "/paginasPromocion/listaPromocionesNoCompletadas";
    }
}
