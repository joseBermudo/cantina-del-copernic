/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.servicios;

import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface ProduccionServiceInterface {
    
    public List<Receta> obtenerRecetas();
    
    public List<Bebida> obtenerBebidas();
    
    public void guardarBebida(Bebida bebida);
    
    public Bebida buscarBebida(Bebida bebida);
    
}
