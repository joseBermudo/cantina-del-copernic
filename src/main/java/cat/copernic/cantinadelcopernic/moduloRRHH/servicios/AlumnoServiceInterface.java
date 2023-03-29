/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.modelo.Alumno;
import java.util.List;



/**
 *
 * @author andre
 */
public interface AlumnoServiceInterface {
    
    public List<Alumno> listarAlumnos();
    public void anadirAlumno(Alumno alumno); 
    public void eliminarAlumno(Alumno alumno);
    public Alumno buscarAlumno(Alumno alumno); 
}
