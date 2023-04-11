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
 * Servicio Promocion que comunica con el DAO de Promocion, Profesor y ProfesorPromocion.
 * @author joseb
 */
@Service
public class PromocionService implements PromocionServiceInterface {
    
    //DAo de Promocion.
    @Autowired
    private PromocionDAO promocionDAO;

    //DAO de Profesor.
    @Autowired
    private ProfesorDAO profesorDAO;
    
    //DAO de ProfesorPromocion.
    @Autowired
    private ProfesorPromocionDAO profPromDAO;
    
    /**
     * Lee todas las promociones de la base de datos.
     * @return Devuelve una lista de todas las promociones.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Promocion> obtenerPromociones() {
        return promocionDAO.findAll();
    }
    
    /**
     * Guarda o actualiza una promocion en la base de datos.
     * @param promocion Promocion que guarda o actualiza.
     */
    @Override
    @Transactional
    public void guardarPromocion(Promocion promocion) {
        promocionDAO.save(promocion);
    }
    
    /**
     * Lee una Promocion especifica de la base de datos.
     * @param promocion Procion que lee.
     * @return Devuelve la Promocion leida.
     */
    @Override
    @Transactional(readOnly = true)
    public Promocion buscarPromocion(Promocion promocion) {
        return promocionDAO.findById(promocion.getId()).orElse(null);
    }
    
    /**
     * Lee todos los profesoresd de la base de datos.
     * @return Devuelve una lista con los profesores obtenidos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Profesor> obetnerClientes() {
        return profesorDAO.findAll();
    }
    
    /**
     * Lee la ultima promocion guardada en la base de datos.
     * @return Devuelve la ultima promocion guardada en la base de datos.
     */
    @Override
    @Transactional(readOnly = true)
    public Promocion obetnerUltimaPromocion() {
        
        ArrayList<Promocion> list = (ArrayList<Promocion>) promocionDAO.findAll();
        return list.get(list.size()-1);
    }
    
    /**
     * Elimina una promocion de la base de datos.
     * @param promocion La promocion que elimina.
     */
    @Override
    @Transactional
    public void eliminarPromocion(Promocion promocion) {
        
        //Elimianmos todos los registros que relacionan la promocion eliminada
        //con los profesores.
        profPromDAO.deleteAll(promocion.getProfesorPromocion());
        
        promocionDAO.delete(promocion);
    }
    
    /**
     * Utiliza la promocion por parte del profesor.
     * Espcificamente borra un registro (ProfesorPromocion)que relaciona a la 
     * promocion con el profesor.
     * @param profesorPromocion Registro que eliminamos (Entidad ProfesorPromocion).
     */
    @Override
    @Transactional
    public void utilizarPromocion(ProfesorPromocion profesorPromocion) {
        profPromDAO.delete(profesorPromocion);
        
    }
    
    /**
     * Guarda o actualiza los registros que relacionan una promocion con el profesor.
     * @param list Lista de registros.
     */
    @Override
    @Transactional
    public void gurdarProfesorPromocion(List<ProfesorPromocion> list) {
        profPromDAO.saveAll(list);
    }
    
    
    
    /**
     * Lee un registro especifico que relaciona una promocion con un profesor.
     * @param profesorPromocion
     * @return Devuelve el registro especificado o nulo si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public ProfesorPromocion buscarPromocionProfesor(ProfesorPromocion profesorPromocion) {
        return profPromDAO.findById(profesorPromocion.getId()).orElse(null);
                
    }
    
    /**
     * Lee un profesor especifico de la base de datos.
     * @param profesor Profesor que lee.
     * @return El profesor especificado o nulo si no existe.
     */
    @Override
    @Transactional(readOnly = true)
    public Profesor buscarProfesor(Profesor profesor) {
        return profesorDAO.findById(profesor.getCorreo()).orElse(null);
    }
    
    /**
     * Lee todos los registros (ProfesorPromocion) que tienen un correo
     * especificado.
     * @param correo Correo electronico del profesor.
     * @return Lista de registros.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProfesorPromocion> obtenerPromocionesUsuario(String correo) {
        return profPromDAO.findByCorreo(correo);
    }

    
    
    

}
