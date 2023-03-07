/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;



import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
    
     @Autowired
    private BocadilloSemanaDAO bsDAO;

    @GetMapping("/pedidosCliente")
    public String inici(Model model) {
        
         var bocadillosDeLaSemana = bsDAO.findAll();
        
         var bocadilloPernil = bsDAO.findById(1);
          
         var B= bocadilloPernil.get();
         model.addAttribute("bocSemana", B);

        
        String descEntrepa="Descripció l'entrepà de pernil: Aquest deliciós entrepà està fet amb pa acabat de fer, enciam, tomàquet, pernil, format i una exquisida salsa secreta. És la combinació perfecta de sabors i textures que et deixarà amb ganes de més.";
        model.addAttribute("descEntrepa", descEntrepa);
        
        
        return "/paginasVentas/ventasCliente/pedidosCliente"; //Retorna la pàgina iniciEnviarDades
    }
    
    
}
