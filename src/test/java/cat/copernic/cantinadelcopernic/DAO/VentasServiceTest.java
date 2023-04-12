package cat.copernic.cantinadelcopernic.DAO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import cat.copernic.cantinadelcopernic.DAO.BocadilloSemanaDAO;
import cat.copernic.cantinadelcopernic.DAO.PedidoDAO;
import cat.copernic.cantinadelcopernic.DAO.RecetaDAO;
import cat.copernic.cantinadelcopernic.modelo.BocadilloSemana;
import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Receta;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;

//
//@SpringBootTest
//public class VentasServiceTest {
//
//    @Mock
//    private PedidoDAO pedidoDAO;
//
//    @Mock
//    private BocadilloSemanaDAO bocaSemanaDAO;
//
//    @Mock
//    private RecetaDAO recetaDAO;
//
//    @InjectMocks
//    private VentasService ventasService;
//
//    @Test
//    public void testListarPedidos() {
//        // Creamos una lista de pedidos de prueba
//        List<Pedido> pedidos = new ArrayList<>();
//        pedidos.add(new Pedido(1, "Bocadillo de jamón", 2.5, new Profesor()));
//        pedidos.add(new Pedido(2, "Bocadillo de queso", 3.0, new Profesor()));
//        // Cuando se llame al método findAll del pedidoDAO, devolvemos la lista de pedidos de prueba
//        when(pedidoDAO.findAll()).thenReturn(pedidos);
//        // Comprobamos que la lista devuelta por el método listarPedidos es igual a la lista de pedidos de prueba
//        assertEquals(pedidos, ventasService.listarPedidos());
//    }
//
//    @Test
//    public void testAddPedidos() {
//        // Creamos un pedido de prueba
//        Pedido pedido = new Pedido(1, "Bocadillo de jamón", 2.5, new Profesor());
//        // Cuando se llame al método save del pedidoDAO, no hacemos nada
//        when(pedidoDAO.save(pedido)).thenAnswer(invocation -> invocation.getArgument(0));
//        // Añadimos el pedido de prueba con el método addPedidos
//        ventasService.addPedidos(pedido);
//        // Comprobamos que el método save del pedidoDAO ha sido llamado una vez
//        verify(pedidoDAO, times(1)).save(pedido);
//    }
//
//    // Se pueden implementar más tests para los demás métodos de la clase VentasService
//}