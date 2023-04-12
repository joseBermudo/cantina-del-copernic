/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.controladores;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.modelo.Usuario;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.UsuarioService;
import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
import cat.copernic.cantinadelcopernic.utilities.UsuarioActual;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *Clase que representa el controlador para la página de  guardar suerencia
 * @author andre
 */
@Controller
public class ControladorGuardarSugerencia {
    
    @Autowired
    private SugerenciaService sugerenciaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/guardarSuggeriment/{num}")
    /**
     * función que se utiliza para guardar una sugerencia validando los atributoss del objeto 
     * @param sugerencia 
     * @errors objeto que contendrá los errores que se hayan encontrado en la validación
     * @num numero que se utiliza para identificar si la modificaciçon de la sugerencia se ha hecho por un admin o un usuario
     * @return redirección a la lista de sugerencias
     */
    public String guardarSugerencia(@Valid Sugerencia sugerencia, Errors errors, @PathVariable("num") int num){
        
         if(errors.hasErrors()){ 
             return "/paginasSugerencias/nuevaSugerencia";
        }
        
        if (num == 1) {
          sugerencia.setLeida(true);
          sugerencia.setProfesor(sugerenciaService.buscarSugerencia(sugerencia).getProfesor());
        }else{
            
            var correo = UsuarioActual.getCurrentUser();
        
            var usuario = new Usuario();
            usuario.setCorreo(correo); 
            var usuarioRecuperado = usuarioService.buscarUsuario(usuario);
            
            if (usuarioRecuperado.getRols().getIdroles() == 3) {
                var profesor = new Profesor();
                profesor.setCorreo(usuarioRecuperado.getCorreo());
                sugerencia.setProfesor(profesor);
            }
 
            
        }
        
        sugerenciaService.anadirSugerencia(sugerencia);
        
        return "redirect:/listaSuggeriments";
    }
    
}
