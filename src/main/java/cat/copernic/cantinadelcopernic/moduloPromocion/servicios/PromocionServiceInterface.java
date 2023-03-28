/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloPromocion.servicios;

import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocion;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import java.util.List;

/**
 *
 * @author joseb
 */
public interface PromocionServiceInterface {

    public List<Promocion> obtenerPromociones();
    
    public void gurdarProfesorPromocion(List<ProfesorPromocion> list);
    
    public void guardarPromocion(Promocion promocion);

    public Promocion buscarPromocion(Promocion promocion);

    public List<Profesor> obetnerClientes();
    
    public Promocion obetnerUltimaPromocion();
    
    public void utilizarPromocion(ProfesorPromocion profesorPromocion);
    
    public ProfesorPromocion buscarPromocionProfesor(ProfesorPromocion profesorPromocion);
    
    public void eliminarPromocion(Promocion promocion);
    
    public Profesor buscarProfesor(Profesor profesor);
    
}
