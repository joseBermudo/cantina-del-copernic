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

        int[][] calendario = new int[6][7];
        int mesActual = LocalDate.now().getMonthValue();
        List<Tarea> tareas = tareaDAO.findTareasDelMesActual(mesActual);

        LocalDate fecha = LocalDate.now().withDayOfMonth(1);
        int diasEnMes = fecha.lengthOfMonth();
        ArrayList<ArrayList<Tarea>> tablaTareas = new ArrayList<>(diasEnMes);

        for (int i = 0; i < diasEnMes; i++) {
            tablaTareas.add(new ArrayList<>());
        }
        for (Tarea j : tareas) {
            int diaDeLaTarea = j.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfMonth();
            tablaTareas.get(diaDeLaTarea - 1).add(j);
        }
        DayOfWeek diaInicio = fecha.getDayOfWeek();
        int desplazamiento = diaInicio.getValue() - DayOfWeek.MONDAY.getValue();
        fecha = fecha.minusDays(desplazamiento);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (fecha.getMonthValue() == LocalDate.now().getMonthValue()) {
                    calendario[i][j] = fecha.getDayOfMonth();
                } else {
                    calendario[i][j] = 0;
                }
                fecha = fecha.plusDays(1);
            }
        }
        model.addAttribute("calendario",calendario);
        model.addAttribute("tablaTareas",tablaTareas);
        
        return "/paginasTareas/horarioTareas";

    }
}
