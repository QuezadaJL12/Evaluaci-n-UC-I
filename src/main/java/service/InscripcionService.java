/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import java.util.*;
import model.*;
import observer.*;
/**
 *
 * @author Chino
 */
public class InscripcionService implements IInscripcionSubject {
    private final List<IInscripcionObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IInscripcionObserver obs) { observers.add(obs); }

    @Override
    public void removeObserver(IInscripcionObserver obs) { observers.remove(obs); }

    private void notifyObservers(Ticket ticket) {
        for (IInscripcionObserver obs : observers) obs.update(ticket);
    }

    public Ticket registrarInscripcion(Alumno alumno, Taller taller) {
        if (alumno == null) throw new IllegalArgumentException("Alumno no encontrado");
        if (taller == null) throw new IllegalArgumentException("Taller no encontrado");
        if (!taller.tieneCupo()) throw new IllegalStateException("Taller sin cupo");

        // registra inscripción
        String idIns = "INS-" + System.currentTimeMillis();
        Inscripcion ins = new Inscripcion(idIns, new Date(), alumno, taller);

        // ocupa cupo y genera ticket
        taller.ocuparLugar();
        Ticket ticket = new Ticket(ins);

        notifyObservers(ticket);
        return ticket;
    }
}
