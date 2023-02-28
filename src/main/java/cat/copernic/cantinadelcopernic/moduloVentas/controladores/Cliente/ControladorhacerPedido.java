/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;



import cat.copernic.cantinadelcopernic.modelo.Bebida;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorhacerPedido {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @GetMapping("/hacerPedidoCliente")
    public String inici(Model model) {
     
        String fc="FER COMANDA";
        model.addAttribute("ferComanda", fc);
        
        
        var be = new Bebida();
        be.setNombre("Aigua");
        be.setDesc("aigua de tota la vida");
        be.setPrecio(5.0);
        
        var be2 = new Bebida();
        be2.setNombre("Coca Cola");
        be2.setDesc("a");
        be2.setPrecio(2.0);
        
        var bebidas = new ArrayList<Bebida>();
        bebidas.add(be);
        bebidas.add(be2);
        
        model.addAttribute("begudes", bebidas);
        
        return "/paginasVentas/ventasCliente/hacerPedidoCliente"; //Retorna la pàgina iniciEnviarDades
    }
    
    
}
