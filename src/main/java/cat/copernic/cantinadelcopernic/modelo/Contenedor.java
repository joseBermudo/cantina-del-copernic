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
@Data
@Entity
@Table(name = "contenedor")
public class Contenedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty
    @Size(max = 5)
    private String idcontenedor;

    @OneToMany(mappedBy = "contenedor", cascade = CascadeType.REMOVE)
    private List<Utensilio> utensilios = new ArrayList<>();
}
