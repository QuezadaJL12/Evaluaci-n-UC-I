/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Chino
 */
public class Ticket {
    private String folio;
    private String status;
    private Date fechaEmision;
    private Inscripcion inscripcion;

    public Ticket(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
        this.status = "INSCRITO";
        this.fechaEmision = new Date();
        generarFolio();
    }

    public void generarFolio() {
        this.folio = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getFolio() { return folio; }
    public String getStatus() { return status; }
    public Date getFechaEmision() { return fechaEmision; }
    public Inscripcion getInscripcion() { return inscripcion; }
}