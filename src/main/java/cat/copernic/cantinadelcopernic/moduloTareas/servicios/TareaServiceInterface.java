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
 * Interfaz que define los métodos que debe implementar una clase que ofrezca
 * servicios relacionados con la gestión de tareas y tipos de tarea.
 *
 * @author Enric
 */
public interface TareaServiceInterface {

    /**
     *
     * Busca y devuelve una lista de tareas correspondientes al mes y año
     * actual.
     *
     * @param mesActual el mes actual en formato numérico (1 = enero, 2 =
     * febrero, etc.)
     * @param anyoActual el año actual en formato numérico (ej. 2023)
     * @return una lista de objetos Tarea correspondientes al mes y año actual
     */
    public List<Tarea> findTareasDelMesActual(int mesActual, int anyoActual);

    /**
     *
     * Devuelve una lista con todas las tareas existentes en la base de datos.
     *
     * @return una lista de objetos Tarea
     */
    public List<Tarea> llistarTareas();

    /**
     *
     * Añade un nuevo tipo de tarea a la base de datos.
     *
     * @param tipoTarea el objeto TipoTarea a añadir
     */
    public void afegirTipoTarea(TipoTarea tipoTarea);

    /**
     *
     * Elimina un tipo de tarea de la base de datos.
     *
     * @param tipoTarea el objeto TipoTarea a eliminar
     */
    public void eliminarTipoTarea(TipoTarea tipoTarea);

    /**
     *
     * Busca y devuelve un objeto TipoTarea a partir de su identificador único.
     *
     * @param tipoTarea el objeto TipoTarea que contiene el identificador a
     * buscar
     * @return el objeto TipoTarea encontrado, o null si no existe
     */
    public TipoTarea cercarTipoTarea(TipoTarea tipoTarea);

    /**
     *
     * Devuelve una lista con todos los tipos de tarea existentes en la base de
     * datos.
     *
     * @return una lista de objetos TipoTarea
     */
    public List<TipoTarea> llistarTipoTarea();

    /**
     *
     * Añade una nueva tarea a la base de datos.
     *
     * @param tarea el objeto Tarea a añadir
     */
    public void afegirTarea(Tarea tarea);

    /**
     *
     * Elimina una tarea de la base de datos.
     *
     * @param tarea el objeto Tarea a eliminar
     */
    public void eliminarTarea(Tarea tarea);

    /**
     *
     * Busca y devuelve un objeto Tarea a partir de su identificador único.
     *
     * @param tarea el objeto Tarea que contiene el identificador a buscar
     * @return el objeto Tarea encontrado, o null si no existe
     */
    public Tarea cercarTarea(Tarea tarea);
}
