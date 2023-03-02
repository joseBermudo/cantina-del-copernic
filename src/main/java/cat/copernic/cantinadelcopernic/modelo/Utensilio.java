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
import lombok.Data;
/**
 *
 * @author marku
 */
@Data
@Entity
@Table(name = "utensilio")
public class Utensilio {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "idutensilio")   
    private int id;
     
    @Column(name= "nombre")  
    private String nombre;
    
    @Column(name= "cantidad")  
    private int cantidad;
    
    @Column(name= "contenedor_idcontenedor") 
    private String id_contenedor;
}
