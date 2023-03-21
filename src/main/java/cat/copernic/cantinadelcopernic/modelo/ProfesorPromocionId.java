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
 *
 * @author joseb
 */
@Data
@Embeddable
public class ProfesorPromocionId implements Serializable{
    
    @Column(name = "promocion_idpromocion")
    private int promocionId;
    
    @Column(name = "usuarios_correo")
    private String usuarioCorreo;

    public ProfesorPromocionId() {
    }
    
    

    public ProfesorPromocionId(int promocionId, String usuarioCorreo) {
        this.promocionId = promocionId;
        this.usuarioCorreo = usuarioCorreo;
    }
    
}
