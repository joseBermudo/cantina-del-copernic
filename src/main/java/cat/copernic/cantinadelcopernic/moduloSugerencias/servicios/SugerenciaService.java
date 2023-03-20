/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloSugerencias.servicios;

import cat.copernic.cantinadelcopernic.DAO.SugerenciaDAO;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author andre
 */
@Service 
public class SugerenciaService implements SugerenciaServiceInterface {
    
    @Autowired
    private SugerenciaDAO sugerenciaDAO;

    @Override
    @Transactional(readOnly=true) 
    public List<Sugerencia> listarSugerencias() {
      
        return (List<Sugerencia>) sugerenciaDAO.findAll(); 
    }

    @Override
    @Transactional
    public void anadirSugerencia(Sugerencia sugerencia) {
        this.sugerenciaDAO.save(sugerencia); 
    }

    @Override
    @Transactional
    public void eliminarSugerencia(Sugerencia sugerencia) {
         this.sugerenciaDAO.delete(sugerencia);
    }

    @Override
    @Transactional(readOnly=true)
    public Sugerencia buscarSugerencia(Sugerencia sugerencia) {
         
         return this.sugerenciaDAO.findById(sugerencia.getIdSugerencia()).orElse(null);
    }
    
}
