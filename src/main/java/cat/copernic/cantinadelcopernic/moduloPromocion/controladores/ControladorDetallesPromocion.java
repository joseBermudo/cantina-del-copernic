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
 * Controlador que gestiona los usuairos de cada promocion.
 * @author joseb
 */
@Controller
public class ControladorDetallesPromocion {
    
    //Servicio de Promocion.
    @Autowired
    PromocionService promServ;
    
    /**
     * Muestra la lista de usuarios y su informacion respecto a una promocion.
     * @param promocion Promocion que mostrara.
     * @param model
     * @return Devuelve el template que muestra la lista de usuarios de la 
     * promocion especidicada.
     */
    @GetMapping("/detallesPromocion/{id}")
    public String inici(Promocion promocion, Model model) {
        
        //Obtenemos la promocion de la base de datos y la pasamos al template.
        model.addAttribute("promocion", promServ.buscarPromocion(promocion));
        
        //Pasamos al template una nueva instancia de ProfesorPromocion.
        model.addAttribute("profProm", new ProfesorPromocion());

        //Devolvemos el template.
        return "/paginasPromocion/detallesPromocion";
    }
    
    /**
     * Utiliza una promocion de un usuario especifico.
     * @param correo Array de Correos electronicos de los usuarios.
     * @param proId Id de la la promocion
     * @param indice Indice en la array de correos.
     * @return 
     */
    @PostMapping("/utilizarPromocion")
    public String utilizarPromocion(@RequestParam("correo[]") String correo[], @RequestParam("proId") int proId,@RequestParam("indice") int indice) {
        
        //Creamos un nueva promocion y configuramos su Id.
        Promocion pro = new Promocion();
        pro.setId(proId);
        
        //Obtenemos la promocion de la base de datos a traves de la id
        Promocion promocion = promServ.buscarPromocion(pro);
        
        //Obetnemos los registros que relacionan dicha promocion con el usuario
        ArrayList<ProfesorPromocion> profesorPromocion = (ArrayList<ProfesorPromocion>) promocion.getProfesorPromocion().stream()
                .filter(pf -> pf.getProfesor().getCorreo().equals(correo[indice]))
                .collect(Collectors.toList());
        
        //Eliminamos los registros relacionales.
        promServ.utilizarPromocion(promServ.buscarPromocionProfesor(profesorPromocion.get(0)));
        
        //Rerdirigimos al usuario a la misma pagina.
        return "redirect:/detallesPromocion/" + promocion.getId();
    }
}
