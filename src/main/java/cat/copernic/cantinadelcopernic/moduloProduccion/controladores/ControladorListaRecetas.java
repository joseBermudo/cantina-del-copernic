/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;

import cat.copernic.cantinadelcopernic.modelo.Receta;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador que gestiona los templates del modulo de Producción.
 * @author joseb
 */
@Controller
@Slf4j
public class ControladorListaRecetas {
    
    // Variables String que contienen los titulos de las paginas.
    private String tituloCrear = "Nova recepta";
    private String tituloEditar = "Editar recepta";
    
    //Servicio de produccion.
    @Autowired 
    private ProduccionService proServ;
    
    /**
     * Muestra el template con la lista de recetas.
     * @param model
     * @return Devuelve el template con la lista de recetas.
     */
    @GetMapping("/listaRecetas")
    public String page(Model model) {
        
        //Obtenemos todas las recetas de la base de datos y las pasamos al template.
        model.addAttribute("recetas", proServ.obtenerRecetas());
        
        //Devolvemos el template.
        return "/paginasProduccion/listaRecetas";
    }
    
    /**
     * Abre el formulario para crear una receta.
     * @param receta Receta que editamos.
     * @param model
     * @return Devuelve el formulario para crear o editar una receta.
     */
    @GetMapping("/crearReceta")
    public String formularioRceta(Receta receta,Model model) {
        
        //Pasamos el titulo de pagina correspondiente al template.
        model.addAttribute("titulo", tituloCrear);
        
        //Devolvemos el template.
        return "/paginasProduccion/editarReceta";
    }
    
    /**
     * Abre el formulario para crear una receta.
     * @param receta Receta que editamos.
     * @param model
     * @return Devuelve el formulario para crear o editar una receta.
     */
    @GetMapping("/editarReceta/{id}")
    public String editarReceta(Receta receta, Model model){
        
        //Obtenemos la receta especifica de la base de datos y la pasamos al template.
        model.addAttribute("receta", proServ.buscarReceta(receta));
        
        //Pasamos el titulo de pagina correspondiente al template.
        model.addAttribute("titulo",tituloEditar);
        
        //Devolemos el formulario.
        return "/paginasProduccion/editarReceta";
    }
    
    
    /**
     * Guarda o actualiza una receta en la base de datos.
     * @param receta Receta que guardamos o actualizamos.
     * @param errors Variable que contiene los errores al validar el formulario.
     * @return Devuelve el template que contiene la lsita de recetas.
     */
    @PostMapping("/guardarReceta")
    public String guardarReceta(@Valid Receta receta,Errors errors){
        
        //Comprobamos si hay errores al validar el formulario.
        //Si hay errores devuelve el mismo formulario.
        if(errors.hasErrors()){
            return "/paginasProduccion/editarReceta";
        }
        
        //Guardamos o actualizamos la receta en la base de datos.
        proServ.guardarReceta(receta);
        
        //Redirigimos al uusario a la lista de recetas.
        return "redirect:/listaRecetas";
    }
    
    
    public void setProServ(ProduccionService proServ) {
        this.proServ = proServ;
    }
    

}
