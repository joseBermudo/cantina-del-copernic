/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import cat.copernic.cantinadelcopernic.modelo.Receta;
import cat.copernic.cantinadelcopernic.moduloProduccion.controladores.ControladorListaRecetas;
import cat.copernic.cantinadelcopernic.moduloProduccion.servicios.ProduccionService;
import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author joseb
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ControladorListaRecetas.class)

public class TestControllerListaRecetas {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProduccionService proServ;

    @InjectMocks
    private ControladorListaRecetas controller;

    @Test
public void testPage() throws Exception {
    List<Receta> recetas = new ArrayList<>();
    // Agregar recetas a la lista

    // Crear instancia del controlador
    ControladorListaRecetas controller = new ControladorListaRecetas();

    // Mockear el servicio
    ProduccionService mockServicio = Mockito.mock(ProduccionService.class);
    Mockito.when(mockServicio.obtenerRecetas()).thenReturn(recetas);

    // Setear el servicio mockeado en el controlador
    controller.setProServ(mockServicio);

    // Crear instancia del objeto mockMvc para realizar las pruebas
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    // Realizar la petición GET a /listaRecetas y comprobar el resultado
    mockMvc.perform(get("/listaRecetas"))
            .andExpect(status().isOk())
            .andExpect(view().name("/paginasProduccion/listaRecetas"))
            .andExpect(model().attribute("recetas", recetas));
}

    

}
