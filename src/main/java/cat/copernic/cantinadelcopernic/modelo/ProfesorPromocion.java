/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name = "recuento_promocion")
public class ProfesorPromocion implements Serializable{
    
    @EmbeddedId
    private ProfesorPromocionId id;
    
    @ManyToOne
    @MapsId("promocionId")
    @JoinColumn(name = "promocion_idpromocion", insertable = false, updatable = false)
    private Promocion promocion;
    
    @ManyToOne
    @MapsId("usuarioCorreo")
    @JoinColumn(name = "usuarios_correo", insertable = false, updatable = false)
    private Profesor profesor;
    
    private boolean gastado;
    
    private int recuento;
    
}
