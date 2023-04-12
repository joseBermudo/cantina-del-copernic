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
 * Servicio que implementa la interfaz TareaServiceInterface y proporciona
 * métodos para gestionar las tareas y tipos de tarea.
 *
 * @author Enric
 */
@Service
public class TareaService implements TareaServiceInterface {

    @Autowired
    private TareaDAO tarea;

    @Autowired
    private TipoTareaDAO tipoTarea;

    /**
     *
     * Devuelve una lista de tareas correspondientes al mes y año actual.
     *
     * @param mesActual el mes actual
     * @param anyoActual el año actual
     * @return una lista de tareas correspondientes al mes y año actual
     */
    @Override
    public List<Tarea> findTareasDelMesActual(int mesActual, int anyoActual) {
        return tarea.findTareasDelMesActual(mesActual, anyoActual);
    }
/////////////TIPO TAREA/////////////

    /**
     *
     * Devuelve una lista de todos los tipos de tarea.
     *
     * @return una lista de todos los tipos de tarea
     */
    @Override
    @Transactional(readOnly = true)
    public List<TipoTarea> llistarTipoTarea() {
        return (List<TipoTarea>) tipoTarea.findAll();
    }

    /**
     *
     * Agrega un tipo de tarea.
     *
     * @param tipoTarea el tipo de tarea a agregar
     */
    @Override
    @Transactional
    public void afegirTipoTarea(TipoTarea tipoTarea) {
        this.tipoTarea.save(tipoTarea);
    }

    /**
     *
     * Elimina un tipo de tarea.
     *
     * @param tipoTarea el tipo de tarea a eliminar
     */
    @Override
    @Transactional
    public void eliminarTipoTarea(TipoTarea tipoTarea) {
        this.tipoTarea.delete(tipoTarea);
    }

    /**
     *
     * Busca un tipo de tarea por su ID y lo devuelve si existe.
     *
     * @param tipoTarea el tipo de tarea a buscar
     * @return el tipo de tarea si existe, o null si no existe
     */
    @Override
    @Transactional(readOnly = true)
    public TipoTarea cercarTipoTarea(TipoTarea tipoTarea) {
        return this.tipoTarea.findById(tipoTarea.getId()).orElse(null);
    }
/////////////TAREA/////////////

    /**
     *
     * Devuelve una lista de todas las tareas.
     *
     * @return una lista de todas las tareas
     */
    @Override
    @Transactional(readOnly = true)
    public List<Tarea> llistarTareas() {
        return (List<Tarea>) tarea.findAll();
    }

    /**
     *
     * Agrega una tarea.
     *
     * @param tarea la tarea a agregar
     */
    @Override
    public void afegirTarea(Tarea tarea) {
        this.tarea.save(tarea);
    }

    /**
     *
     * Elimina una tarea.
     *
     * @param tarea la tarea a eliminar
     */
    @Override
    public void eliminarTarea(Tarea tarea) {
        this.tarea.delete(tarea);
    }

    /**
     *
     * Busca una tarea por su ID y la devuelve si existe.
     *
     * @param tarea la tarea a buscar
     * @return la tarea si existe, o null si no existe
     */
    @Override
    public Tarea cercarTarea(Tarea tarea) {
        return this.tarea.findById(tarea.getId()).orElse(null);
    }
}
