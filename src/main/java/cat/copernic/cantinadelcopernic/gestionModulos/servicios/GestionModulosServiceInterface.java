/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.gestionModulos.servicios;

import cat.copernic.cantinadelcopernic.modelo.Modulo;
import cat.copernic.cantinadelcopernic.modelo.Rol;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface GestionModulosServiceInterface {
    public List<Modulo> listarModulos();
    
    public List<Rol> listarRoles();
}
