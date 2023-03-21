/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id_pedido")
    private List<Pedido> pedido;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sugerencia> sugerencias;

    @OneToMany(mappedBy="profesor",cascade = CascadeType.ALL)
    private List<ProfesorPromocion> profesorPromocion;
}
