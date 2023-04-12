/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 * Clase entidad ModuloRol que relaciona la entidad Modulo con Rol.
 * Hace referencia a la tabla SQL visibilidad.
 * @author joseb
 */
@Data
@Entity
@Table(name = "visibilidad")
public class ModuloRol implements Serializable {
    
    //Id compuesta de tipo ModuloRolId.
    @EmbeddedId
    private ModuloRolId id;
    
    //Variable que contiene el modulo de la relacion.
    @ManyToOne
    @MapsId("modulosIdModulos")
    @JoinColumn(name = "modulos_idmodulos", insertable = false, updatable = false)
    private Modulo modulo;
    
    //Variable que contiene el modulo de la relacion.
    @ManyToOne
    @MapsId("rolesIdRoles")
    @JoinColumn(name = "roles_idroles", insertable = false, updatable = false)
    private Rol rol;
    
    //Boolean que indica si  el modulo es visible para el Rol.
    private Boolean visible;
}
