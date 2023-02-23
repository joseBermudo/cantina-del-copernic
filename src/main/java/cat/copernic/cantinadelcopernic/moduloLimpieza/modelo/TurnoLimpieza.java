/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloLimpieza.modelo;

import cat.copernic.cantinadelcopernic.moduloRRHH.modelo.Alumno;
import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author Enric
 */
@Data
public class TurnoLimpieza {
    private int idTurno;
    private Alumno alumno;
    private Timestamp horario;
}