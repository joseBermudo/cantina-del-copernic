/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.modelo.Alumno;
import java.util.List;



/**
 *interficie que define los metodos de la capa de servicio para el modelo de Alumno
 * @author andre
 */
public interface AlumnoServiceInterface {
    /**
     * metodo para recupar una lista de alumnos 
     * @return 
     */
    public List<Alumno> listarAlumnos();
    /**
     *  metodo para añadir un alumno a la base de datos
     * @param alumno 
     */
    public void anadirAlumno(Alumno alumno);
    /**
     * metodo para eliminar un alumno de la base de datos
     * @param alumno 
     */
    public void eliminarAlumno(Alumno alumno);
    /**
     * metodo para buscar un alumno
     * @param alumno
     * @return devuelve un alumno
     */
    public Alumno buscarAlumno(Alumno alumno); 
}
