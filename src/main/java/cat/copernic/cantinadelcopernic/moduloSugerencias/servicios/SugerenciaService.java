/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.servicios;

import cat.copernic.cantinadelcopernic.DAO.SugerenciaDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que representa la capa de servicio del modulo de sugerencia
 * @author andre
 */
@Service
public class SugerenciaService implements SugerenciaServiceInterface {
    
    @Autowired
    private SugerenciaDAO sugerenciaDAO;

    @Override
    @Transactional(readOnly=true) 
    /**
     * metodo que recupera una lista de todas las sugerencia de la base de datos
     * @return lista de sugerencias
     */
    public List<Sugerencia> listarSugerencias() {
      
        return (List<Sugerencia>) sugerenciaDAO.findAll(); 
    }

    @Override
    @Transactional
    /**
     * metodo que se utiliza para añadir y ediar sugerencias de la base de datos
     * @param sugerencia
     */
    public void anadirSugerencia(Sugerencia sugerencia) {
        this.sugerenciaDAO.save(sugerencia); 
    }

    @Override
    @Transactional
    /**
     * metodo que elimina una sugerencia de la base de datos
     * @param sugerencia
     */
    public void eliminarSugerencia(Sugerencia sugerencia) {
         this.sugerenciaDAO.delete(sugerencia);
    }

    @Override
    @Transactional(readOnly=true)
    /**
     * metodo que busca una sugerencia en la base de datos
     * @param sugerencia
     * @return la sugerencioa encontrada 
     */
    public Sugerencia buscarSugerencia(Sugerencia sugerencia) {
         
         return this.sugerenciaDAO.findById(sugerencia.getIdSugerencia()).orElse(null);
    }

    @Override
    /**
     * metodo que busca las sugerencia especificas de un profesor
     * @param profesor
     * @return lista de las sugerencias del profesor
     */
    public List<Sugerencia> listarSugerenciasProfesor(Profesor profesor) {
        return (List<Sugerencia>) sugerenciaDAO.findByProfesor(profesor); 
    }
    
}
