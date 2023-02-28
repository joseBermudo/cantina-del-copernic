/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.controladores.Admin;

import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorVerPedidoAdministrador {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @GetMapping("/verPedidoAdministrador")
    public String inici(Model model) {

        String com = "Comanda 1";
        model.addAttribute("com1", com);

        String entrepa = "Entrepa de pernil";
        model.addAttribute("ent", entrepa);

        var bos = new BocadilloSemana();
        bos.setPrecio(5.00);

        Date date = new Date();

        //Fecha en formato SHORT: 6/10/12
        DateFormat formateadorFechaCorta = DateFormat.getDateInstance(DateFormat.SHORT);

        bos.setFecha(date);
        bos.setImagen("Aigua");

        var re = new Receta();
        re.setNombre("Pernil");
        re.setDescripcion("desssssssssssss");

       // model.addAttribute("gossos", gosDao.findAll());
        
        //model.addAttribute("pedido", pe);

        return "/paginasVentas/ventasAdministrador/verPedidoAdministrador"; //Retorna la pàgina iniciEnviarDades
    }

}
