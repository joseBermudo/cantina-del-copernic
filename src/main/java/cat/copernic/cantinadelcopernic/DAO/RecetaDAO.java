/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joseb
 */
public interface RecetaDAO extends CrudRepository<Receta,Integer> {
    List<Receta> findByNom(String nom);
}
