/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;


import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.List;

/**
 *interficie que define los metodos de la capa de servicio para el modelo de Profesor
 * @author andre
 */
public interface ProfesorServiceInterface {
    /**
     * metodo para recupara una lista de profesores
     * @return devuelve una lista de profesores 
     */
    public List<Profesor> listarProfesores();
    /**
     * metodo para añadir un profesor a la base de datos 
     * @param profesor 
     */
    public void anadirProfesores(Profesor profesor);
    
    /**
     * metodo para eliminar un profesor de la base de datos
     * @param profesor 
     */
    public void eliminarProfesores(Profesor profesor);
    /**
     * metodo para buscar un profesor
     * @param profesor
     * @return devuelve un profesor
     */
    public Profesor buscarProfesores(Profesor profesor); 
    
}
