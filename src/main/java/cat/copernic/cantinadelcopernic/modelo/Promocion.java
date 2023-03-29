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
    @NotEmpty
    private String desc;
    
    @NotNull
    @Column(name = "condicion")
    private int condicio;
    
    @OneToMany(mappedBy="promocion",cascade = CascadeType.REMOVE)
    private List<ProfesorPromocion> profesorPromocion;

}
