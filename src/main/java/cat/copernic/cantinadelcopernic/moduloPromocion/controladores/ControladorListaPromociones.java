/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.DAO.PromocionDAO;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocion;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocionId;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import cat.copernic.cantinadelcopernic.moduloPromocion.servicios.PromocionService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorListaPromociones {
    
    private String tituloCrear = "Nova promoció";
    private String tituloEditar = "Editar promoció";
    
    @Autowired
    private PromocionService promServ;

    @GetMapping("/listaPromociones")
    public String inici(Model model) {

       
        model.addAttribute("promociones", promServ.obtenerPromociones());
        return "/paginasPromocion/listaPromociones";
    }
    
    
    @GetMapping("/crearPromocion")
    public String formularioPromocion(Promocion promocion,Model model) {
        model.addAttribute("titulo",tituloCrear);
        return "/paginasPromocion/editarPromocion";
    }
    
    @GetMapping("/editarPromocion/{id}")
    public String editarPromocion(Promocion promocion,Model model) {
        model.addAttribute("titulo",tituloEditar);
        model.addAttribute("promocion",promServ.buscarPromocion(promocion));
        return "/paginasPromocion/editarPromocion";
    }
    
    
    @PostMapping("/guardarPromocion")
    public String guardarPromocion(Promocion promocion,HttpServletRequest request){
        
//        List<ProfesorPromocion> profesorPromocion = promocion.getProfesorPromocion();
//        for (int i = 0; i < profesorPromocion.size(); i++) {
//            int idPromocion = Integer.parseInt(request.getParameter("profesorPromocion[" + i + "].promocion.id"));
//            String idProfesor = request.getParameter("profesorPromocion[" + i + "].profesor.correo");
//            
//            profesorPromocion.get(i).setId(new ProfesorPromocionId(idPromocion, idProfesor));
//        }
        
        promServ.guardarPromocion(promocion);
        
        
        
        return "redirect:/listaPromociones";
    }
}
