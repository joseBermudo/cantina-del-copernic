/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.controladores;

import cat.copernic.cantinadelcopernic.modelo.Alumno;
import cat.copernic.cantinadelcopernic.modelo.Rol;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.AlumnoService;
import cat.copernic.cantinadelcopernic.utilities.EncriptadorContrasenya;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *Clase que representa un controlador para crear alumnos
 * @author andre
 */
@Controller
public class ControladorNuevoAlumno {
    @GetMapping("/nouAlumne")
    /**
     * función qe se utliza para mostrar la pantalla para crear un alumno
     */
    public String inici(Model model, Alumno alumno){
        
        var tituloPagina = "REGISTRAR ALUMNE";
        
        var correo = "Correu electronic:";
        
        var contrasenya = "Contrasenya:";
        
        var confirmarContrasenya = "Confirmar contrasenya:";
        
        model.addAttribute("tituloPagina", tituloPagina);
        
        model.addAttribute("correo", correo);
        
        model.addAttribute("contrasenya", contrasenya);
        
        model.addAttribute("confirmarContrasenya", confirmarContrasenya);
        
        return "/paginasRRHH/nuevoAlumno"; 
    }
    
    @Autowired
    private AlumnoService alumnoService;
    
    /**
     *
     * @param alumno
     * @param errors
     * @param result
     * @return
     */
    @PostMapping("/guardarAlumno")
    /**
     * función donde se valida el alumno para guardarlo
     * @param alumno 
     * @param errores objeto donde se guardan los erropres que se dan al validar alumno
     * @param result objeto que se utliza para crear un error propio para validar la contraseña
     * @return devuelve un redirect a una pantalla donde se muestra una lista de profesores
     */
    public String guardarAlumno(@Valid Alumno alumno, Errors errors, BindingResult result){
        
        
        if(errors.hasErrors()){ 
           return "paginasRRHH/nuevoAlumno";
        }
        
        if (!alumno.getPassword().equals(alumno.getConfirmarPassword())) {
        result.rejectValue("confirmarPassword", "error.confirmarPassword", "Las contraseñas no coinciden");
        return "paginasRRHH/nuevoAlumno";
        }
        
        alumno.setUsername(alumno.getCorreo());
        
        alumno.setPassword(EncriptadorContrasenya.encriptarContrasenya(alumno.getPassword()));
        
        var rol = new Rol();
        rol.setIdroles(2);
        
        alumno.setRols(rol);
        
        alumnoService.anadirAlumno(alumno);
        
        return "redirect:/listaProfesors";
    
    }
}
