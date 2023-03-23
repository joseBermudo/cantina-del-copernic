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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author andre
 */
@Data
@Entity
@Table(name = "modulos")
public class Modulo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idmodulos")
    private int idmodulos;
    
    @Column(name = "nombre_modulo")
    private String nombreModulo;
    
    @Column(name = "habilitado")
    private boolean habilitado;
    
    @OneToMany(mappedBy="modulo",cascade = CascadeType.ALL)
    private List<ModuloRol> modulosRoles;
    
}
