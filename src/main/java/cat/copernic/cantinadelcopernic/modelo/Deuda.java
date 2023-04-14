/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 *
 * Esta clase representa la entidad deuda, la cual se utiliza para registrar la
 * cantidad de dinero
 *
 * que un profesor adeuda a la institución educativa. 
 *
 * automáticamente los métodos getter, setter, equals, hashCode y toString. La
 * clase también está
 *
 * anotada con @Entity para indicar que se trata de una entidad de base de
 * datos, y @Table para especificar
 *
 * el nombre de la tabla en la que se guardará la información. La clase
 * implementa la interfaz Serializable
 *
 * para poder ser serializada y deserializada cuando sea necesario.
 * @author Enric
 */
@Data
@Entity
@Table(name = "deuda")
public class Deuda implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     * Identificador único de la deuda. Se genera automáticamente por la base de
     * datos al momento de insertar una nueva fila en la tabla deuda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddeuda")
    private int idDeuda;
    /**
     *
     * Fecha en la que se generó la deuda.
     */
    @NotNull
    @Column(name = "fecha")
    private LocalDate fechaDeLaDeuda;
    /**
     *
     * Cantidad de dinero que el profesor adeuda a la institución educativa.
     */
    @Positive
    @Column(name = "cantidad")
    private float cantidad;
    /**
     *
     * Profesor al que pertenece la deuda. Se utiliza una relación many-to-one
     * para indicar que muchos registros de la tabla deuda pueden estar
     * asociados a un único registro de la tabla profesor. La relación se
     * establece mediante la columna usuarios_correo en la tabla deuda y la
     * columna correo en la tabla profesor.
     */
    @ManyToOne()
    @JoinColumn(name = "usuarios_correo")
    private Profesor profesor;
}
