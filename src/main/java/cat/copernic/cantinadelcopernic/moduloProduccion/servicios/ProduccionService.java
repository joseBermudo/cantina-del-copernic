/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloProduccion.servicios;

import cat.copernic.cantinadelcopernic.DAO.BebidaDAO;
import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.Bebida;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joseb
 */
@Service
public class ProduccionService implements ProduccionServiceInterface {

    @Autowired
    RecetaDAO recetaDAO;

    @Autowired
    BebidaDAO bebidaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Receta> obtenerRecetas() {
        return recetaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bebida> obtenerBebidas() {
        return bebidaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardarBebida(Bebida bebida) {
        bebidaDAO.save(bebida);
    }

    @Override
    @Transactional(readOnly = true)
    public Bebida buscarBebida(Bebida bebida) {
        return bebidaDAO.findById(bebida.getId()).orElse(null);

    }

    @Override
    @Transactional
    public void guardarReceta(Receta receta) {
        recetaDAO.save(receta);
    }

    @Override
    @Transactional(readOnly = true)
    public Receta buscarReceta(Receta receta) {
        return recetaDAO.findById(receta.getId()).orElse(null);
    }

}
