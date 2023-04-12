/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.DAO.TareaDAO;
import cat.copernic.cantinadelcopernic.modelo.Tarea;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Controlador encargado de manejar la vista de horario de tareas.
 *
 * Utiliza la anotación @Controller de Spring para indicar que es un componente
 * encargado
 *
 * de manejar las solicitudes HTTP relacionadas con el horario de tareas.
 *
 * El controlador utiliza la clase TareaDAO y la anotación @Autowired para
 * inyectar la
 *
 * dependencia de dicha clase y poder acceder a los datos de las tareas.
 *
 * La solicitud GET a "/horarioTareas" devuelve una vista que muestra un
 * calendario
 *
 * con las tareas del mes actual. El controlador utiliza un arreglo
 * bidimensional de
 *
 * ArrayLists para representar el calendario, y lo inicializa en el constructor.
 * Luego
 *
 * utiliza la clase LocalDate de Java para obtener la fecha actual y el mes
 * actual, y
 *
 * la clase TareaDAO para obtener las tareas del mes actual. A continuación,
 * itera sobre
 *
 * el calendario y las tareas, y agrega las tareas correspondientes a las fechas
 *
 * adecuadas del calendario.
 *
 * La vista se retorna como un String que indica el nombre de la plantilla HTML
 * que se
 *
 * va a utilizar para renderizar la vista. El modelo de la vista incluye el
 * calendario
 *
 * con las tareas.
 *
 * @author Enric
 */
@Controller
public class ControladorHorarioTareas {

    @Autowired
    TareaDAO tareaDAO;

    /**
     *
     * Maneja la solicitud GET a "/horarioTareas" y devuelve la vista
     * correspondiente
     *
     * que muestra un calendario con las tareas del mes actual.
     *
     * @param model El modelo de la vista, que incluye el calendario con las
     * tareas.
     *
     * @return El nombre de la plantilla HTML que se va a utilizar para
     * renderizar la vista.
     */
    @GetMapping("/horarioTareas")
    public String inici(Model model) {

// Inicializa el calendario con un arreglo bidimensional de ArrayLists.
        ArrayList<String>[][] calendario = new ArrayList[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                calendario[i][j] = new ArrayList<String>();
            }
        }

// Obtiene la fecha actual y el mes actual.
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anyoActual = fechaActual.getYear();

// Obtiene las tareas del mes actual utilizando la clase TareaDAO.
        List<Tarea> tareas = tareaDAO.findTareasDelMesActual(mesActual, anyoActual);

// Configura la fecha para empezar a llenar el calendario.
        LocalDate fecha = LocalDate.now().withDayOfMonth(1);
        DayOfWeek diaInicio = fecha.getDayOfWeek();
        int desplazamiento = diaInicio.getValue() - DayOfWeek.MONDAY.getValue();
        fecha = fecha.minusDays(desplazamiento);

// Llena el calendario con las fechas del mes actual.
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (fecha.getMonthValue() == LocalDate.now().getMonthValue()) {
                    String diaConCeros = String.format("%02d", fecha.getDayOfMonth());
                    String mesConCeros = String.format("%02d", fecha.getMonthValue());
                    String fechaString = diaConCeros + "-" + mesConCeros + "-" + fecha.getYear();
                    calendario[i][j].add(fechaString);

                } else {
                    calendario[i][j].add("0");
                }
                fecha = fecha.plusDays(1);
            }
        }

        for (Tarea tarea : tareas) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    if (!calendario[i][j].get(0).equals("0")) {

                        String diaDeLaFechaQueNosPasan = calendario[i][j].get(0).substring(0, 2);
                        if (diaDeLaFechaQueNosPasan.substring(0, 1).equals("0")) {
                            diaDeLaFechaQueNosPasan = diaDeLaFechaQueNosPasan.substring(1);
                        }
                        if (Integer.parseInt(diaDeLaFechaQueNosPasan) == tarea.getFecha().getDayOfMonth()) {
                            calendario[i][j].add(tarea.getAlumno());
                        }
                    }
                }
            }
        }
        model.addAttribute("calendario", calendario);

        return "/paginasTareas/horarioTareas";

    }
}
