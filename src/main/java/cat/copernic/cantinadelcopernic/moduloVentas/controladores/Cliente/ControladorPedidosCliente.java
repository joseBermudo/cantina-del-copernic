/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;



import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
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
    private VentasService serVentas;
   
   @Autowired
   private BebidaDAO bebDAO;
   
   
   
    @GetMapping("/pedidosCliente")
    public String inici(Model model) {
 
        model.addAttribute("bocadillo", serVentas.listarBocadilloSemana().get(0)); 
        
        model.addAttribute("pedidos", serVentas.listarPedidos());
        
        return "/paginasVentas/ventasCliente/pedidosCliente"; //Retorna la pàgina iniciEnviarDades
    }
    
    
}
