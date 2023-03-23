/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joseb
 */
public interface RolDAO extends JpaRepository<Rol,Integer>{
    
}
