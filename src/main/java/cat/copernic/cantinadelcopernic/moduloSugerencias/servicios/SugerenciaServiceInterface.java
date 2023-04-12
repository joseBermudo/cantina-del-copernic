/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.servicios;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import java.util.List;

/**
 *interficie que define los metodos de la capa de servicio del modulo de sugerencias
 * @author andre
 */
public interface SugerenciaServiceInterface {
    /**
     * metodo para listar las sugerencias
     * @return devuelve una lista de sugerencias
     */
    public List<Sugerencia> listarSugerencias();
    
    /**
     * metdo para añadir una sugerencia a la base de datos
     * @param sugerencia 
     */
    public void anadirSugerencia(Sugerencia sugerencia);
    
    /**
     * metodo para eliminar una sugerencia de la base de datos
     * @param sugerencia 
     */
    public void eliminarSugerencia(Sugerencia sugerencia);
    
    /**
     * metodo para recuperar una sugerencia de la base de datos 
     * @param sugerencia
     * @return devuelve una sugerencia
     */
    public Sugerencia buscarSugerencia(Sugerencia sugerencia); 
    
    /**
     * metodo para recupear una lista de sugerencias de un profesor en especifico
     * @param profesor
     * @return 
     */
    public List<Sugerencia> listarSugerenciasProfesor(Profesor profesor);
    
}
