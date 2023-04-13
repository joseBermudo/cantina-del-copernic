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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * Clase entidad que representa el Rol.
 * Hace referencia a la tabla SQL roles.
 * @author joseb
 */
@Data
@Entity
@Table(name = "roles")
public class Rol implements Serializable {
    
    //Version de la instancia
    private static final long serialVersionUID = 1L;
    
    //Id del rol.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idroles")
    private int idroles;
    
    //Nombre del rol.
    private String nombre;
    
    //Lista de ModulosRol, instancia que relaciona los Modulos con los Roles.
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<ModuloRol> modulosRoles;

}
