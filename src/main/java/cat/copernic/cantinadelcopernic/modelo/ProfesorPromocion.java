/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 * Clase entidad ProfesorPromocion, que relaciona las entidades Promocion y Profesor.
 * Hace referencia a la tabla SQL recuento_promocion.
 * @author joseb
 */
@Data
@Entity
@Table(name = "recuento_promocion")

public class ProfesorPromocion implements Serializable {
    
    //Id compuesta, formado por las id de Promocion y Profesor.
    @EmbeddedId
    private ProfesorPromocionId id;
    
    //Promocion de la relacion.
    @ManyToOne
    @MapsId("promocionId")
    @JoinColumn(name = "promocion_idpromocion", insertable = false, updatable = false)
    private Promocion promocion;
    
    //Profesor de la relacion.
    @ManyToOne
    @MapsId("usuarioCorreo")
    @JoinColumn(name = "usuarios_correo", insertable = false, updatable = false)
    private Profesor profesor;
    
    //Boolean que indica si la promocion de la relación se ha utilizado.
    private boolean gastado;
    
    //Int que indica el recuento.
    private int recuento;
    
    /**
     * Constructor vacio necesario.
     */
    public ProfesorPromocion() {
    }
    
    /**
     * Constructor con todos los parametros.
     * @param id Id compuesta, ProfesorPromocionId
     * @param promocion Promocion de la relacion.
     * @param profesor Profesor de la relacion.
     * @param gastado 
     * @param recuento 
     */
    public ProfesorPromocion(ProfesorPromocionId id, Promocion promocion, Profesor profesor, boolean gastado, int recuento) {
        this.id = id;
        this.promocion = promocion;
        this.profesor = profesor;
        this.gastado = gastado;
        this.recuento = recuento;
    }

}
