/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.*;
import model.Taller;

/**
 *
 * @author Chino
 */
public class TallerRepository {
    private final List<Taller> talleres = new ArrayList<>();

    public TallerRepository() {
        Calendar c = Calendar.getInstance();
        c.set(2026, Calendar.MARCH, 10, 10, 0);
        talleres.add(new Taller("T01", "Java Swing MVC", "Ing. Romero", c.getTime(), "10:00-12:00", 30, 10));

        c.set(2026, Calendar.MARCH, 11, 12, 0);
        talleres.add(new Taller("T02", "UML y Robustez", "Mtra. Salas", c.getTime(), "12:00-14:00", 25, 25)); // lleno

        c.set(2026, Calendar.MARCH, 12, 9, 0);
        talleres.add(new Taller("T03", "GitHub y Entregables", "Ing. Torres", c.getTime(), "09:00-11:00", 20, 5));
    }

    public List<Taller> listarDisponibles() {
        return new ArrayList<>(talleres);
    }

    public Taller obtenerPorId(String idTaller) {
        for (Taller t : talleres) {
            if (t.getId().equals(idTaller)) return t;
        }
        return null;
    }
}
