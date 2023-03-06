/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.servicios;

import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.PedidoDAO;
import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marku
 */
public class VentasService implements VentasServiceInterface {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Autowired
    private BocadilloSemanaDAO bocaSemanaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> listarPedidos() {

        return (List<Pedido>) pedidoDAO.findAll();
    }

    @Override
    @Transactional
    public void addPedidos(Pedido pedido) {

        this.pedidoDAO.save(pedido);
    }

    @Override
    @Transactional
    public void eliminarPedido(Pedido pedido) {

        this.pedidoDAO.delete(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido buscarPedido(Pedido pedido) {

        return this.pedidoDAO.findById(pedido.getId_bebida()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BocadilloSemana> listarBocadilloSemana() {

        return (List<BocadilloSemana>) bocaSemanaDAO.findAll();
    }

    @Override
    @Transactional
    public void addBocadilloSemana(BocadilloSemana bocadilloSemana) {

        this.bocaSemanaDAO.save(bocadilloSemana);
    }

    @Override
    @Transactional
    public void eliminarBocadilloSemana(BocadilloSemana bocadilloSemana) {

        this.bocaSemanaDAO.delete(bocadilloSemana);
    }

    @Override
    @Transactional(readOnly = true)
    public BocadilloSemana buscarBocadilloSemana(BocadilloSemana bocadilloSemana) {

        return this.bocaSemanaDAO.findById(bocadilloSemana.getIdbocadillo_semana()).orElse(null);
    }

}
