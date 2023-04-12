/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import cat.copernic.cantinadelcopernic.moduloRRHH.servicios.ProfesorService;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
/**
 *
 * Esta clase es el controlador encargado de manejar los pedidos realizados por
 * un cliente.
 */
@Controller
public class ControladorPedidosCliente {

    /**
     *
     * Este atributo es una instancia de la interfaz VentasService que nos
     * permite acceder a los servicios relacionados con la venta de productos.
     */
    @Autowired
    private VentasService serVentas;
    /**
     *
     * Este atributo es una instancia de la interfaz ProfesorService que nos
     * permite acceder a los servicios relacionados con los profesores.
     */
    @Autowired
    private ProfesorService profesorService;
    /**
     *
     * Este atributo es una instancia de la interfaz ProduccionService que nos
     * permite acceder a los servicios relacionados con la producción de
     * productos.
     */
    @Autowired
    private ProduccionService prodSer;

    /**
     *
     * Este método maneja la petición GET "/pedidosCliente" y se encarga de
     * mostrar los pedidos realizados
     *
     * por el cliente correspondiente en la vista.
     *
     * @param model es un objeto de la clase Model que nos permite transferir
     * datos entre el controlador y la vista.
     *
     * @return la página "/paginasVentas/ventasCliente/pedidosCliente".
     */
    @GetMapping("/pedidosCliente")
    public String inici(Model model) {

        model.addAttribute("bocadillo", serVentas.listarBocadilloSemana().get(0));

        Profesor prof = new Profesor();
        prof.setCorreo(getCurrentUser());
        Profesor profBuscado = profesorService.buscarProfesores(prof);

        List<Pedido> prueba = serVentas.findByProfesores(profBuscado);
        model.addAttribute("pedidos", serVentas.findByProfesores(profBuscado));

        return "/paginasVentas/ventasCliente/pedidosCliente";
    }

    /**
     *
     * Este método devuelve el nombre del usuario actual que ha iniciado sesión
     * en la aplicación.
     *
     * @return el nombre del usuario actual.
     */
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return username;
    }
}
