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
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Enric
 */
@Data
public class Tarea {
    
    private int id;
    
    private String alumno;
    
    private Date fecha;
    
    private TipoTarea tipo;
}

/*
@Data
@Entity
@Table(name = "tarea")
public class Tarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtarea")
    private int id;
    
    @Column(name = "alumno")
    private String alumno;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "tipo_tarea_idtipo_tarea")
    private TipoTarea tipo;
}
*/
