/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

/**
 *
 * La clase Tarea representa una tarea asignada a un alumno en una fecha
 * determinada. La clase está anotada
 *
 * con @Data para generar automáticamente los métodos getter, setter, equals,
 * hashCode y toString.
 *
 * La clase está anotada con @Entity para indicar que se trata de una entidad de
 * base de datos, y @Table
 *
 * para especificar el nombre de la tabla en la que se guardará la información.
 * @author Enric
 */
@Data
@Entity
@Table(name = "tarea")
public class Tarea {

    /**
     *
     * Identificador único de la tarea. Se genera automáticamente por la base de
     * datos al momento de insertar una nueva fila en la tabla tarea.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtarea")
    private int id;
    /**
     *
     * Nombre del alumno a quien se le ha asignado la tarea.
     */
    @NotEmpty
    @Size(max = 45)
    @Column(name = "alumno")
    private String alumno;
    /**
     *
     * Fecha en la que se ha asignado la tarea.
     */
    @NotNull
    @Column(name = "fecha")
    private LocalDate fecha;
    /**
     *
     * Tipo de tarea asignada. Se utiliza una relación many-to-one para indicar
     * que muchos registros de la tabla tarea pueden estar asociados a un único
     * registro de la tabla tipo_tarea. La relación se establece mediante la
     * columna tipo_tarea_idtipo_tarea en la tabla tarea y la columna
     * idtipo_tarea en la tabla tipo_tarea.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_tarea_idtipo_tarea")
    private TipoTarea tipo;

    /**
     *
     * Constructor de la clase que recibe como parámetro el identificador único
     * de la tarea.
     * @param id
     */
    public Tarea(int id) {
        this.id = id;
    }

    /**
     *
     * Constructor por defecto de la clase.
     */
    public Tarea() {
    }
}
