package cat.copernic.cantinadelcopernic.utilities;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


/*Classe de configuració de Spring Security per configurar l'accés d'usuaris (autenticació).
 *Aquesta classe ha d'extendre de la classe WebSecurityConfigurerAdapter de Spring Security per poder
 *autenticar els usuaaris.
 */

/**
 *
 * @author joseb
 */

@Configuration //Indica al sistema que és una classe de configuració
@EnableWebSecurity //Habilita la seguretat web
public class ConfiguracioAutenticacio {

    @Autowired
    private UserDetailsService userDetailsService; //Objecte per recuperar l'usuari

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void autenticacio(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Bean //L'indica al sistema que el mètode és un Bean, en aquest cas perquè crea un objecte de la classe HttpSecurity
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        return http.authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/listaBocadilloSemana").hasAnyAuthority("admin", "alumno")
//                .requestMatchers("/pedidosCliente").hasAnyAuthority("profesor").anyRequest().authenticated()
//        )
//                .formLogin((form) -> form
//                .loginPage("/login")
//                .defaultSuccessUrl("/listaBocadilloSemana", true)
//                .permitAll()
//                )
//                .exceptionHandling((exception) -> exception
//                .accessDeniedPage("/errors/error403"))
//                .build();
////, "admin",alumno", "profesor"
//    }

    /**
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Autorización de las solicitudes entrantes
        return http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/imagenes/**").permitAll()
                .requestMatchers("/listaBocadilloSemana","/crearFormularioBocadilloSemana","/listaBocadilloSemana","/verPedidoAdministrador/**","/pedidosAdministrador","/listarProfesores","/listarDeudasAdministrador","/horarioTareas","/listarTareas").hasAnyAuthority("admin", "alumno")
                .requestMatchers("/pedidosCliente").hasAnyAuthority("profesor")
                .anyRequest().authenticated()
        )
                // Configuración del formulario de inicio de sesión
                .formLogin((form) -> form
                .loginPage("/login")
                .successHandler(new CustomAuthenticationSuccessHandler())
                .permitAll()
                )
                // Configuración del manejo de excepciones
                .exceptionHandling((exception) -> exception
                .accessDeniedPage("/errors/error403"))
                .build();
    }

    /**
     *
     */
    public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        /**
         *
         * @param request
         * @param response
         * @param authentication
         * @throws IOException
         * @throws ServletException
         */
        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) throws IOException, ServletException {

            // Obtener los roles del usuario autenticado
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

            // Redirigir al usuario a la página correspondiente según su rol
            if (roles.contains("admin") || roles.contains("alumno")) {
                getRedirectStrategy().sendRedirect(request, response, "/pedidosAdministrador");
            } else if (roles.contains("profesor")) {
                getRedirectStrategy().sendRedirect(request, response, "/pedidosCliente");
            } else {
                // Usar el comportamiento predeterminado si no se cumple ninguna condición anterior
                super.onAuthenticationSuccess(request, response, authentication);
            }
        }
    }
}
