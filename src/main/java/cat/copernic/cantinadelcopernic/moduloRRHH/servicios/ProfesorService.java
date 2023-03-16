/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.DAO.ProfesorDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
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
    
    @Autowired
    private SugerenciaService sugerenciaService;
    
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
        if (profesor.getSugerencias() != null || !profesor.getSugerencias().isEmpty()) {
            
            for (Sugerencia sugerencia : profesor.getSugerencias()) {
                
                sugerenciaService.eliminarSugerencia(sugerencia);
            }
        }
        this.profesorDAO.delete(profesor);
    }

    @Override
    @Transactional(readOnly=true)
    public Profesor buscarProfesores(Profesor profesor) {
        
       return this.profesorDAO.findById(profesor.getCorreo()).orElse(null);
    }
    
}
