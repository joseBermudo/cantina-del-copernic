/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.servicios;

import cat.copernic.cantinadelcopernic.DAO.ContenedorDAO;
import cat.copernic.cantinadelcopernic.DAO.UtensilioDAO;
import cat.copernic.cantinadelcopernic.modelo.Contenedor;
import cat.copernic.cantinadelcopernic.modelo.Utensilio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marku
 */
public class InventarioService implements InventarioServiceInterface {

    @Autowired
    private ContenedorDAO contDAO;

    @Autowired
    private UtensilioDAO utenDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Contenedor> listarContenedores() {
        return (List<Contenedor>) contDAO.findAll();
    }

    @Override
    @Transactional
    public void addContenedor(Contenedor contenedor) {
        this.contDAO.save(contenedor);
    }

    @Override
    @Transactional
    public void eliminarContenedor(Contenedor contenedor) {
        this.contDAO.delete(contenedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Contenedor buscarContenedor(Contenedor contenedor) {
        return this.contDAO.findById(contenedor.getIdcontenedor()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Utensilio> listarUtensilios() {
        return (List<Utensilio>) utenDAO.findAll();
    }

    @Override
    @Transactional
    public void addUtensilio(Utensilio utensilio) {
        this.utenDAO.save(utensilio);
    }

    @Override
    @Transactional
    public void eliminarUtensilio(Utensilio utensilio) {
        this.utenDAO.delete(utensilio);
    }

    @Override
    @Transactional(readOnly = true)
    public Utensilio buscarUtensilio(Utensilio utensilio) {
        return this.utenDAO.findById(utensilio.getId()).orElse(null);
    }
}
