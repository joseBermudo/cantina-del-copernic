/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import lombok.Data;

/**
 * Clase entidad Promocion.
 * Hace referencia a la tabla SQL promocion.
 * @author joseb
 */
@Data
@Entity
@Table(name = "promocion")
public class Promocion implements Serializable {
    
    //Id de la promocion.
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpromocion")
    private int id;
    
    //Descripcion de la promocion.
    @Column(name = "descripcion")
    @NotEmpty
    private String desc;
    
    //Condicion de la promocion.
    @NotNull
    @Column(name = "condicion")
    private int condicio;
    
    //Lista de ProfesorPromocion, entidad que relacion Promocion con Profesor.
    @OneToMany(mappedBy="promocion",cascade = CascadeType.REMOVE)
    private List<ProfesorPromocion> profesorPromocion;

}
