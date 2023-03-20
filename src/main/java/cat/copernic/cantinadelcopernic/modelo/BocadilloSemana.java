/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 *
 * @author marku
 */
@Data
@Entity
@Table(name = "bocadillo_semana")
public class BocadilloSemana implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbocadillo_semana;
       
    private double precio;

    private String imagen;

    private LocalDate fecha;

    private String nombre;
    
    private String descripcion;
      

    @ManyToOne()
    @JoinColumn(name = "receta_idreceta") 
    private Receta receta;
    

    
    @OneToMany(mappedBy = "bocadilloSemana", cascade = CascadeType.REMOVE) 
    private List<Pedido> pedido;
}

