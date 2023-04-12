/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Esta clase es un controlador de Spring que maneja las solicitudes HTTP
 * relacionadas con la vista del listado de bocadillos de la semana.
 */
@Controller
public class ControladorListadoBocadilloSemana {

    @Autowired
    private VentasService serVentas;

    /**
     *
     * Este método maneja una solicitud HTTP GET para mostrar el listado de
     * bocadillos de la semana.
     *
     * @param model El objeto Model que se utiliza para transferir datos entre
     * el controlador y la vista.
     *
     * @return La vista que muestra el listado de bocadillos de la semana.
     */
    @GetMapping("/listaBocadilloSemana")
    public String inici(Model model) {

        String com = "Entrepans de la setmana";
        model.addAttribute("com1", com);

        var bocadillos = serVentas.listarBocadilloSemana();

        model.addAttribute("bocadillos", bocadillos);

        return "/paginasVentas/ventasAdministrador/listadoBocadillosSemana"; //Retorna la pàgina iniciEnviarDades
    }
}
