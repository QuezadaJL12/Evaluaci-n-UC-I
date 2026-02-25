/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.HashMap;
import java.util.Map;
import model.Alumno;

/**
 *
 * @author Chino
 */
public class AlumnoRepository {
    private final Map<String, Alumno> alumnos = new HashMap<>();

    public AlumnoRepository() {
        // Datos de prueba
        alumnos.put("A001", new Alumno("A001", "Juan Pérez", 4, "ISW"));
        alumnos.put("A002", new Alumno("A002", "María López", 2, "ISW"));
        alumnos.put("A003", new Alumno("A003", "Carlos Ruiz", 6, "ITI"));
    }

    public Alumno buscarPorId(String idAlumno) {
        return alumnos.get(idAlumno);
    }
}
