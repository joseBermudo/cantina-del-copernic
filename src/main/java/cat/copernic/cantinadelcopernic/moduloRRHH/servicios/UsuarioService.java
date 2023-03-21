/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;


import cat.copernic.cantinadelcopernic.DAO.UsuarioDAO;
import cat.copernic.cantinadelcopernic.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author andre
 */
@Service
public class UsuarioService implements UsuarioServiceInterface {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    @Transactional(readOnly=true) 
    public Usuario buscarProfesores(Usuario usuario) {
        
         return this.usuarioDAO.findById(usuario.getCorreo()).orElse(null);
    }
    
}
