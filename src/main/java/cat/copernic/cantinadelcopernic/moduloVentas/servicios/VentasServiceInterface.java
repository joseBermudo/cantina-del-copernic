/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.servicios;

import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.List;

/**
 *
 * @author marku
 */
/**
 *
 * Interfaz que define los métodos necesarios para gestionar las ventas de la
 * empresa.
 */
public interface VentasServiceInterface {

//Pedidos
    /**
     *
     * Retorna una lista de todos los pedidos guardados en la base de datos.
     *
     * @return Lista de objetos Pedido.
     */
    public List<Pedido> listarPedidos();

    /**
     *
     * Agrega un nuevo pedido a la base de datos.
     *
     * @param pedido Pedido a agregar.
     */
    public void addPedidos(Pedido pedido);

    /**
     *
     * Elimina un pedido existente de la base de datos.
     *
     * @param pedido Pedido a eliminar.
     */
    public void eliminarPedido(Pedido pedido);

    /**
     *
     * Busca un pedido en la base de datos según su identificador.
     *
     * @param pedido Pedido a buscar.
     * @return Objeto Pedido encontrado.
     */
    public Pedido buscarPedido(Pedido pedido);
//bocadillo de la semana

    /**
     *
     * Retorna una lista de todos los bocadillos de la semana guardados en la
     * base de datos.
     *
     * @return Lista de objetos BocadilloSemana.
     */
    public List<BocadilloSemana> listarBocadilloSemana();

    /**
     *
     * Agrega un nuevo bocadillo de la semana a la base de datos.
     *
     * @param bocaSemana Bocadillo de la semana a agregar.
     */
    public void addBocadilloSemana(BocadilloSemana bocaSemana);

    /**
     *
     * Elimina un bocadillo de la semana existente de la base de datos.
     *
     * @param bocaSemana Bocadillo de la semana a eliminar.
     */
    public void eliminarBocadilloSemana(BocadilloSemana bocaSemana);

    /**
     *
     * Busca un bocadillo de la semana en la base de datos según su
     * identificador.
     *
     * @param bocadilloSemana Bocadillo de la semana a buscar.
     * @return Objeto BocadilloSemana encontrado.
     */
    public BocadilloSemana buscarBocadilloSemana(BocadilloSemana bocadilloSemana);
//Recetas

    /**
     *
     * Retorna una lista de todas las recetas guardadas en la base de datos.
     *
     * @return Lista de objetos Receta.
     */
    public List<Receta> listarRecetas();

    /**
     *
     * Retorna una lista de todos los pedidos asociados a un profesor
     * específico.
     *
     * @param profesores Profesor al que se le buscarán los pedidos.
     * @return Lista de objetos Pedido asociados al profesor especificado.
     */
    public List<Pedido> findByProfesores(Profesor profesores);
}
