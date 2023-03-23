/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;


import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.List;

/**
 *
 * @author andre
 */
public interface ProfesorServiceInterface {
    
    public List<Profesor> listarProfesores();
    
    public void anadirProfesores(Profesor profesor);
    
    public void eliminarProfesores(Profesor profesor);
    
    public Profesor buscarProfesores(Profesor profesor); 
    
}
