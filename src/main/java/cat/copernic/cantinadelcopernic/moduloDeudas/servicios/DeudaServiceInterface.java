/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.servicios;
import cat.copernic.cantinadelcopernic.modelo.Deuda;
import java.util.List;

/**
 *
 * @author Enric
 */
public interface DeudaServiceInterface {
    
    public List<Deuda> listarDeudas();
    
    public void anadirDeuda(Deuda deuda);
    
    public void eliminarDeuda(Deuda deuda);
    
    public Deuda buscarDeuda(Deuda deuda); 
}
