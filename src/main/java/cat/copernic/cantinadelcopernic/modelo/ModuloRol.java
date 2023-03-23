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
 *
 * @author joseb
 */
@Data
@Entity
@Table(name = "visibilidad")
public class ModuloRol implements Serializable {
    
    @EmbeddedId
    private ModuloRolId id;
    
    @ManyToOne
    @MapsId("modulosIdModulos")
    @JoinColumn(name = "modulos_idmodulos", insertable = false, updatable = false)
    private Modulo modulo;
    
    @ManyToOne
    @MapsId("rolesIdRoles")
    @JoinColumn(name = "roles_idroles", insertable = false, updatable = false)
    private Rol rol;
    
    private Boolean visible;
}
