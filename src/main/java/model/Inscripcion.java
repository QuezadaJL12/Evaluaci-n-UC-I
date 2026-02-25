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
public class Inscripcion {
    private String id;
    private Date fechaRegistro;
    private Alumno alumno;
    private Taller taller;

    public Inscripcion(String id, Date fechaRegistro, Alumno alumno, Taller taller) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.alumno = alumno;
        this.taller = taller;
    }

    public String getId() { return id; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public Alumno getAlumno() { return alumno; }
    public Taller getTaller() { return taller; }
}