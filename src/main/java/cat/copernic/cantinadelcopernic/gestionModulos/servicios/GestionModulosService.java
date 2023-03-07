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
 *
 * @author joseb
 */
@Service
public class GestionModulosService implements  GestionModulosServiceInterface{
    
    @Autowired
    ModuloDAO moduloDAO;
    @Autowired
    RolDAO rolDAO;
    
    @Override
    @Transactional(readOnly=true) 
    public List<Modulo> listarModulos() {
        return moduloDAO.findAll();
    }
    
    @Override
    @Transactional(readOnly=true) 
    public List<Rol> listarRoles() {
        return rolDAO.findAll();
    }
    
}
