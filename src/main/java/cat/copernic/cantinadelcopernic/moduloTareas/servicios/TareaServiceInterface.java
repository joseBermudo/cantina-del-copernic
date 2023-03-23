/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores.servicios;

import cat.copernic.cantinadelcopernic.modelo.Tarea;
import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import java.util.List;

/**
 *
 * @author Enric
 */
public interface TareaServiceInterface {
    
    public List<Tarea> findTareasDelMesActual(int mesActual, int anyoActual);
    
    public List<Tarea> llistarTareas(); 
    
    public void afegirTipoTarea(TipoTarea tipoTarea); 
    
    public void eliminarTipoTarea(TipoTarea tipoTarea);
    
    public TipoTarea cercarTipoTarea(TipoTarea tipoTarea); 
    
    public List<TipoTarea> llistarTipoTarea();
    
    public void afegirTarea(Tarea tarea);
    
    public void eliminarTarea(Tarea tarea);
    
    public Tarea cercarTarea(Tarea tarea);
}
