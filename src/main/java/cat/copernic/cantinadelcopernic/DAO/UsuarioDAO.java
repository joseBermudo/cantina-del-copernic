/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *interficie que define los metodos para acceder a los datos de los usuarios de la base de datos 
 * @author andre
 */
public interface UsuarioDAO   extends CrudRepository<Usuario,String>{
    /**
     * metdo para buscar un usuario por su username
     * @param username
     * @return devuelve un usuario
     */
       Usuario findByUsername(String username);
}
