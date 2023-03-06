/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author joseb
 */
@Embeddable
public class ModuloRolId implements Serializable{
    
    @Column(name="modulos_idmodulos")
    private int idModulo;
    
    @Column(name="roles_idroles")
    private int idRol;
    
}
