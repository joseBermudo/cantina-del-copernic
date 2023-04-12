/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cat.copernic.cantinadelcopernic.DAO;

import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocion;
import cat.copernic.cantinadelcopernic.modelo.ProfesorPromocionId;
import cat.copernic.cantinadelcopernic.modelo.Promocion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz que aplica el repositorio Jpa de la entidad ProfesorPromocion.
 * @author joseb
 */
public interface ProfesorPromocionDAO extends JpaRepository<ProfesorPromocion,ProfesorPromocionId>{
    /**
     * 
     * @param usuarios_correo correo electronico del usuario.
     * @return  Devuelve una lista de ProfesorPromocion que este relacionados con el usuario espeficado.
     */
    @Query("SELECT pf FROM ProfesorPromocion pf WHERE pf.profesor.correo =:usuarios_correo")
    List<ProfesorPromocion> findByCorreo(@Param("usuarios_correo") String usuarios_correo);
}
