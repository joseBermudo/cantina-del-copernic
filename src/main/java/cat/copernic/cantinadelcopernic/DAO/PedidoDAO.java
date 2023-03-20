package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

 

public interface PedidoDAO extends JpaRepository<Pedido,Integer>{ 
   
}
