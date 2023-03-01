/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.gestionModulos.controladores;

import cat.copernic.cantinadelcopernic.modelo.Modulo;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author andre
 */
@Controller
public class ControladorGestionDeModulos {
    
     @GetMapping("/gestioModuls")
      public String inici(Model model){
          
          var modulo = new Modulo();
          
          modulo.setNombreModulo("modulo");
          modulo.setHabilitado(true);
          modulo.setVisibleAlumno(true);
          modulo.setVisibleCliente(false);
          
          var modulos = new ArrayList<Modulo>();
          
          modulos.add(modulo);
          
          model.addAttribute("modulos", modulos);
      
          return "/paginasGestionModulos/listadoModulos"; 
      }
}
