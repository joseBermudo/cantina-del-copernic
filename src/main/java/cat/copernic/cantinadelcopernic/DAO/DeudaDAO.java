/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;

/**

Esta interfaz define los métodos necesarios para acceder y manipular la tabla "Deuda" en la base de datos.

Utiliza la interfaz JpaRepository para implementar de manera sencilla y eficiente las operaciones básicas de CRUD

(Crear, Leer, Actualizar, Eliminar).

@author Enric
*/
public interface DeudaDAO extends JpaRepository<Deuda,Integer>{
    
}
