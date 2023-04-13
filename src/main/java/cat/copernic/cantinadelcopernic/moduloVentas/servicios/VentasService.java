/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.servicios;

import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.PedidoDAO;
import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Esta clase implementa la interfaz VentasServiceInterface y se encarga de
 * proveer los servicios relacionados con la venta de bocadillos y bebidas.
 */
@Service
public class VentasService implements VentasServiceInterface {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Autowired
    private BocadilloSemanaDAO bocaSemanaDAO;

    @Autowired
    private RecetaDAO recetaDAO;

    /**
     *
     * Lista todos los pedidos.
     *
     * @return una lista de pedidos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Pedido> listarPedidos() {

        return (List<Pedido>) pedidoDAO.findAll();
    }

    /**
     *
     * Añade un nuevo pedido.
     *
     * @param pedido el pedido a añadir.
     */
    @Override
    @Transactional
    public Pedido addPedidos(Pedido pedido) {

        return this.pedidoDAO.save(pedido);
    }

    /**
     *
     * Elimina un pedido existente.
     *
     * @param pedido el pedido a eliminar.
     */
    @Override
    @Transactional
    public void eliminarPedido(Pedido pedido) {

        this.pedidoDAO.delete(pedido);
    }

    /**
     *
     * Busca un pedido por su ID.
     *
     * @param pedido el pedido a buscar.
     *
     * @return el pedido encontrado o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly = true)
    public Pedido buscarPedido(Pedido pedido) {

        return this.pedidoDAO.findById(pedido.getId_pedido()).orElse(null);
    }

    /**
     *
     * Lista todos los bocadillos de la semana.
     *
     * @return una lista de bocadillos de la semana.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BocadilloSemana> listarBocadilloSemana() {

        return (List<BocadilloSemana>) bocaSemanaDAO.findAll();
    }

    /**
     *
     * Añade un nuevo bocadillo de la semana.
     *
     * @param bocadilloSemana el bocadillo de la semana a añadir.
     */
    @Override
    @Transactional
    public void addBocadilloSemana(BocadilloSemana bocadilloSemana) {

        this.bocaSemanaDAO.save(bocadilloSemana);
    }

    /**
     *
     * Elimina un bocadillo de la semana existente.
     *
     * @param bocadilloSemana el bocadillo de la semana a eliminar.
     */
    @Override
    @Transactional
    public void eliminarBocadilloSemana(BocadilloSemana bocadilloSemana) {

        this.bocaSemanaDAO.delete(bocadilloSemana);
    }

    /**
     *
     * Busca un bocadillo de la semana por su ID.
     *
     * @param bocadilloSemana el bocadillo de la semana a buscar.
     *
     * @return el bocadillo de la semana encontrado o null si no se encuentra.
     */
    @Override
    @Transactional(readOnly = true)
    public BocadilloSemana buscarBocadilloSemana(BocadilloSemana bocadilloSemana) {

        return this.bocaSemanaDAO.findById(bocadilloSemana.getIdbocadillo_semana()).orElse(null);
    }

    /**
     *
     * Retorna una lista de todas las recetas guardadas en la base de datos.
     *
     * @return Lista de objetos Receta.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Receta> listarRecetas() {
        return (List<Receta>) recetaDAO.findAll();
    }

    /**
     *
     * Retorna una lista de todos los pedidos asociados a un profesor
     * específico.
     *
     * @param profesores Profesor al que se le buscarán los pedidos.
     * @return Lista de objetos Pedido asociados al profesor especificado.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findByProfesores(Profesor profesores) {
        return (List<Pedido>) pedidoDAO.findByProfesores(profesores);
    }
}
