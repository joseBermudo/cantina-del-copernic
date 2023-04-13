/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.servicios;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio que se comunica con el DAO de Receta y Bebida. 
 * @author joseb
 */
@Service
public class ProduccionService implements ProduccionServiceInterface {
    
    //DAO de Receta.
    @Autowired
    RecetaDAO recetaDAO;
    
    //DAO de Bebida.
    @Autowired
    BebidaDAO bebidaDAO;
    
    /**
     * Lee todas la recetas de la base de datos.
     * @return Devuelve una lista con todas la recetas leidas..
     */
    @Override
    @Transactional(readOnly = true)
    public List<Receta> obtenerRecetas() {
        return recetaDAO.findAll();
    }
    
    /**
     * Lee todas las bebidas de la base de datos.
     * @return Devuelve una lista de todas las bebidas leidas.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Bebida> obtenerBebidas() {
        return bebidaDAO.findAll();
    }
    
    /**
     * Guarda o actualiza una bebida en la base de datos.
     * @param bebida Bebida que guardamos o actualizamos.
     */
    @Override
    @Transactional
    public void guardarBebida(Bebida bebida) {
        bebidaDAO.save(bebida);
    }
    
    /**
     * Obtiene una bebida especifica de la base de datos.
     * @param bebida Bebida que buscamos obtener.
     * @return Devuelve la bebida especifica o null si no la encuentra.
     */
    @Override
    @Transactional(readOnly = true)
    public Bebida buscarBebida(Bebida bebida) {
        return bebidaDAO.findById(bebida.getId()).orElse(null);

    }
    
    /**
     * Guarda o actualiza una receta en la base de datos.
     * @param receta Receta que guardamos o actualizamos.
     */
    @Override
    @Transactional
    public Receta guardarReceta(Receta receta) {
       
       return recetaDAO.save(receta);
    }
    
    /**
     * Obtiene una receta especifica de la base de datos.
     * @param receta Receta que buscamos obtener.
     * @return  Devvuelve la receta especifica o null si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Receta buscarReceta(Receta receta) {
        return recetaDAO.findById(receta.getId()).orElse(null);
    }

}
