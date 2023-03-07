/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.DAO.ProfesorDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author andre
 */
@Service 
public class ProfesorService  implements ProfesorServiceInterface {
    
    @Autowired
    private ProfesorDAO profesorDAO;
    
    @Override
    @Transactional(readOnly=true) 
    public List<Profesor> listarProfesores() {
       
        return (List<Profesor>) profesorDAO.findAll(); 
    }

    @Override
    @Transactional
    public void anadirProfesores(Profesor profesor) {
       
        this.profesorDAO.save(profesor); 
    }

    @Override
    @Transactional
    public void eliminarProfesores(Profesor profesor) {
        
        this.profesorDAO.delete(profesor);
    }

    @Override
    @Transactional(readOnly=true)
    public Profesor buscarProfesores(Profesor profesor) {
        
       return this.profesorDAO.findById(profesor.getCorreo()).orElse(null);
    }
    
}
