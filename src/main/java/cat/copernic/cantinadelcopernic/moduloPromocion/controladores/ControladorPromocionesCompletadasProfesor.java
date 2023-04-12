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
import java.util.Iterator;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador que gestiona la lista de promociones vista desde el Cliente.
 * @author joseb
 */
@Controller
public class ControladorPromocionesCompletadasProfesor {
    
    //Servicio de promocion.
    @Autowired
    private PromocionService promServ;
    
    /**
     * Muestra la lista de promociones completadas del usuario.
     * @param model
     * @return Devuelve el template que contiene la lista de promociones completadas.
     */
    @GetMapping("/listaPromocionesCompletadas")
    public String inici(Model model) {
        
        //Obtener usuario logeado.
        String usuario = Utils.getCurrentUser();
        
        //Obtener todos los registros que relaicon el usuario con todas las promociones.
        ArrayList<ProfesorPromocion> listaPromocionesProf =(ArrayList<ProfesorPromocion>) promServ.obtenerPromocionesUsuario(usuario);
        
        //Filtrar los registros para obtener solo las promociones completadas.
        listaPromocionesProf = (ArrayList<ProfesorPromocion>) listaPromocionesProf.stream().filter(pf -> pf.getRecuento()>=pf.getPromocion().getCondicio()).collect(Collectors.toList());
       
        //Pasar la lista de promociones completadas al template.
        model.addAttribute("promocionesProf", listaPromocionesProf);
        
        //Devolver el template.
        return "/paginasPromocion/listaPromocionesCompletadas";
    }
}
