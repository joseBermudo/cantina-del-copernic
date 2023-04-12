/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.servicios;

import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.List;

/**
 *
 * Interfaz que define los métodos necesarios para el servicio de gestión de
 * deudas. Contiene métodos para listar, añadir, eliminar y buscar deudas, así
 * como buscar un profesor. También incluye un método para buscar una deuda en
 * particular por su identificador.
 */
public interface DeudaServiceInterface {

    /**
     * Método que devuelve una lista con todas las deudas registradas en el
     * sistema.
     *
     * @return lista de deudas registradas.
     */
    public List<Deuda> listarDeudas();

    /**
     * Método que devuelve una lista con todas las deudas de un profesor en
     * particular.
     *
     * @param correoProfesor correo electrónico del profesor del que se quieren
     * obtener las deudas.
     * @return lista de deudas del profesor correspondiente.
     */
    public List<Deuda> listarDeudasDeUnProfesor(String correoProfesor);

    /**
     * Método que añade una nueva deuda al sistema.
     *
     * @param deuda deuda que se quiere añadir al sistema.
     */
    public void anadirDeuda(Deuda deuda);

    /**
     * Método que elimina una deuda del sistema.
     *
     * @param deuda deuda que se quiere eliminar del sistema.
     */
    public void eliminarDeuda(Deuda deuda);

    /**
     * Método que busca una deuda en particular en el sistema.
     *
     * @param deuda deuda que se quiere buscar en el sistema.
     * @return la deuda correspondiente si se encuentra en el sistema, null en
     * caso contrario.
     */
    public Deuda buscarDeuda(Deuda deuda);

    /**
     * Método que busca un profesor en particular en el sistema.
     *
     * @param profesor profesor que se quiere buscar en el sistema.
     * @return el profesor correspondiente si se encuentra en el sistema, null
     * en caso contrario.
     */
    public Profesor buscarProfesor(Profesor profesor);

    /**
     * Método que busca una deuda en particular por su identificador.
     *
     * @param idDeuda identificador de la deuda que se quiere buscar en el
     * sistema.
     * @return la deuda correspondiente si se encuentra en el sistema, null en
     * caso contrario.
     */
    public Deuda buscarDeudaPorId(int idDeuda);

}
