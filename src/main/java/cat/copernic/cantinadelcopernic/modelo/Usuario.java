/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import cat.copernic.cantinadelcopernic.moduloRRHH.controladores.CorreoValidationGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.Data;


/**
 *
 * @author andre
 */
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotEmpty
    @Email
    private String correo;
    
    @NotEmpty
    @Size(max = 50)
    private String nombre;
    
    @NotEmpty
    @Size(max = 75)
    private String apellidos;
    
}
