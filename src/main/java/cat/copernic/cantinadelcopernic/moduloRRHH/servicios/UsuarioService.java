/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloRRHH.servicios;


import cat.copernic.cantinadelcopernic.DAO.UsuarioDAO;
import cat.copernic.cantinadelcopernic.modelo.Rol;
import cat.copernic.cantinadelcopernic.modelo.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author andre
 */
@Service
public class UsuarioService implements UsuarioServiceInterface, UserDetailsService {
    
    //, UserDetailsService
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    @Transactional(readOnly=true) 
    public Usuario buscarProfesores(Usuario usuario) {
        
         return this.usuarioDAO.findById(usuario.getCorreo()).orElse(null);
   }
    
    @Override
    @Transactional(readOnly=true) //Consulta només de lectura
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        /*Implementem el mètode definit en UsuariDao. Hem de pensar que aquest és un mètode predefinit
         *de Spring Security i, per tant, no hem de desnvolupar cap codi, ja ve donat per Spring Security.
         *Aquest mètode ens retornarà l'usuari a partir de nom d'usuari passat per paràmetre.
        */
        Usuario usuari= usuarioDAO.findByUsername(username);
        
        //Comprovem que existeix l'usuari
        if(usuari==null){ //Si no existeix l'usuari...
            
            //Llancem una excepció de tipus UsernameNotFoundException             
            throw new UsernameNotFoundException(username);           
        }
        /*Si l'usuari existeix, recuperarem els rols associats a aquest usuari.
         *Els rols els guardarem dins un ArrayList de tipus genèric GrantedAuthority,
         *tipus genèric de Spring Security necessari perque Spring Security pugui
         *treballar amb els rols.
         *GrantedAuthority, és una interface.
        */
        var rols= new ArrayList<GrantedAuthority>();
        
        /*Fem un recorregut pels rols de l'usuari actual guardats en l'atribut rols de la classe Usuari
         *per guardar-los com objectes de tipus GrantedAuthority en la variable rols.
         *Per convertir un rol en un objecte de tipus GrantedAuthority, instanciem un objecte de la 
         *classe SimpleGrantedAuthority la qual implementa GrantedAuthority, passant-li com a paràmetre 
         *el nom del rol.
        */
        
        rols.add(new SimpleGrantedAuthority(usuari.getRols().getNombre()));
        

        /*Retornme el nou usuari de tipus UserDetails mitjançant la classe User d'Spring Security,
         *la qual implementa la interface UserDetails.
         *Com a paràmetres passem el nom d'usuari, la contrasenya i els rols del l'usuari alqual
         *li correspon el nom d'usuari passat com a paràmetre.
        */
        return new User(usuari.getUsername(), usuari.getPassword(), rols);
    }
    
}
