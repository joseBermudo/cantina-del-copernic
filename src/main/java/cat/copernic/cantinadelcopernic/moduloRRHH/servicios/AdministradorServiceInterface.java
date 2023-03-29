/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;

import cat.copernic.cantinadelcopernic.modelo.Administrador;
import java.util.List;



/**
 *
 * @author andre
 */
public interface AdministradorServiceInterface {
    
     public Administrador buscarAdministrador(Administrador administrador);
     public List<Administrador> listarAdministradores();
     public void anadirAdministrador(Administrador administrador); 
     public void eliminarAlumno(Administrador administrador);
}
