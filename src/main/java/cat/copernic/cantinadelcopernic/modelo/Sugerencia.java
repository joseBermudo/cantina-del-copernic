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
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author andre
 */
@Data
@Entity
@Table(name = "sugerencia")
public class Sugerencia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idsugerencia")
    private int idSugerencia;
    
    /*@Column(name = "usuarios_correo")
    private String correoProfesor;*/
    
    private String titulo;
    
    @Column(name = "des")
    private String descripcion;
    
    private Boolean leida = false;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_correo")
    private Profesor profesor;
}
