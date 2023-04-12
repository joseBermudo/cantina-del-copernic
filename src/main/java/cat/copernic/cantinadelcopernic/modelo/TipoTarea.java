/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * La clase TipoTarea representa un tipo de tarea que puede ser asignado a un
 * alumno. La clase está anotada
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
@Table(name = "tipo_tarea")
public class TipoTarea {

    /**
     *
     * Identificador único del tipo de tarea. Se genera automáticamente por la
     * base de datos al momento de insertar una nueva fila en la tabla
     * tipo_tarea.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo_tarea")
    public int id;
    /**
     *
     * Nombre del tipo de tarea.
     */
    @NotEmpty
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;

    /**
     *
     * Constructor de la clase que recibe como parámetro el identificador único
     * del tipo de tarea.
     * @param id
     */
    public TipoTarea(int id) {
        this.id = id;
    }

    /**
     *
     * Constructor por defecto de la clase.
     */
    public TipoTarea() {
    }
}
