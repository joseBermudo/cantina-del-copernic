/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.DAO.AlumnoDAO;
import cat.copernic.cantinadelcopernic.modelo.Alumno;
import cat.copernic.cantinadelcopernic.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author andre
 */
@Service 
public class AlumnoService implements AlumnoServiceInterface{

    @Autowired
    private AlumnoDAO alumnoDAO;
    
    @Override
    @Transactional(readOnly=true) 
    public Usuario buscarProfesores(Alumno alumno) {
       
        return this.alumnoDAO.findById(alumno.getCorreo()).orElse(null);
    }
    
}
