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
public class Ticket {
    private String folio;
    private String status;
    private Date fechaEmision;

    public Ticket() {}

    public Ticket(String folio, String status, Date fechaEmision) {
        this.folio = folio;
        this.status = status;
        this.fechaEmision = fechaEmision;
    }

    public String getFolio() { return folio; }
    public void setFolio(String folio) { this.folio = folio; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }

    @Override
    public String toString() {
        return "Ticket{folio='" + folio + "', status='" + status + "', fechaEmision=" + fechaEmision + "}";
    }
}