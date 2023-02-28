/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import lombok.Data;

/**
 *
 * @author joseb
 */
@Data
public class HorarioTareas {
    /**
     * Un mapa que como clave tiene el nombre del alumno
     * Como valor una lista de tareas.
     * Cada tarea contiene una fecha y el nombre de la tearea
     * El mapa evita que se puedan repetir los nombres de los alumnos
     * A traves de la clave (nombre alumno) podemos obtener su lista de tareas.
     */
    private HashMap<String,ArrayList<Tarea>> horario;
}
