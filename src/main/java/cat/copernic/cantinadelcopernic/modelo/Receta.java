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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import lombok.Data;

/**
 * Clase entidad Receta.
 * Hace referencia a la tabla SQL receta.
 * @author joseb
 */
@Data
@Entity
@Table(name = "receta")
public class Receta implements Serializable {
    
    //Id de la receta.
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreceta")
    private int id;
    
    //Nombre de la receta.
    @Column(name = "nombre")
    @NotEmpty
    private String nombre;
    
    //Descripcion de la receta.
    @Column(name = "descripcion")
    @NotEmpty
    private String descripcion;
    
    //Ingredientes de la receta.
    @Column(name="ingredientes")
    private String ing;
    
}
