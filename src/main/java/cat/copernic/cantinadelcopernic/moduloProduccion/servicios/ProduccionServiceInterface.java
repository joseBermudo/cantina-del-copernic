/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.servicios;

import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.List;

/**
 * Interfaz que define los metodos del Servicio de Producción.
 * @author joseb
 */
public interface ProduccionServiceInterface {
    
    /**
     * Lista todas las recetas de la base de datos.
     * @return Lista de recetas.
     */
    public List<Receta> obtenerRecetas();
    
    /**
     * Lista todas las bebidas de la base de datos.
     * @return Lista de bebidas.
     */
    public List<Bebida> obtenerBebidas();
    
    /**
     * Guarda o actualiza una bebida en la base de datos.
     * @param bebida Bebida que guardamos o actualizamos.
     */
    public void guardarBebida(Bebida bebida);
    
    /**
     * Lee una bebida especifica.
     * @param bebida Bebida que lee
     * @return  La bebida leida
     */
    public Bebida buscarBebida(Bebida bebida);
    
    /**
     * Guarda o actualiza una receta en la base de datos.
     * @param receta Receta que guardamos o actualizamos.
     * @return Devuelve la receta guardada
     */
    public Receta guardarReceta(Receta receta);
    
    /**
     * Lee una receta especifica.
     * @param receta Receta que lee.
     * @return  Receta leida.
     */
    public Receta buscarReceta(Receta receta);
    
}
