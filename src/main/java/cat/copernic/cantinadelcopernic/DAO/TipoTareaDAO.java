/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Enric
 */
public interface TipoTareaDAO extends JpaRepository<TipoTarea,Integer>{
    
}