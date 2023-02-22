/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorVerPedido {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @GetMapping("/verPedidoCliente")
    public String inici(Model model) {

        return "/paginasVentas/ventasCliente/verPedidoCliente"; //Retorna la pàgina iniciEnviarDades
    }
    
    
}
