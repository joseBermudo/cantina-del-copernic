/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import lombok.Data;

/**
 *
 * @author andre
 */
@Data
public class Modulo {
    
    private String nombreModulo;
    private boolean visibleCliente;
    private boolean visibleAlumno;
    private boolean habilitado;
}
