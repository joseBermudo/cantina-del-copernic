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
 * Clase que representa la id compuesta de ProfesorPromocion.
 * @author joseb
 */
@Data
@Embeddable
public class ProfesorPromocionId implements Serializable{
    
    //Id de la promocion
    @Column(name = "promocion_idpromocion")
    private int promocionId;
    
    //Id del profesor.
    @Column(name = "usuarios_correo")
    private String usuarioCorreo;
    
    /**
     * Constructor necesario.
     */
    public ProfesorPromocionId() {
    }
    
    
    /**
     * Constructor para crear una nueva id compuesta.
     * @param promocionId Id de la promocion
     * @param usuarioCorreo Id del usuario.
     */
    public ProfesorPromocionId(int promocionId, String usuarioCorreo) {
        this.promocionId = promocionId;
        this.usuarioCorreo = usuarioCorreo;
    }
    
}
