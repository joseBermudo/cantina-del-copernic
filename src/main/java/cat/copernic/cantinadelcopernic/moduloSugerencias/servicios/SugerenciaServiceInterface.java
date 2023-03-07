/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.servicios;

import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import java.util.List;

/**
 *
 * @author andre
 */
public interface SugerenciaServiceInterface {
    
    public List<Sugerencia> listarSugerencias();
    
    public void anadirSugerencia(Sugerencia sugerencia);
    
    public void eliminarSugerencia(Sugerencia sugerencia);
    
    public Sugerencia buscarSugerencia(Sugerencia sugerencia); 
    
}
