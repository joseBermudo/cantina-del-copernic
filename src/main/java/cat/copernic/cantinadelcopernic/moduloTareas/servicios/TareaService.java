/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores.servicios;

import cat.copernic.cantinadelcopernic.DAO.TareaDAO;
import cat.copernic.cantinadelcopernic.DAO.TipoTareaDAO;
import cat.copernic.cantinadelcopernic.modelo.Tarea;
import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Enric
 */
@Service
public class TareaService implements TareaServiceInterface {

    @Autowired
    private TareaDAO tarea;
    
    @Autowired
    private TipoTareaDAO tipoTarea;

    @Override
    public List<Tarea> findTareasDelMesActual(int mesActual, int anyoActual) {
        return tarea.findTareasDelMesActual(mesActual, anyoActual);
    }

    /////////////TIPO TAREA/////////////
    @Override
    @Transactional(readOnly=true) 
    public List<TipoTarea> llistarTipoTarea() {
        return (List<TipoTarea>) tipoTarea.findAll(); 
    }

    @Override
    @Transactional
    public void afegirTipoTarea(TipoTarea tipoTarea) {
        this.tipoTarea.save(tipoTarea);
    }

    @Override
    @Transactional 
    public void eliminarTipoTarea(TipoTarea tipoTarea) {
        this.tipoTarea.delete(tipoTarea);
    }

    @Override
    @Transactional(readOnly=true)
    public TipoTarea cercarTipoTarea(TipoTarea tipoTarea) {
        return this.tipoTarea.findById(tipoTarea.getId()).orElse(null);
    }

    /////////////TAREA/////////////
    @Override
    @Transactional(readOnly=true) 
    public List<Tarea> llistarTareas() {
        return (List<Tarea>) tarea.findAll(); 
    }

    @Override
    public void afegirTarea(Tarea tarea) {
        this.tarea.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        this.tarea.delete(tarea);
    }

    @Override
    public Tarea cercarTarea(Tarea tarea) {
        return this.tarea.findById(tarea.getId()).orElse(null);
    }
    
    public Tarea obtenerTareaPorId(int id) {
        return this.tarea.findById(id).orElse(null);
    }

}
