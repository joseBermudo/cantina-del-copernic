/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.DAO.AlumnoDAO;
import cat.copernic.cantinadelcopernic.modelo.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que representa la capa de servicio para el modelo de Alumno
 * @author andre
 */
@Service 
public class AlumnoService implements AlumnoServiceInterface{

    @Autowired
    private AlumnoDAO alumnoDAO;
    
    @Override
    /**
     * metodo que se utiliza para añadir y ediar alumnos de la base de datos
     * @param alumno
     */
    public void anadirAlumno(Alumno alumno) {
       
        this.alumnoDAO.save(alumno); 
    }

    @Override
    /**
     * metodo que recupera una lista de todos los alumnos de la base de datos
     * @return lista de alumnos
     */
    public List<Alumno> listarAlumnos() {
       return (List<Alumno>) alumnoDAO.findAll(); 
    }

    @Override
    /**
     * metodo que elimina un alumno de la base de datos
     * @param alumno
     */
    public void eliminarAlumno(Alumno alumno) {
       this.alumnoDAO.delete(alumno);
    }

    @Override
    /**
     * metodo que busca una lumno en la base de datos
     * @param alumno
     * @return el alumno encontrdo
     */
    public Alumno buscarAlumno(Alumno alumno) {
         return this.alumnoDAO.findById(alumno.getCorreo()).orElse(null);
    }
    
}
