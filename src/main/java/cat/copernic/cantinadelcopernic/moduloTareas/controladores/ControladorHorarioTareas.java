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
        
        ArrayList<String>[][] calendario = new ArrayList[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                calendario[i][j] = new ArrayList<String>();
            }
        }

        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anyoActual = fechaActual.getYear();
        List<Tarea> tareas = tareaDAO.findTareasDelMesActual(mesActual, anyoActual);


        LocalDate fecha = LocalDate.now().withDayOfMonth(1);
        
        
        DayOfWeek diaInicio = fecha.getDayOfWeek();
        int desplazamiento = diaInicio.getValue() - DayOfWeek.MONDAY.getValue();
        fecha = fecha.minusDays(desplazamiento);

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
                    if(!calendario[i][j].get(0).equals("0")){
                       
                        String diaDeLaFechaQueNosPasan = calendario[i][j].get(0).substring(0,2);
                        if(diaDeLaFechaQueNosPasan.substring(0,1).equals("0")){
                            diaDeLaFechaQueNosPasan = diaDeLaFechaQueNosPasan.substring(1);
                        }
                        if(Integer.parseInt(diaDeLaFechaQueNosPasan) == tarea.getFecha().getDayOfMonth())
                        {
                            calendario[i][j].add(tarea.getAlumno());
                        }
                    }
                }
            }
        }
        model.addAttribute("calendario",calendario);
        
        return "/paginasTareas/horarioTareas";

    }
}
