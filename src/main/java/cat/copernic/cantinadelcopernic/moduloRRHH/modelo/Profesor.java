/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.modelo;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author andre
 */
@Data
public class Profesor extends Usuario{
    
    private ArrayList<Boolean> intolerancias;
    
    private String observaciones;
}
