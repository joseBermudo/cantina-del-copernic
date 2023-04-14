/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 *
 * @author marku
 */

/**
 *
 * La clase Contenedor representa un contenedor en el que se almacenan
 * utensilios.
 *
 * Esta clase está mapeada a la tabla "contenedor" en la base de datos.
 */
@Data
@Entity
@Table(name = "contenedor")
public class Contenedor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     * El identificador único del contenedor. No puede estar vacío y debe tener
     * una longitud máxima de 5 caracteres.
     */
    @Id
    @NotEmpty
    @Size(max = 5)
    private String idcontenedor;
    /**
     *
     * La lista de utensilios almacenados en el contenedor. Cada contenedor
     * puede tener múltiples utensilios asociados. Los utensilios asociados se
     * eliminarán en cascada al eliminar el contenedor.
     */
    @OneToMany(mappedBy = "contenedor", cascade = CascadeType.REMOVE)
    private List<Utensilio> utensilios = new ArrayList<>();
}
