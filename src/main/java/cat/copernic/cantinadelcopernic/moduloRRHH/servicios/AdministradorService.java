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
 * Clase que representa la capa de servicio para el modelo de Administrador
 * @author andre
 */
@Service 
public class AdministradorService implements AdministradorServiceInterface {
   
    @Autowired
    private AdministradorDAO administradorDAO; 
    
    @Override
    @Transactional(readOnly=true)
    /**
     * metodo que busca un administrador en especfico
     * @param administrador
     * @return devuelve el administrador encontrado
     */
    public Administrador buscarAdministrador(Administrador administrador) {
        
         return this.administradorDAO.findById(administrador.getCorreo()).orElse(null);
    }

    @Override
     /**
     * metodo que recupera una lista de todos los administradores de la base de datos
     * @return lista de sugerencias
     */
    public List<Administrador> listarAdministradores() {
        return (List<Administrador>) administradorDAO.findAll(); 
    }

    @Override
     /**
     * metodo que se utiliza para añadir y ediar administradores de la base de datos
     * @param administrador
     */
    public void anadirAdministrador(Administrador administrador) {
        this.administradorDAO.save(administrador); 
    }

    @Override
    /**
     * metodo que elimina un administrador de la base de datos
     * @param administrador
     */
    public void eliminarAdministrador(Administrador administrador) {
             this.administradorDAO.delete(administrador);
    }
    
}
