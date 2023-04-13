/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Bebida;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *Interficie que aplica el JpaRepositorio de la entidad Bebida
 * @author joseb
 */
public interface BebidaDAO extends JpaRepository<Bebida,Integer>{
    /**
     * 
     * @param nombre nombre por el cual se busca la bebida
     * @return  lista de bebidas tiene el nombre especificaso.
     */
    List<Bebida> findByNombre(String nombre);
}
