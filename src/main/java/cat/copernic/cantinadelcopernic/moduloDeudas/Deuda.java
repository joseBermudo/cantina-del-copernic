/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Enric
 */
@Data
public class Deuda {
    private float cantidad;
    private String correo; //El id del usuario
    private Date fechaDeLaDeuda;
    private boolean pagado;
}
