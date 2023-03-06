/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author andre
 */
@Data
@Entity
public class Profesor extends Usuario {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "into_lactosa")
    private Boolean intoleranciaLactosa;
    
    @Column(name = "into_hismatico")
    private Boolean intoleranciaHismatico;
    
    @Column(name = "into_fodmaps")
    private Boolean intoleranciaFodmaps;
    
    @Column(name = "into_gluten")
    private Boolean intoleranciaGluten;
    
    @Column(name = "obs")
    private String observaciones;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "correo") 
    private List<Sugerencia> sugerencias = new ArrayList<>();
}
