/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;


import cat.copernic.cantinadelcopernic.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *interficie que define los metodos para acceder a los datos de los profesores de la base de datos 
 * @author andre
 */
public interface ProfesorDAO  extends JpaRepository<Profesor,String> {
    
     
}
