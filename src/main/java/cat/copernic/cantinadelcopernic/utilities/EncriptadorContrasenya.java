package cat.copernic.cantinadelcopernic.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author joseb
 */
public class EncriptadorContrasenya {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        var password = "123";
        System.out.println("Contrasenya: " + password);
        System.out.println("Contrasenya encriptada:" + encriptarContrasenya(password));
    }

    /**
     *
     * @param password
     * @return
     */
    public static String encriptarContrasenya(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
