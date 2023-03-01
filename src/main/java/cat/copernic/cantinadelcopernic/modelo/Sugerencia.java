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
    
    @Column(name = "usuarios_correo")
    private String correoprofesor;
    
    private String titulo;
    
    @Column(name = "desc")
    private String descripcion;
    
    private Boolean leida;
}
