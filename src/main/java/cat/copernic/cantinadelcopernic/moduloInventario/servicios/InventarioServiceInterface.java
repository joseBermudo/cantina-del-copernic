/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloInventario.servicios;

import cat.copernic.cantinadelcopernic.modelo.Contenedor;
import cat.copernic.cantinadelcopernic.modelo.Utensilio;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.*;
import java.util.List;

/**
 *
 * @author marku
 */
/**
 *
 * Interfaz que define los métodos para el servicio de inventario de
 * contenedores y utensilios.
 */
public interface InventarioServiceInterface {

    /**
     *
     * Método que devuelve una lista de contenedores.
     *
     * @return una lista de objetos de tipo Contenedor
     */
    public List<Contenedor> listarContenedores();

    /**
     *
     * Método que agrega un nuevo contenedor.
     *
     * @param contenedor el objeto Contenedor que se desea agregar
     */
    public void addContenedor(Contenedor contenedor);

    /**
     *
     * Método que elimina un contenedor existente.
     *
     * @param contenedor el objeto Contenedor que se desea eliminar
     */
    public void eliminarContenedor(Contenedor contenedor);

    /**
     *
     * Método que busca un contenedor en la base de datos.
     *
     * @param contenedor el objeto Contenedor que se desea buscar
     *
     * @return el objeto Contenedor encontrado o null si no se encuentra
     */
    public Contenedor buscarContenedor(Contenedor contenedor);

    /**
     *
     * Método que devuelve una lista de utensilios.
     *
     * @return una lista de objetos de tipo Utensilio
     */
    public List<Utensilio> listarUtensilios();

    /**
     *
     * Método que agrega un nuevo utensilio.
     *
     * @param utensilio el objeto Utensilio que se desea agregar
     */
    public void addUtensilio(Utensilio utensilio);

    /**
     *
     * Método que elimina un utensilio existente.
     *
     * @param utensilio el objeto Utensilio que se desea eliminar
     */
    public void eliminarUtensilio(Utensilio utensilio);

    /**
     *
     * Método que busca un utensilio en la base de datos.
     *
     * @param utensilio el objeto Utensilio que se desea buscar
     * @return el objeto Utensilio encontrado o null si no se encuentra
     */
    public Utensilio buscarUtensilio(Utensilio utensilio);
}
