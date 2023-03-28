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
public interface VentasServiceInterface {

    //Pedidos
    public List<Pedido> listarPedidos(); //Mètode que implementarem per llistar comandes

    public void addPedidos(Pedido pedido); //Mètode que implementarem per afegir una comanda

    public void eliminarPedido(Pedido pedido); //Mètode que implementarem per eliminar una comanda

    public Pedido buscarPedido(Pedido pedido); //Mètode que implementarem per cercar una comanda

    //bocadillo de la semana
    public List<BocadilloSemana> listarBocadilloSemana(); //Mètode que implementarem per llistar Entrepans de la Setmana

    public void addBocadilloSemana(BocadilloSemana bocaSemana); //Mètode que implementarem per afegir un Entrepans de la Setmana

    public void eliminarBocadilloSemana(BocadilloSemana bocaSemana); //Mètode que implementarem per eliminar un Entrepans de la Setmana

    public BocadilloSemana buscarBocadilloSemana(BocadilloSemana bocadilloSemana); //Mètode que implementarem per cercar un Entrepans de la Setmana
    
    //Pedidos
    public List<Receta> listarRecetas(); //Mètode que implementarem per llistar Recetas
    
    public List<Pedido> findByProfesores(Profesor profesores);
}
