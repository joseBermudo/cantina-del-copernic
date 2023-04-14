/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author marku
 */
/**
 *
 * La clase Pedido representa un pedido realizado por un profesor en el sistema.
 *
 * Esta clase está mapeada a la tabla "pedido" en la base de datos.
 */
@Data
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     * El identificador único del pedido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    /**
     *
     * La bebida solicitada en el pedido. Cada pedido debe tener una bebida
     * asociada.
     */
    @ManyToOne()
    @JoinColumn(name = "bebida_idbebida")
    @NotNull
    private Bebida bebida;
    /**
     *
     * El bocadillo de la semana solicitado en el pedido. Cada pedido debe tener
     * un bocadillo de la semana asociado.
     */
    @ManyToOne()
    @JoinColumn(name = "bocadillo_semana_idbocadillo_semana")
    @NotNull
    private BocadilloSemana bocadilloSemana;
    /**
     *
     * El profesor que realizó el pedido. Cada pedido debe tener un profesor
     * asociado.
     */
    @ManyToOne()
    @JoinColumn(name = "usuarios_correo")
    @NotNull
    private Profesor profesores;
}
