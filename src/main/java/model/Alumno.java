/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Chino
 */
public class Alumno {
    private String id;
    private String nombre;
    private int semestre;
    private String programa;

    public Alumno(String id, String nombre, int semestre, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.programa = programa;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getSemestre() { return semestre; }
    public String getPrograma() { return programa; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}