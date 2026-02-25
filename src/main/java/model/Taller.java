/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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

    public Taller(String id, String nombreCompleto, String instructor, Date fecha, String horario, int cupoMax, int cupoActual) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.instructor = instructor;
        this.fecha = fecha;
        this.horario = horario;
        this.cupoMax = cupoMax;
        this.cupoActual = cupoActual;
    }

    public String getId() { return id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getInstructor() { return instructor; }
    public Date getFecha() { return fecha; }
    public String getHorario() { return horario; }
    public int getCupoMax() { return cupoMax; }
    public int getCupoActual() { return cupoActual; }

    public boolean tieneCupo() {
        return cupoActual < cupoMax;
    }

    public void ocuparLugar() {
        if (!tieneCupo()) throw new IllegalStateException("Taller sin cupo");
        cupoActual++;
    }

    @Override
    public String toString() {
        return id + " - " + nombreCompleto;
    }
}