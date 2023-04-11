/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.gestionModulos.servicios;

import cat.copernic.cantinadelcopernic.DAO.ModuloDAO;
import cat.copernic.cantinadelcopernic.DAO.RolDAO;
import cat.copernic.cantinadelcopernic.modelo.Modulo;
import cat.copernic.cantinadelcopernic.modelo.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servcio que se comunica con el DAO de Modulo y Rol.
 * @author joseb
 */
@Service
public class GestionModulosService implements  GestionModulosServiceInterface{
    
    @Autowired
    ModuloDAO moduloDAO;
    @Autowired
    RolDAO rolDAO;
    
    /**
     * Lee todos los modulos de la base de datos.
     * @return Devuelve una lista con todos los modulos.
     */
    @Override
    @Transactional(readOnly=true) 
    public List<Modulo> listarModulos() {
        return moduloDAO.findAll();
    }
    
    /**
     * Lee todos los Rol de la base de datos.
     * @return Devuele una lista de todos los roles.
     */
    @Override
    @Transactional(readOnly=true) 
    public List<Rol> listarRoles() {
        return rolDAO.findAll();
    }
    
    /**
     * Lee un modulo en especifico de la base de datos.
     * @param modulo Modulo que buscara en la base de datos.
     * @return Devuelve el Modulo encontrado o null si no existe.
     */
    @Override
    public Modulo buscarModulo(Modulo modulo) {
       return moduloDAO.findById(modulo.getIdmodulos()).orElse(null);
    }
    
    /**
     * Guarda y atualiza un modulo en la base de datos.
     * @param modulo Modulo que guardara en la base de datos.
     */
    @Override
    @Transactional() 
    public void guardarModulo(Modulo modulo) {
        moduloDAO.save(modulo);
    }

    
    
    

    
    
}
