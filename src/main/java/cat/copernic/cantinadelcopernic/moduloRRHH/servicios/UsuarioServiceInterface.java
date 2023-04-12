/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.modelo.Usuario;

/**
 *interficie que define los metodos de la capa de servicio para el modelo de Usuario
 * @author andre
 */
public interface UsuarioServiceInterface {
      /**
       * metodo para buscar un usuario
       * @param usuario
       * @return devuelve un uuario
       */
      public Usuario buscarUsuario(Usuario usuario);
    
}
