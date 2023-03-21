/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
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
    
    @NotNull
    private double precio;

    private String imagen;
    
    @FutureOrPresent
    private LocalDate fecha;
    
    @NotEmpty
    @Size(max = 45)
    private String nombre;
    
    @NotEmpty
    @Size(max = 500)
    private String descripcion;
      

    @ManyToOne()
    @JoinColumn(name = "receta_idreceta") 
    private Receta receta;
    

    
    @OneToMany(mappedBy = "bocadilloSemana", cascade = CascadeType.REMOVE) 
    private List<Pedido> pedido;
}

