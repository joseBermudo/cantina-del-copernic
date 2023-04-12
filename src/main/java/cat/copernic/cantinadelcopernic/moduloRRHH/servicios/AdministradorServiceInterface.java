/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.modelo.Administrador;
import java.util.List;



/**
 *interficie que define los metodos de la capa de servicio para el modelo de Administrador
 * @author andre
 */
public interface AdministradorServiceInterface {
    /**
     *  metodo para recuperar un administrador de la base de datos 
     * @param administrador
     * @return devuelve un administrador  
     */
     public Administrador buscarAdministrador(Administrador administrador);
     
     /**
      * metodo para recupar una lista de administradores 
      * @return sdevuelve una lista de administradores
      */
     public List<Administrador> listarAdministradores();
     /**
      * metodo para añadir un administrador a la base de datos
      * @param administrador 
      */
     public void anadirAdministrador(Administrador administrador); 
     /**
      * metodo para eliminar un adminstrador de la base de datos
      * @param administrador 
      */
     public void eliminarAdministrador(Administrador administrador);
}
