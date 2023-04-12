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

Esta interfaz define los métodos necesarios para acceder y manipular la tabla "Tarea" en la base de datos.

Utiliza la interfaz JpaRepository para implementar de manera sencilla y eficiente las operaciones básicas de CRUD

(Crear, Leer, Actualizar, Eliminar).

@author Enric
*/
public interface TareaDAO extends JpaRepository<Tarea, Integer> {
    
    @Query(value = "SELECT * FROM tarea WHERE YEAR(fecha) = ?2 AND MONTH(fecha) = ?1", nativeQuery = true)
    List<Tarea> findTareasDelMesActual(int mesActual, int anyoActual);
}
