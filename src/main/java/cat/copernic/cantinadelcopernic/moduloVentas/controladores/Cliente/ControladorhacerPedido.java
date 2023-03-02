/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Cliente;



import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.PedidoDAO;
import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.Bebida;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorhacerPedido {
        
    @Autowired 
    private BocadilloSemanaDAO bsDAO;
    
    @Autowired 
    private BebidaDAO bebDAO;
    
    
    @GetMapping("/hacerPedidoCliente")
    public String inici(Model model) {

    
    
        String fc="FER COMANDA";
        model.addAttribute("ferComanda", fc);
        

        //lista de bocadillos de la semana
        var bocadillosDeLaSemana = bsDAO.findAll();
        
         //recetas
         var bebidas = bebDAO.findAll();
        
        
        model.addAttribute("bocsemana", bocadillosDeLaSemana);
        model.addAttribute("begudes", bebidas);
        
        return "/paginasVentas/ventasCliente/hacerPedidoCliente"; //Retorna la pàgina iniciEnviarDades
    }
    
    
}
