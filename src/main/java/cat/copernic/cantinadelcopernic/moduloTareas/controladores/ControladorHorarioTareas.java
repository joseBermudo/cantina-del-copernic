/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloTareas.controladores;

import cat.copernic.cantinadelcopernic.DAO.TareaDAO;
import cat.copernic.cantinadelcopernic.modelo.Tarea;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorHorarioTareas {

    @Autowired
    TareaDAO tareaDAO;

    @GetMapping("/horarioTareas")
    public String inici(Model model) {
        model.addAttribute("crearTurnoLimpiezaWord", "Crear torn de neteja");
        model.addAttribute("lunesWord", "Dilluns");
        model.addAttribute("martesWord", "Dimarts");
        model.addAttribute("miercolesWord", "Dimecres");
        model.addAttribute("juevesWord", "Dijous");
        model.addAttribute("viernesWord", "Divendres");
        model.addAttribute("sabadoWord", "Dissabte");
        model.addAttribute("domingoWord", "Diumenge");
        model.addAttribute("horarioWord", "Horari");

        model.addAttribute("listaTareasWord", "Llista de tasques");
        model.addAttribute("crearTareaWord", "Crear tasca");

        Date hoy = new Date();
        Calendar hor = Calendar.getInstance();
        hor.setTime(hoy);
        int mesActual = hor.get(Calendar.MONTH);
        int anioActual = hor.get(Calendar.YEAR);

        // Obtener el número de días del mes actual
        int diasEnMes = hor.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Obtener el primer día de la semana
        int primerDiaSemana = hor.get(Calendar.DAY_OF_WEEK);
        if (primerDiaSemana == Calendar.SUNDAY) {
            // El primer día de la semana es domingo, así que ajustamos para que sea lunes
            primerDiaSemana = Calendar.MONDAY;
        } else {
            // Restamos 1 para que el primer día de la semana sea 0 (lunes) en vez de 1 (martes) y así sucesivamente
            primerDiaSemana--;
        }

        // Generar los datos para la tabla del horario
        String[][] tablaHorario = new String[6][7];
        int dia = hor.get(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j + 1 < primerDiaSemana) {
                    // Espacio en blanco para los días previos al primer día del mes
                    tablaHorario[i][j] = "";
                } else if (dia > diasEnMes) {
                    // Espacio en blanco para los días posteriores al último día del mes
                    tablaHorario[i][j] = "";
                } else {
                    // Celda con el día actual
                    tablaHorario[i][j] = Integer.toString(dia);
                    List<Tarea> tareas = (List<Tarea>) tareaDAO.findAll();
                    for (Tarea tarea : tareas) {
                        if (tarea.getFecha().getDate() == dia) {
                            tablaHorario[i][j] += " " + tarea.getAlumno();
                        }
                    }


                    if (dia == hor.get(Calendar.DAY_OF_MONTH) && mesActual == hor.get(Calendar.MONTH)
                            && anioActual == hor.get(Calendar.YEAR)) {
                        // Si es el día actual, añadir la clase "today"
                        tablaHorario[i][j] += " avui";
                    }
                    dia++;
                }
            }

        }
        model.addAttribute("tablaHorario",tablaHorario);
        return "/paginasTareas/horarioTareas";

    }
}
