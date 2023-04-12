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
 * Interfaz que define los metodos del Servicio de Promocion.
 * @author joseb
 */
public interface PromocionServiceInterface {
    
    /**
     * Lista promociones
     * @return Todas las promociones de la base de datos.
     */
    public List<Promocion> obtenerPromociones();
    
    /**
     * Persites una lista de entidades ProfesorPromocion en base de datos.
     * @param list Lista de ProfesorPromocion
     */
    public void gurdarProfesorPromocion(List<ProfesorPromocion> list);
    
    /**
     * Persiste una promocion en la base de datos.
     * @param promocion Promocion que guarda.
     */
    public void guardarPromocion(Promocion promocion);
    
    /**
     * Lee una promocion de la base de datos.
     * @param promocion Promocion que deaseamos leer.
     * @return Promocion obtenida.
     */
    public Promocion buscarPromocion(Promocion promocion);

    /**
     * Lista todos los profesores.
     * @return Lista de todos los profesoresd de la base de datos.
     */
    public List<Profesor> obetnerClientes();
    
    /**
     * Lee la ultima promocion insertada en la base de datos.
     * @return La ultima promocion.
     */
    public Promocion obetnerUltimaPromocion();
    
    /**
     * Elimina una relacion especifica entre una Promocion y Profesor.
     * @param profesorPromocion Relacion a eliminar.
     */
    public void utilizarPromocion(ProfesorPromocion profesorPromocion);
    
    /**
     * Lee una relacion especifica entre Promocion y Pofesor.
     * @param profesorPromocion La relacion que deseamos leer.
     * @return Relacion obtenida.
     */
    public ProfesorPromocion buscarPromocionProfesor(ProfesorPromocion profesorPromocion);
    
    /**
     * Elimina un promocion de la base de datos.
     * @param promocion Promocion a eliminar.
     */
    public void eliminarPromocion(Promocion promocion);
    
    /**
     * Lee un profesor de la base de datos.
     * @param profesor Profesor que deseamos leer.
     * @return  Profesor obtenido.
     */
    public Profesor buscarProfesor(Profesor profesor);
    
    /**
     * Lista todos los registros que relacionan las promociones con un usuario
     * especifico.
     * @param correo Correo electronico del usuario.
     * @return Lista de ProfesorPromocion.
     */
    public List<ProfesorPromocion> obtenerPromocionesUsuario(String correo);
}
