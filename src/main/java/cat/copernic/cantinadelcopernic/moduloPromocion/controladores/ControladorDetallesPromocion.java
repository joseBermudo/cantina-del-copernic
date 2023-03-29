/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocion;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import cat.copernic.cantinadelcopernic.moduloPromocion.servicios.PromocionService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorDetallesPromocion {

    @Autowired
    PromocionService promServ;

    @GetMapping("/detallesPromocion/{id}")
    public String inici(Promocion promocion, Model model) {

        model.addAttribute("promocion", promServ.buscarPromocion(promocion));
        model.addAttribute("profProm", new ProfesorPromocion());

        return "/paginasPromocion/detallesPromocion";
    }

    @PostMapping("/utilizarPromocion")
    public String utilizarPromocion(@RequestParam("correo[]") String correo[], @RequestParam("proId") int proId,@RequestParam("indice") int indice) {

        Promocion pro = new Promocion();
        pro.setId(proId);
         //int indice = Integer.parseInt(request.getParameter("indice"));
        Promocion promocion = promServ.buscarPromocion(pro);

        ArrayList<ProfesorPromocion> profesorPromocion = (ArrayList<ProfesorPromocion>) promocion.getProfesorPromocion().stream()
                .filter(pf -> pf.getProfesor().getCorreo().equals(correo[indice]))
                .collect(Collectors.toList());

        promServ.utilizarPromocion(promServ.buscarPromocionProfesor(profesorPromocion.get(0)));

        return "redirect:/detallesPromocion/" + promocion.getId();
    }
}
