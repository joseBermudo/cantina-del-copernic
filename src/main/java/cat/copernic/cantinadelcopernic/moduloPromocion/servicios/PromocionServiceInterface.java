/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.servicios;

import cat.copernic.cantinadelcopernic.modelo.Promocion;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface PromocionServiceInterface {
    
    public List<Promocion> obtenerPromociones();
    
    public void guardarPromocion(Promocion promocion);
    
    public Promocion buscarPromocion(Promocion promocion);
}
