/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.DAO.AdministradorDAO;

import cat.copernic.cantinadelcopernic.modelo.Administrador;
import cat.copernic.cantinadelcopernic.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author andre
 */
@Service 
public class AdministradorService implements AdministradorServiceInterface {
   
    @Autowired
    private AdministradorDAO administradorDAO; 
    
    @Override
    @Transactional(readOnly=true) 
    public Administrador buscarAdministrador(Administrador administrador) {
        
         return this.administradorDAO.findById(administrador.getCorreo()).orElse(null);
    }

    @Override
    public List<Administrador> listarAdministradores() {
        return (List<Administrador>) administradorDAO.findAll(); 
    }

    @Override
    public void anadirAdministrador(Administrador administrador) {
        this.administradorDAO.save(administrador); 
    }

    @Override
    public void eliminarAlumno(Administrador administrador) {
             this.administradorDAO.delete(administrador);
    }
    
}
