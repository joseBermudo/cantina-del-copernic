/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.servicios;

import cat.copernic.cantinadelcopernic.DAO.DeudaDAO;
import cat.copernic.cantinadelcopernic.DAO.ProfesorDAO;
import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Clase DeudaService que implementa la interfaz DeudaServiceInterface.
 *
 * Esta clase se encarga de proporcionar los servicios relacionados con la
 * entidad Deuda,
 *
 * haciendo uso de los objetos DeudaDAO y ProfesorDAO para interactuar con la
 * base de datos.
 *
 * La anotación @Service indica que esta clase es un componente de servicio de
 * Spring.
 *
 * @author Enric
 */
@Service
public class DeudaService implements DeudaServiceInterface {

    @Autowired
    private DeudaDAO deudaDAO; // Objeto DAO para interactuar con la tabla Deuda en la base de datos.

    @Autowired
    private ProfesorDAO profesorDAO; // Objeto DAO para interactuar con la tabla Profesor en la base de datos.

    /**
     *
     * Método que permite listar todas las Deudas en la base de datos.
     *
     * @return una lista de objetos Deuda.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Deuda> listarDeudas() {
        return (List<Deuda>) deudaDAO.findAll();
    }

    /**
     *
     * Método que permite listar las Deudas de un Profesor específico.
     *
     * @param correoProfesor el correo electrónico del Profesor a buscar.
     *
     * @return una lista de objetos Deuda que pertenecen al Profesor con el
     * correo especificado.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Deuda> listarDeudasDeUnProfesor(String correoProfesor) {
        List<Deuda> deudasTotales = deudaDAO.findAll();
        List<Deuda> deudasProfesor = new ArrayList<>();
        for (int i = 0; i < deudasTotales.size(); i++) {
            if (deudasTotales.get(i).getProfesor().getCorreo().equals(correoProfesor)) {
                deudasProfesor.add(deudasTotales.get(i));
            }
        }

        return deudasProfesor;
    }

    /**
     *
     * Método que permite añadir una nueva Deuda a la base de datos.
     *
     * @param deuda el objeto Deuda a añadir.
     */
    @Override
    @Transactional
    public void anadirDeuda(Deuda deuda) {
        this.deudaDAO.save(deuda);
    }

    /**
     *
     * Método que permite eliminar una Deuda de la base de datos.
     *
     * @param deuda el objeto Deuda a eliminar.
     */
    @Override
    @Transactional
    public void eliminarDeuda(Deuda deuda) {
        this.deudaDAO.delete(deuda);
    }

    /**
     *
     * Método que permite buscar una Deuda en la base de datos por su
     * identificador único.
     *
     * @param deuda el objeto Deuda con el identificador a buscar.
     * @return el objeto Deuda encontrado o null si no se encuentra en la base
     * de datos.
     */
    @Override
    @Transactional(readOnly = true)
    public Deuda buscarDeuda(Deuda deuda) {
        return this.deudaDAO.findById(deuda.getIdDeuda()).orElse(null);
    }

    /**
     *
     * Método que permite buscar una Deuda en la base de datos por su
     * identificador único.
     *
     * @param idDeuda el identificador de la Deuda a buscar.
     * @return el objeto Deuda encontrado o null si no se encuentra en la base
     * de datos.
     */
    @Override
    public Deuda buscarDeudaPorId(int idDeuda) {
        return deudaDAO.findById(idDeuda).orElse(null);
    }
    
    /**
     *
     * Método que permite buscar un Profesor en la base de datos por su
     * identificador único.
     *
     * @param profesor el identificador del Professor a buscar.
     * @return el objeto Professor encontrado o null si no se encuentra en la base
     * de datos.
     */
    @Override
    @Transactional(readOnly = true)
    public Profesor buscarProfesor(Profesor profesor) {
        return profesorDAO.findById(profesor.getCorreo()).orElse(null);
    }
}
