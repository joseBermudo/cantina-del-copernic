/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.gestionModulos.controladores;

import cat.copernic.cantinadelcopernic.DAO.ModuloDAO;
import cat.copernic.cantinadelcopernic.gestionModulos.servicios.GestionModulosService;
import cat.copernic.cantinadelcopernic.modelo.Modulo;
import cat.copernic.cantinadelcopernic.modelo.ModuloRol;
import cat.copernic.cantinadelcopernic.modelo.ModuloRolId;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador que gestiona la tabla de modulos, donde se muestran
 * todos los modulos disponibles, asi como la opcion de modificar su configuración.
 * @author andre
 */
@Controller
public class ControladorGestionDeModulos {
    
    // Variable que hace referecia al servicio de modulos.
    @Autowired
    private GestionModulosService servModulos;
    
    // Varuable String que contiene el titulo de la pagina
    private String tituloPagina = "Llista de móduls";
    
    /**
     * Obtiene la lista de modulos de la base de datos y devuelve el template
     * que muestra el listado obtenido.
     * @param model
     * @return Devuelve el template que muestra la tabla de modulos.
     */
    @GetMapping("/gestioModuls")
    public String inici(Model model) {
        
        
        // Obtenemos la lista de modulos de la base de datos a traves del servicio.
        List<Modulo> modulos = servModulos.listarModulos();
        
        //Pasamos el titulo de la pagina al template.
        model.addAttribute("modulos", modulos);
        
        //Devolvemos el template
        return "/paginasGestionModulos/listadoModulos";
    }
    
    /**
     * Devuelve el template para modificar el modulo pasado por el tamplate.
     * @param modulo que editamos
     * @param model
     * @return Devuelve el template para moficar el modulo correpondiente.
     */
    @GetMapping("/modificar/{idmodulos}")
    public String editar(Modulo modulo, Model model) {
        
        //Buscamos el modulo en la base de datos y lo pasamos al template.
        model.addAttribute("modulo", servModulos.buscarModulo(modulo));
        
        //Devolvemos el template
        return "/paginasGestionModulos/modificarModul";
    }
    
    /**
     * Actualiza en la base de datos la configuracion del modulo modificado.
     * @param modulo Modulo que actualizamos en la base de datos.
     * @param request Instancia de HttpServletRequest para obtener las id de ModuloRol.
     * @return Nos devuelve al template que muestra todos los modulos.
     */
    @PostMapping("/actualizarModulo")
    public String actualizarModulo(Modulo modulo, HttpServletRequest request) {
        
        // Obtenemos una lista de instancias de ModuloRol que contiene la visibilidad de cada rol.
        List<ModuloRol> modulosRoles = modulo.getModulosRoles();
        
        //Obtenemos las id de los ModuloRol y las insetamos en sus intancias
        for (int i = 0; i < modulosRoles.size(); i++) {
            int idModulos = Integer.parseInt(request.getParameter("modulosRoles[" + i + "].modulo.idmodulos"));
            int idRoles = Integer.parseInt(request.getParameter("modulosRoles[" + i + "].rol.idroles"));
            modulosRoles.get(i).setId(new ModuloRolId(idModulos, idRoles));
        }
        //Obtener el modulo de la la base de datos
        Modulo mod = servModulos.buscarModulo(modulo);
        //Aplicar la configuracion nueva
        mod.setHabilitado(modulo.isHabilitado());
        mod.setModulosRoles(modulosRoles);
        
        //Actualizar la configruacion del modulo en la base de datos
        servModulos.guardarModulo(mod);
        
        //Redirige al usuario a la pagina que muestra todos los modulos.
        return "redirect:/gestioModuls";
    }

}
