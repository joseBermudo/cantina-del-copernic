/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.gestionModulos.servicios;

import cat.copernic.cantinadelcopernic.DAO.ModuloDAO;
import cat.copernic.cantinadelcopernic.modelo.Modulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joseb
 */
public class GestionModulosService implements  GestionModulosServiceInterface{
    
    @Autowired
    ModuloDAO moduloDAO;
    
    @Override
    @Transactional(readOnly=true) 
    public List<Modulo> listarModulos() {
        return moduloDAO.findAll();
    }
    
}
