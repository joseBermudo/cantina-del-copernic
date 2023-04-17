package cat.copernic.cantinadelcopernic.DAO;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import cat.copernic.cantinadelcopernic.modelo.Pedido;
import cat.copernic.cantinadelcopernic.moduloVentas.servicios.VentasService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;

// Anotación para indicar que esta es una clase de pruebas que usa Spring Boot
@SpringBootTest
public class VentasServiceTest {
// Inyección de dependencia del servicio de ventas

    @Autowired
    private VentasService ventasSer;

// Mock del DAO de pedidos
    @Mock
    private PedidoDAO pedidoDAO;

// Mock del DAO de bocadillos de la semana
    @Mock
    private BocadilloSemanaDAO bocaSemanaDAO;

// Mock del DAO de recetas
    @Mock
    private RecetaDAO recetaDAO;

// Objeto de la clase VentasService que se va a probar
    @InjectMocks
    private VentasService ventasService;

// Test para el método listarPedidos
    @Test
    public void testListarPedidos() {
        // Creamos una lista de pedidos de prueba
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(ventasSer.listarPedidos().get(0));
        pedidos.add(ventasSer.listarPedidos().get(1));
        // Cuando se llame al método findAll del pedidoDAO, devolvemos la lista de pedidos de prueba
        when(pedidoDAO.findAll()).thenReturn(pedidos);
        // Comprobamos que la lista devuelta por el método listarPedidos es igual a la lista de pedidos de prueba
        assertEquals(pedidos, ventasService.listarPedidos());
    }

// Test para el método addPedidos
    @Test
    public void testAddPedidos() {
        // Creamos un pedido de prueba
        Pedido pedido = ventasSer.listarPedidos().get(0);
        pedido.setId_pedido(110);
        // Cuando se llame al método save del pedidoDAO, no hacemos nada
        when(pedidoDAO.save(pedido)).thenAnswer(invocation -> invocation.getArgument(0));
        // Añadimos el pedido de prueba con el método addPedidos
        ventasService.addPedidos(pedido);
        // Comprobamos que el método save del pedidoDAO ha sido llamado una vez
        verify(pedidoDAO, times(1)).save(pedido);
    }
}
