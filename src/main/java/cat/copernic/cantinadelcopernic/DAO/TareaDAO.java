/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Tarea;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Enric
 */
public interface TareaDAO extends JpaRepository<Tarea, Integer> {
    
    @Query(value = "SELECT * FROM tarea WHERE YEAR(fecha) = ?2 AND MONTH(fecha) = ?1", nativeQuery = true)
    List<Tarea> findTareasDelMesActual(int mesActual, int anyoActual);
}
