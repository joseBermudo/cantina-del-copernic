package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

 
/**
 * Esta interfaz define los métodos para acceder a los datos de los pedidos en la base de datos.
 * Utiliza Spring Data JPA para generar las consultas SQL automáticamente.
 */
public interface PedidoDAO extends JpaRepository<Pedido,Integer>{ 
    
      /**
     * Busca todos los pedidos realizados por un determinado profesor.
     * @param profesor el objeto Profesor del que se desean buscar los pedidos realizados.
     * @return una lista de objetos Pedido correspondientes a los pedidos realizados por el profesor especificado.
     */
    List<Pedido> findByProfesores(Profesor profesores);
}
