/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Receta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *  Interfaz que aplica el repositorio Jpa de la entidad Receta.
 * @author joseb
 */
public interface RecetaDAO extends JpaRepository<Receta,Integer> {
    /**
     * 
     * @param nombre nombre de la receta.
     * @return Una lista de recetas que tienen el nombre espeficicado.
     */
    List<Receta> findByNombre(String nombre);
}
