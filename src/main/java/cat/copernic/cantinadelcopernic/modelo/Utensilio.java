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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author marku
 */
/**
 *
 * La clase Utensilio representa un utensilio que se puede encontrar en un
 * contenedor en el sistema.
 *
 * Esta clase está mapeada a la tabla "utensilio" en la base de datos.
 */
@Data
@Entity
@Table(name = "utensilio")
public class Utensilio implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     * El identificador único del utensilio.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idutensilio")
    private int idutensilio;
    /**
     *
     * El nombre del utensilio. No puede estar vacío.
     */
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    /**
     *
     * La cantidad de unidades del utensilio. No puede ser nulo.
     */
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    /**
     *
     * El contenedor donde se encuentra el utensilio. Cada utensilio debe tener
     * un contenedor asociado.
     */
    @ManyToOne
    @JoinColumn(name = "contenedor_idcontenedor")
    private Contenedor contenedor;
}
