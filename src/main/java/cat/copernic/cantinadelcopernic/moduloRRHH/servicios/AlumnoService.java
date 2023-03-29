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
 *
 * @author andre
 */
@Service 
public class AlumnoService implements AlumnoServiceInterface{

    @Autowired
    private AlumnoDAO alumnoDAO;
    
    @Override
    public void anadirAlumno(Alumno alumno) {
       
        this.alumnoDAO.save(alumno); 
    }

    @Override
    public List<Alumno> listarAlumnos() {
       return (List<Alumno>) alumnoDAO.findAll(); 
    }

    @Override
    public void eliminarAlumno(Alumno alumno) {
       this.alumnoDAO.delete(alumno);
    }

    @Override
    public Alumno buscarAlumno(Alumno alumno) {
         return this.alumnoDAO.findById(alumno.getCorreo()).orElse(null);
    }
    
}
