/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Enric
 */
public interface DeudaDAO extends JpaRepository<Deuda,Integer>{
    
}
