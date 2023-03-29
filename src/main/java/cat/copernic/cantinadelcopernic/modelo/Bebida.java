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
    @NotEmpty
    private String nombre;
    
    @Column(name="descripcion")
    private String desc;
    @NotNull
    @Column(name="precio")
    private Double precio;
//    
//    
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pedido_id_pedido")
//    private List<Pedido> pedido;
}
