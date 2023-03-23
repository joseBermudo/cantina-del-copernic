package cat.copernic.cantinadelcopernic.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptadorContrasenya {

    public static void main(String[] args) {

        var password = "123";
        System.out.println("Contrasenya: " + password);
        System.out.println("Contrasenya encriptada:" + encriptarContrasenya(password));
    }

    public static String encriptarContrasenya(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
