/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.gestionModulos.servicios;

import cat.copernic.cantinadelcopernic.modelo.Modulo;
import cat.copernic.cantinadelcopernic.modelo.Rol;
import java.util.List;

/**
 *Interfaz que define los metodos para hablar con la base de datos respecto
 * a la gestion de modulos.
 * @author joseb
 */
public interface GestionModulosServiceInterface {
    
    /**
     * Lista todos los modulos de la base de datos.
     * @return Lista de todos los modulos.
     */
    public List<Modulo> listarModulos();
    
    /**
     * Lista todos los Rol de la base de datos.
     * @return Lista de todos los roles.
     */
    public List<Rol> listarRoles();
    
    /**
     * Lee un modulo en especifico de la base de datos.
     * @param modulo Modulo que leemos.
     * @return El modulo leido.
     */
    public Modulo buscarModulo(Modulo modulo);
    
    /**
     * Guarda o actualiza un modulo en la base de datos.
     * @param modulo Modulo que guardamos o actualizamos.
     */
    public void guardarModulo(Modulo modulo);
}
