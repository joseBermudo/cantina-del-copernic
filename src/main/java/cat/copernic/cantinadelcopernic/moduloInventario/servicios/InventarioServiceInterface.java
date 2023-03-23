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
public interface InventarioServiceInterface {
    
      //Contenedores 
    public List<Contenedor> listarContenedores(); //Mètode que implementarem per llistar Contenedores 

    public void addContenedor(Contenedor contenedor); //Mètode que implementarem per afegir un Contenedor

    public void eliminarContenedor(Contenedor contenedor); //Mètode que implementarem per eliminar un Contenedor

    public Contenedor buscarContenedor(Contenedor contenedor); //Mètode que implementarem per cercar un Contenedor

    
    
    //Utensilios
    public List<Utensilio> listarUtensilios(); //Mètode que implementarem per llistar Utensilios

    public void addUtensilio(Utensilio utensilio); //Mètode que implementarem per afegir un Utensilio

    public void eliminarUtensilio(Utensilio utensilio); //Mètode que implementarem per eliminar un Utensilio

    public Utensilio buscarUtensilio(Utensilio utensilio); //Mètode que implementarem per cercar un Utensilio
    
}
