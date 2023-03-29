package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

 

public interface PedidoDAO extends JpaRepository<Pedido,Integer>{ 
    
    List<Pedido> findByProfesores(Profesor profesores);
}
