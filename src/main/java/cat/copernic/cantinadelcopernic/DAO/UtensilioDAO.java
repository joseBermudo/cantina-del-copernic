package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Utensilio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

    
/**
 * Esta interfaz define los métodos para acceder a los datos de los utensilios en la base de datos.
 * Utiliza Spring Data JPA para generar las consultas SQL automáticamente.
 */
public interface UtensilioDAO extends JpaRepository<Utensilio, Integer> {
    
    /**
     * Busca los utensilios que tienen un nombre que coincide exactamente con el nombre especificado.
     * @param nombre el nombre exacto de los utensilios a buscar.
     * @return una lista de objetos Utensilio que tienen el nombre especificado.
     */
    List<Utensilio> findByNombre(String nombre);
}
