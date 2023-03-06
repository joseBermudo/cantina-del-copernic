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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author marku
 */
@Data
@Entity
@Table(name = "bocadillo_semana")
public class BocadilloSemana {

    
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbocadillo_semana")
    private int idbocadillo_semana;
       
    @Column(name = "precio")
    private double precio;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "receta_idreceta")
    private int receta_idreceta;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "desc")
    private String desc;
    
       @Column(name = "receta_idreceta")
    private Receta receta;
       
    

}

