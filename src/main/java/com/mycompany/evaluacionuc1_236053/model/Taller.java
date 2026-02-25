/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluacionuc1_236053.model;

import java.util.Date;

/**
 *
 * @author Chino
 */
public class Taller {
    private String id;
    private String nombreCompleto;
    private String instructor;
    private Date fecha;
    private String horario;
    private int cupoMax;
    private int cupoActual;

    public Taller() {}

    public Taller(String id, String nombreCompleto, String instructor, Date fecha,
                  String horario, int cupoMax, int cupoActual) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.instructor = instructor;
        this.fecha = fecha;
        this.horario = horario;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
    }

    public boolean tieneCupo() {
        return cupoActual < cupoMax;
        
    }
      public void incrementarCupo() {
        if (!tieneCupo()) {
            throw new IllegalStateException("No hay cupo disponible para este taller.");
        }
        cupoActual++;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public int getCupoMax() { return cupoMax; }
    public void setCupoMax(int cupoMax) { this.cupoMax = cupoMax; }

    public int getCupoActual() { return cupoActual; }
    public void setCupoActual(int cupoActual) { this.cupoActual = cupoActual; }

    @Override
    public String toString() {
        return nombreCompleto + " [" + cupoActual + "/" + cupoMax + "]";
    }
}
