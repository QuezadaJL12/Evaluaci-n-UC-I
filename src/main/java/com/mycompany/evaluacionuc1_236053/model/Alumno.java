/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.evaluacionuc1_236053.model;

/**
 *
 * @author Chino
 */
public class Alumno {
    private String id;
    private String nombre;
    private int semestre;
    private String carrera;

    public Alumno() {}

    public Alumno(String id, String nombre, int semestre, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}