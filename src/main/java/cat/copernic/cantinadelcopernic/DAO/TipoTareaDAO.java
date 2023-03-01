/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.TipoTarea;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Enric
 */
public interface TipoTareaDAO extends CrudRepository<TipoTarea,Integer>{
    
}