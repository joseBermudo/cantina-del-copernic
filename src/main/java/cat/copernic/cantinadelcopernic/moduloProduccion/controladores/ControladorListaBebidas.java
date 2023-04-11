/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.controladores;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador que gestiona los templates para mostrar, eliminar, editar y crear bebidas.
 * @author joseb
 */
@Controller
@Slf4j
public class ControladorListaBebidas {
    
    // Variables String que contienen los titulos de las paginas.
    private String tituloEditar ="Editar beguda";
    private String tituloCrear ="Crear beguda";
    
    // Servicio de produccion.
    @Autowired 
    private ProduccionService proServ;
    
    /**
     * Mutestra la pagina que contiene una lista de todas las bebidas.
     * @param model
     * @return Devuelve el template html que muestra una lista de todas las Bebidas.
     */
    @GetMapping("/listaBebidas")
    public String inici(Model model) {
        
       //Obtenemos de la base de datos todas las bebidas, y la pasamos al template.
        model.addAttribute("bebidas", proServ.obtenerBebidas());
        
        //Devolvemos el template.
        return "/paginasProduccion/listaBebidas";
    }
    
    
    /**
     * Muestra el formulario para crea una bebida.
     * @param bebida Bebida que se edita
     * @param model
     * @return Devuelve el formulario para crear o editar una bebida.
     */
    @GetMapping("/crearBebida")
    public String formularioBebida(Bebida bebida,Model model) {
        
        //Pasamos al template el titulo de pagina correspondiente.
        model.addAttribute("titulo", tituloCrear);
        
        //Devolvemos el tempalte.
        return "/paginasProduccion/editarBebida";
    }
    
    /**
     * Abre el formulario para editar una bebida.
     * @param bebida Bebida que editamos
     * @param model
     * @return Devuelve el formulario para editar o crear una bebida.
     */
    @GetMapping("/editarBebida/{id}")
    public String editarBebida(Bebida bebida, Model model){
        
        //Obtenemos la bebida espeficica de la base de datos y la pasamos al template.
        model.addAttribute("bebida", proServ.buscarBebida(bebida));
        
        //Pasamos al template el titulo de pagina correspondiente.
        model.addAttribute("titulo",tituloEditar);
        
        //Devolvemos el formulario.
        return "/paginasProduccion/editarBebida";
    }
    
    /**
     * Guarda o actualiza una bebida en la base de datos.
     * @param bebida Bebida que guardamos o actualizamos.
     * @param errors Variable que contiene los errores al validar el formulario.
     * @return Redirige al usuario a la pagina con la lista de bebidas.
     */
    @PostMapping("/guardarBebida")
    public String guardarBebida(@Valid Bebida bebida,Errors errors){
        
        //Comrpobamos si existe algun error al validar el formulario, en
        // caso positivo devolvemos al usuario al formulario.
        if(errors.hasErrors()){
            return "/paginasProduccion/editarBebida";
        }
        
        //Guardamos o actualizamos la bebida en la base de datos.
        proServ.guardarBebida(bebida);
        
        //Rerige al usuario al la lista de bebidas.
        return "redirect:/listaBebidas";
    }
    
}
