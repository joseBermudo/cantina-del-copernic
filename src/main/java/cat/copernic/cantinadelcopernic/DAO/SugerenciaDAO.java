/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;



import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.Sugerencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *interficie que define los metodos para acceder a los datos de las sugerencias de la base de datos 
 * @author andre
 */
public interface SugerenciaDAO extends JpaRepository<Sugerencia,Integer>{
      
      /**
       * metodo para listar sugerencias de un solo profesor
       * @param profesor
       * @return devuelve una lista de profesorws 
       */
      List<Sugerencia> findByProfesor(Profesor profesor);
}
