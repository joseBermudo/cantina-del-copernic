/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Clade entidad Bebida.
 * Hace referencia a la tabla SQL bebida.
 * @author joseb
 */
@Data
@Entity
@Table(name = "bebida")
public class Bebida implements Serializable {

    //Versiond de la instancia.
    private static final long serialVersionUID = 1L;
    
    //Id de la bebida.
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idbebida")
    private int id;
    
    //Nombre de la bebida.
    @Column(name="nombre")
    @NotEmpty
    private String nombre;
    
    //Descripción de la bebida.
    @Column(name="descripcion")
    private String desc;
    
    //Precio de la bebida.
    @NotNull
    @Column(name="precio")
    private Double precio;

}
