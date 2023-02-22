/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloVentas.modelo;
import lombok.Data;

/**
 *
 * @author marku
 */
@Data
public class Pedido {
    private BocadilloSemana bocadilloSemana;
    private Bebida bebida;
    private String correo;
}
