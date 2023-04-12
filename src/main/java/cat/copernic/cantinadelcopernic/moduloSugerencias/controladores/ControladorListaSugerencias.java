/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;





import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Usuario;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.UsuarioService;
import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
import cat.copernic.cantinadelcopernic.utilities.UsuarioActual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *Clase que representa el controlador de la página que mostrará la lista de sugerencias 
 * @author andre
 */
@Controller
public class ControladorListaSugerencias {
    
    @Autowired
    private SugerenciaService sugerenciaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/listaSuggeriments")
    /**
     * función que recuperará una lista de todas las sugerencia o de las sugerencias de un usuario dependiendo 
     * si el usuario quiue accede a la página es un admin o un usuario comun
     * @param model
     * @return devuelve la página html donde se muestra la lista de sugerencias
     */
    public String inici(Model model){
        
        var correo = UsuarioActual.getCurrentUser();
        
        var usuario = new Usuario();
        usuario.setCorreo(correo);
        
        var usuarioRecuperado = usuarioService.buscarUsuario(usuario);
        
        if (usuarioRecuperado.getRols().getIdroles() == 3) {
            
            var profesor = new Profesor();
            profesor.setCorreo(usuarioRecuperado.getCorreo());
            model.addAttribute("sugerencias", sugerenciaService.listarSugerenciasProfesor(profesor));
            model.addAttribute("esProfesor", true);
        }else{
            model.addAttribute("sugerencias", sugerenciaService.listarSugerencias());
            model.addAttribute("esProfesor", false);
            model.addAttribute("esAdmin", true);
        }
        
      
        
        return "/paginasSugerencias/listaSugerencias"; 
    }
}
