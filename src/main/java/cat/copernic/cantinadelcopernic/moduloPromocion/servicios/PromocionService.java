/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.servicios;

import cat.copernic.cantinadelcopernic.DAO.ProfesorDAO;
import cat.copernic.cantinadelcopernic.DAO.ProfesorPromocionDAO;
import cat.copernic.cantinadelcopernic.DAO.PromocionDAO;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocion;

import cat.copernic.cantinadelcopernic.modelo.Promocion;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joseb
 */
@Service
public class PromocionService implements PromocionServiceInterface {

    @Autowired
    private PromocionDAO promocionDAO;

    @Autowired
    private ProfesorDAO profesorDAO;
    
    @Autowired
    private ProfesorPromocionDAO profPromDAO;
    

    @Override
    @Transactional(readOnly = true)
    public List<Promocion> obtenerPromociones() {
        return promocionDAO.findAll();
    }

    @Override
    @Transactional
    public void guardarPromocion(Promocion promocion) {
        promocionDAO.save(promocion);
    }

    @Override
    @Transactional(readOnly = true)
    public Promocion buscarPromocion(Promocion promocion) {
        return promocionDAO.findById(promocion.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> obetnerClientes() {
        return profesorDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Promocion obetnerUltimaPromocion() {
        
        ArrayList<Promocion> list = (ArrayList<Promocion>) promocionDAO.findAll();
        return list.get(list.size()-1);
    }

    @Override
    @Transactional
    public void eliminarPromocion(Promocion promocion) {
        
        profPromDAO.deleteAll(promocion.getProfesorPromocion());
        
        promocionDAO.delete(promocion);
    }

    @Override
    @Transactional
    public void utilizarPromocion(ProfesorPromocion profesorPromocion) {
        profPromDAO.delete(profesorPromocion);
        
    }

    @Override
    @Transactional
    public void gurdarProfesorPromocion(List<ProfesorPromocion> list) {
        profPromDAO.saveAll(list);
    }
    
    
    

    @Override
    @Transactional(readOnly = true)
    public ProfesorPromocion buscarPromocionProfesor(ProfesorPromocion profesorPromocion) {
        return profPromDAO.findById(profesorPromocion.getId()).orElse(null);
                
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor buscarProfesor(Profesor profesor) {
        return profesorDAO.findById(profesor.getCorreo()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorPromocion> obtenerPromocionesUsuario(String correo) {
        return profPromDAO.findByCorreo(correo);
    }

    
    
    

}
