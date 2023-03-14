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
import lombok.Data;

/**
 *
 * @author joseb
 */
@Data
@Entity
@Table(name = "bebida")
public class Bebida implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id //Indica al sistema que l'atribut idgos és la clau primària de la BBDD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idbebida")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="descripcion")
    private String desc;
    
    @Column(name="precio")
    private Double precio;
}
