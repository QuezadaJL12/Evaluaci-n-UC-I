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
public class Inscripcion {
    private String id;
    private Date fechaRegistro;

    public Inscripcion() {}

    public Inscripcion(String id, Date fechaRegistro) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    @Override
    public String toString() {
        return "Inscripcion{id='" + id + "', fechaRegistro=" + fechaRegistro + "}";
    }
}