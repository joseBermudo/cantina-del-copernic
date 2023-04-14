/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

/**
 *
 * @author marku
 */
/**
 *
 * La clase BocadilloSemana representa un bocadillo que se ofrecerá como
 * "bocadillo de la semana" en el menú. Esta clase está mapeada a la tabla
 * "bocadillo_semana" en la base de datos.
 */
@Data
@Entity
@Table(name = "bocadillo_semana")
public class BocadilloSemana implements Serializable {

    /**
     * El identificador único del bocadillo de la semana.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbocadillo_semana;

    /**
     * El precio del bocadillo de la semana.
     */
    @NotNull
    private double precio;

    /**
     * La ruta de la imagen del bocadillo de la semana.
     */
    private String imagen;

    /**
     * La fecha en que se ofrecerá el bocadillo de la semana. Debe ser igual o
     * posterior a la fecha actual.
     */
    @FutureOrPresent
    private LocalDate fecha;

    /**
     * El nombre del bocadillo de la semana. No puede estar vacío y debe tener
     * una longitud máxima de 45 caracteres.
     */
    @NotEmpty
    @Size(max = 45)
    private String nombre;

    /**
     * La descripción del bocadillo de la semana. No puede estar vacía y debe
     * tener una longitud máxima de 500 caracteres.
     */
    @NotEmpty
    @Size(max = 500)
    private String descripcion;

    /**
     * La receta del bocadillo de la semana. Cada bocadillo de la semana tiene
     * una única receta asociada.
     */
    @ManyToOne()
    @JoinColumn(name = "receta_idreceta")
    private Receta receta;

    /**
     * La lista de pedidos realizados del bocadillo de la semana. Cada bocadillo
     * de la semana puede tener múltiples pedidos asociados. Los pedidos
     * asociados se eliminarán en cascada al eliminar el bocadillo de la semana.
     */
    @OneToMany(mappedBy = "bocadilloSemana", cascade = CascadeType.REMOVE)
    private List<Pedido> pedido;
}
