package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Utensilio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

    

public interface UtensilioDAO extends JpaRepository<Utensilio,Integer>{ 
   
    List<Utensilio> findByNombre(String nombre);
}
