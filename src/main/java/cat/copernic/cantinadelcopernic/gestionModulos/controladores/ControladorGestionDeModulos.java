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
 *
 * @author andre
 */
@Controller
public class ControladorGestionDeModulos {

    @Autowired
    private GestionModulosService servModulos;

    private String tituloPagina = "Llista de móduls";

    @GetMapping("/gestioModuls")
    public String inici(Model model) {

        List<Modulo> modulos = servModulos.listarModulos();

        model.addAttribute("modulos", modulos);
        return "/paginasGestionModulos/listadoModulos";
    }

    @GetMapping("/modificar/{idmodulos}")
    public String editar(Modulo modulo, Model model) {

        model.addAttribute("modulo", servModulos.buscarModulo(modulo));

        return "/paginasGestionModulos/modificarModul";
    }

    @PostMapping("/actualizarModulo")
    public String actualizarModulo(Modulo modulo, HttpServletRequest request) {
        List<ModuloRol> modulosRoles = modulo.getModulosRoles();
        for (int i = 0; i < modulosRoles.size(); i++) {
            int idModulos = Integer.parseInt(request.getParameter("modulosRoles[" + i + "].modulo.idmodulos"));
            int idRoles = Integer.parseInt(request.getParameter("modulosRoles[" + i + "].rol.idroles"));
            modulosRoles.get(i).setId(new ModuloRolId(idModulos, idRoles));
        }
        Modulo mod = servModulos.buscarModulo(modulo);
        mod.setHabilitado(modulo.isHabilitado());
        mod.setModulosRoles(modulosRoles);
        servModulos.guardarModulo(mod);

        return "redirect:/gestioModuls";
    }

}
