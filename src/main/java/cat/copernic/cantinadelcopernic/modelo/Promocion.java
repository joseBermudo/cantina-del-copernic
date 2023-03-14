/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashMap;
import lombok.Data;

/**
 *
 * @author joseb
 */
@Data
@Entity
@Table(name = "promocion")
public class Promocion implements Serializable {

    @Id //Indica al sistema que l'atribut idgos és la clau primària de la BBDDr
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpromocion")
    private int id;
    
    @Column(name = "descripcion")
    private String desc;
    
    @Column(name = "condicion")
    private int condicio;
    
    //private HashMap<Profesor,Integer> profesores;

}
