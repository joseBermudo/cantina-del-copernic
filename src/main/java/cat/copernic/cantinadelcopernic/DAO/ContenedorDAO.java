package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Contenedor;
import org.springframework.data.jpa.repository.JpaRepository;


    
/**
 * Esta interfaz define los métodos para acceder a los datos de los contenedores en la base de datos.
 * Utiliza Spring Data JPA para generar las consultas SQL automáticamente.
 */
public interface ContenedorDAO extends JpaRepository<Contenedor,String>{ 
    
   
}
