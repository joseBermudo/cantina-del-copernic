/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author andre
 */
public interface UsuarioDAO   extends CrudRepository<Usuario,String>{
       Usuario findByUsername(String username);
}
