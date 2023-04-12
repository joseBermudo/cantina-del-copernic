/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

/**
 * Clase que representa la id compuesta de ModuloRol.
 * @author joseb
 */
@Data
@Embeddable
public class ModuloRolId implements Serializable {
    
    //Id del Modulo
    @Column(name = "modulos_idmodulos")
    private int modulosIdModulos;

    //Id del Rol.
    @Column(name = "roles_idroles")
    private int rolesIdRoles;
    
    /**
     * Constructor vacio necesario.
     */
    public ModuloRolId() {
    }
    
    /**
     * Constructor para crear una nueva id compuesta.
     * @param modulosIdModulos Id del modulo.
     * @param rolesIdRoles  Id del Rol.
     */
    public ModuloRolId(int modulosIdModulos, int rolesIdRoles) {
        this.modulosIdModulos = modulosIdModulos;
        this.rolesIdRoles = rolesIdRoles;
    }

}
