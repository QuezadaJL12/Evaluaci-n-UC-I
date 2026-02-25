/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.*;
import observer.ObserverInscripcion;
import repository.*;
import service.InscripcionService;
import view.InscripcionView;

/**
 *
 * @author Chino
 */
public class InscripcionController {
    private final InscripcionView view;
    private final TallerRepository tallerRepo;
    private final AlumnoRepository alumnoRepo;
    private final InscripcionService service;

    private Taller tallerSeleccionado;
    private Alumno alumnoActual;

    public InscripcionController(InscripcionView view, TallerRepository tallerRepo, AlumnoRepository alumnoRepo, InscripcionService service) {
        this.view = view;
        this.tallerRepo = tallerRepo;
        this.alumnoRepo = alumnoRepo;
        this.service = service;

 
        this.service.addObserver(new ObserverInscripcion(view));
    }

    public void cargarTalleres() {
        List<Taller> talleres = tallerRepo.listarDisponibles();
        view.mostrarTalleres(talleres);
    }

    public void seleccionarTaller(String idTaller) {
        tallerSeleccionado = tallerRepo.obtenerPorId(idTaller);
        if (tallerSeleccionado == null) {
            view.mostrarMensaje("Taller no encontrado");
            return;
        }
        view.mostrarDetalles(tallerSeleccionado);
    }

    public void buscarAlumno(String idAlumno) {
        alumnoActual = alumnoRepo.buscarPorId(idAlumno);
        if (alumnoActual == null) {
            view.mostrarMensaje("Alumno no encontrado");
            return;
        }
        view.mostrarDatosAlumno(alumnoActual);
    }

    public void confirmarInscripcion() {
        try {
            service.registrarInscripcion(alumnoActual, tallerSeleccionado);
        } catch (Exception ex) {
            view.mostrarMensaje(ex.getMessage());
        }
    }
}
