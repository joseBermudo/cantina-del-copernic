/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.servicios;

import cat.copernic.cantinadelcopernic.DAO.DeudaDAO;
import cat.copernic.cantinadelcopernic.DAO.ProfesorDAO;
import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Enric
 */
@Service
public class DeudaService implements DeudaServiceInterface{
    @Autowired
    private DeudaDAO deudaDAO;
    
    @Autowired
    private ProfesorDAO profesorDAO;
    
    @Override
    @Transactional(readOnly=true) 
    public List<Deuda> listarDeudas() {
       
        return (List<Deuda>) deudaDAO.findAll(); 
    } 

    @Override
    @Transactional
    public void anadirDeuda(Deuda deuda) {
       
        this.deudaDAO.save(deuda); 
    }

    @Override
    @Transactional
    public void eliminarDeuda(Deuda deuda) {
        
        this.deudaDAO.delete(deuda);
    }

    @Override
    @Transactional(readOnly=true)
    public Deuda buscarDeuda(Deuda deuda) {
        
       return this.deudaDAO.findById(deuda.getIdDeuda()).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Profesor buscarProfesor(Profesor profesor) {
        return profesorDAO.findById(profesor.getCorreo()).orElse(null);
    }
    
    
}
