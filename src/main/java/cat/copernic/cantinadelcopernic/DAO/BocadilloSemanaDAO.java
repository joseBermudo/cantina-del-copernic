package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interfaz define los métodos para acceder a los datos de los bocadillos de la semana en la base de datos.
 * Utiliza Spring Data JPA para generar las consultas SQL automáticamente.
 */
public interface BocadilloSemanaDAO extends JpaRepository<BocadilloSemana,Integer>{ 
    
   
}
