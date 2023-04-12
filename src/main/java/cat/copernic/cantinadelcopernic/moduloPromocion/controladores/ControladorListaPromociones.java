/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.DAO.PromocionDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocion;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocionId;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import cat.copernic.cantinadelcopernic.moduloPromocion.servicios.PromocionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador que gestiona la lista de promocines vista por Admin y Alumno.
 *
 * @author joseb
 */
@Controller
public class ControladorListaPromociones {

    //Variables String que contienen los titulos de las paginas.
    private String tituloCrear = "Nova promoció";
    private String tituloEditar = "Editar promoció";

    //Servicio de Promocion.
    @Autowired
    private PromocionService promServ;

    /**
     * Muestra la lsita de promociones.
     *
     * @param model
     * @return Devuelve el templare que contiene la lsita de promociones.
     */
    @GetMapping("/listaPromociones")
    public String inici(Model model) {

        //Leemos todas las promociones de la base de datos y las pasamos al template.
        model.addAttribute("promociones", promServ.obtenerPromociones());

        //Devolver el template.
        return "/paginasPromocion/listaPromociones";
    }

    /**
     * Abre el formulario para crear una promocion.
     *
     * @param promocion Promocion que editamos (en este caso null)
     * @param model
     * @return Devuelve el formulario.
     */
    @GetMapping("/crearPromocion")
    public String formularioPromocion(Promocion promocion, Model model) {

        //Pasamos el titulo de la pagina al template.
        model.addAttribute("titulo", tituloCrear);

        //Devolver el formulario.
        return "/paginasPromocion/crearPromocion";
    }

    /**
     * Abre el formulario para editar una promocion.
     *
     * @param promocion Promocion que editamos.
     * @param model
     * @return Devolvemos el formulario para editar una promocion.
     */
    @GetMapping("/editarPromocion/{id}")
    public String editarPromocion(Promocion promocion, Model model) {

        //Pasamos el titulo de la pagina al template.
        model.addAttribute("titulo", tituloEditar);

        //Leemos la promocion a editar de la base de datos y la pasamos al template.
        model.addAttribute("promocion", promServ.buscarPromocion(promocion));

        //Devolver el formulario.
        return "/paginasPromocion/editarPromocion";
    }

    /**
     * Actualizamos una promocion en la base de datos.
     *
     * @param promocion Promocion que persistimos.
     * @param errors Variable que contiene los errores al validar el formulario.
     * @return Redirige al usuario a la lista de promociones.
     */
    @PostMapping("/guardarPromocion")
    public String guardarPromocion(@Valid Promocion promocion, Errors errors) {

        //Si hay algun error al validar el formulario devolvemos el mismo formulario.
        if (errors.hasErrors()) {
            return "/paginasPromocion/editarPromocion";
        }
        
        //Actualizamos la promocion en la base de datos.
        promServ.guardarPromocion(promocion);
        
        //Rederigir a la lista de promociones.
        return "redirect:/listaPromociones";
    }
    
    /**
     * Crear y guarda una nueva promocion en la base de datos.
     * @param promocion Promocion a guardar.
     * @param errors Variable que contiene los errores al validar el formulario.
     * @return Redirige al usuario a la lista de promociones.
     */
    @PostMapping("/guardarNuevaPromocion")
    public String guardarNuevaPromocion(@Valid Promocion promocion, Errors errors) {
        
        //Si hay errores al validar el formulario devolvemos el mismo formulario.
        if (errors.hasErrors()) {
            return "/paginasPromocion/crearPromocion";
        }
        
        //Creamis e insertamos una nueva Array de ProfesorPromocion en la promocion.
        promocion.setProfesorPromocion(new ArrayList<ProfesorPromocion>());
        //Persistimos la promocion en la base de datos.
        promServ.guardarPromocion(promocion);

       //Creamos una nueva lista de ProfesorPromocion
        ArrayList<ProfesorPromocion> listPromProf = new ArrayList<ProfesorPromocion>();
        //Obtenemos todos los profesores de la base de datos.
        List<Profesor> listaProfesores = promServ.obetnerClientes();
        
        //Recorremos la lista de profesores.
        //Por cada iteracion creamos una ProfesorPromocion el profesor correspondiente y la promocion,
        //despues lo insertamos en la lista listPromProf.
        listaProfesores.forEach(prof -> {
            listPromProf.add(new ProfesorPromocion(new ProfesorPromocionId(promocion.getId(), prof.getCorreo()), promocion, prof, false, 0));
        });
        
        //Guardamos la lista de PorfesorPromocion en la base de datos.
        promServ.gurdarProfesorPromocion(listPromProf);
        
        //Rederigimos a la lista de promociones.
        return "redirect:/listaPromociones";
    }
    
    /**
     * Eliminar una promocion.
     * @param promocion Promocion a eliminar.
     * @return Devuelve el template que muestra la lsita de promociones.
     */
    @GetMapping("/eliminarPromocion/{id}")
    public String eliminarPromocion(Promocion promocion) {
        
        //Eliminar la promocion de la base de datos.
        promServ.eliminarPromocion(promServ.buscarPromocion(promocion));
        
        //Devolver el template.
        return "redirect:/listaPromociones";
    }
}
