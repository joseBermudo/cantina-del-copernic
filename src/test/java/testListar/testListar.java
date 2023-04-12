/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testListar;

import cat.copernic.cantinadelcopernic.moduloSugerencias.servicios.SugerenciaService;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;*/

/**
 *
 * @author andre
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(locations = "application.properties")
public class testListar {
   
    @Autowired
    private SugerenciaService sugerenciaService;
    
    @Test
    public void testListar(){
        
        var lista = sugerenciaService.listarSugerencias();
        
       assertTrue(!lista.isEmpty());
    }
}
