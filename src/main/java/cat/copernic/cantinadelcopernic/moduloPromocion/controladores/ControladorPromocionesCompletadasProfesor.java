/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.controladores;

import cat.copernic.cantinadelcopernic.modelo.Promocion;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joseb
 */
@Controller
public class ControladorPromocionesCompletadasProfesor {
     @GetMapping("/listaPromocionesCompletadas")
    public String inici(Model model) {
        ArrayList<Promocion> promociones = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Promocion promocion = new Promocion();
            promocion.setId(i);
            promocion.setDesc("Compra 4 rep 1 Cafè\t 4/4");
            promociones.add(promocion);
        }
        model.addAttribute("promociones", promociones);
        return "/paginasPromocion/listaPromocionesCompletadas";
    }
}
