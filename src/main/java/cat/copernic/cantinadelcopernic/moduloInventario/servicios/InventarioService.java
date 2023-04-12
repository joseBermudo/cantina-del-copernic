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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * La clase InventarioService es la implementación de la interfaz
 * InventarioServiceInterface,
 *
 * la cual se encarga de manejar la lógica de negocio para el inventario de
 * contenedores y utensilios.
 *
 * Esta clase utiliza los objetos ContenedorDAO y UtensilioDAO para realizar las
 * operaciones necesarias
 *
 * en la base de datos.
 */
@Service
public class InventarioService implements InventarioServiceInterface {

    @Autowired
    private ContenedorDAO contDAO;

    @Autowired
    private UtensilioDAO utenDAO;

    /**
     *
     * Devuelve una lista con todos los contenedores en la base de datos.
     *
     * @return una lista con todos los contenedores
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contenedor> listarContenedores() {
        return (List<Contenedor>) contDAO.findAll();
    }

    /**
     *
     * Agrega un nuevo contenedor a la base de datos.
     *
     * @param contenedor el contenedor que se desea agregar
     */
    @Override
    @Transactional
    public void addContenedor(Contenedor contenedor) {
        this.contDAO.save(contenedor);
    }

    /**
     *
     * Elimina un contenedor de la base de datos.
     *
     * @param contenedor el contenedor que se desea eliminar
     */
    @Override
    @Transactional
    public void eliminarContenedor(Contenedor contenedor) {
        this.contDAO.delete(contenedor);
    }

    /**
     *
     * Busca un contenedor en la base de datos.
     *
     * @param contenedor el contenedor que se desea buscar
     * @return el contenedor encontrado, o null si no existe en la base de datos
     */
    @Override
    @Transactional(readOnly = true)
    public Contenedor buscarContenedor(Contenedor contenedor) {
        return this.contDAO.findById(contenedor.getIdcontenedor()).orElse(null);
    }

    /**
     *
     * Devuelve una lista con todos los utensilios en la base de datos.
     *
     * @return una lista con todos los utensilios
     */
    @Override
    @Transactional(readOnly = true)
    public List<Utensilio> listarUtensilios() {
        return (List<Utensilio>) utenDAO.findAll();
    }

    /**
     *
     * Agrega un nuevo utensilio a la base de datos.
     *
     * @param utensilio el utensilio que se desea agregar
     */
    @Override
    @Transactional
    public void addUtensilio(Utensilio utensilio) {
        this.utenDAO.save(utensilio);
    }

    /**
     *
     * Elimina un utensilio de la base de datos.
     *
     * @param utensilio el utensilio que se desea eliminar
     */
    @Override
    @Transactional
    public void eliminarUtensilio(Utensilio utensilio) {
        this.utenDAO.delete(utensilio);
    }

    /**
     *
     * Busca un utensilio en la base de datos.
     *
     * @param utensilio el utensilio que se desea buscar
     * @return el utensilio encontrado, o null si no existe en la base de datos
     */
    @Override
    @Transactional(readOnly = true)
    public Utensilio buscarUtensilio(Utensilio utensilio) {
        return this.utenDAO.findById(utensilio.getIdutensilio()).orElse(null);
    }
}
