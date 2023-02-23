/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author joseb
 */
@Data
public class Receta {
    private String nombre;
    private String descripcion;
    private ArrayList<String> lista_ingredientes;
}


