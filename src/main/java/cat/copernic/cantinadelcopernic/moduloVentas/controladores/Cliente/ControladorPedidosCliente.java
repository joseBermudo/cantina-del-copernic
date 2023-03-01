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
public class ControladorPedidosCliente {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @GetMapping("/pedidosCliente")
    public String inici(Model model) {

        String es="Entrepa de la setmana";
        model.addAttribute("entrSemana", es);
        
        String descEntrepa="Descripció l'entrepà de pernil: Aquest deliciós entrepà està fet amb pa acabat de fer, enciam, tomàquet, pernil, format i una exquisida salsa secreta. És la combinació perfecta de sabors i textures que et deixarà amb ganes de més.";
        model.addAttribute("descEntrepa", descEntrepa);
        
        String btn="Fer comanda";
        model.addAttribute("btnComanda", btn);
        
        return "/paginasVentas/ventasCliente/pedidosCliente"; //Retorna la pàgina iniciEnviarDades
    }
    
    
}
