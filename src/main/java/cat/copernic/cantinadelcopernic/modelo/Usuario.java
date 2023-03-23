/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import cat.copernic.cantinadelcopernic.moduloRRHH.controladores.CorreoValidationGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import javax.swing.text.PasswordView;
import lombok.Data;


/**
 *
 * @author andre
 */
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

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
    
   

    private String username;
    
    private String password;

    @ManyToOne //Indica al sistema que la relació entre les taules usuari i rol en aquest cas és d'un a molts.
    @JoinColumn(name = "roles_idroles") //Columna de la base de dades que farà de clau forana relacionant les dues taules.
    private Rol rols;
}
