/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Promocion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joseb
 */
public interface PromocionDAO extends CrudRepository<Promocion,Integer> {
    List<Promocion> findByNom(String nom);
}
