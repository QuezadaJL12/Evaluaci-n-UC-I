/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arranque;

import controller.InscripcionController;
import repository.AlumnoRepository;
import repository.TallerRepository;
import service.InscripcionService;
import view.InscripcionView;

/**
 *
 * @author Chino
 */
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            InscripcionView view = new InscripcionView();
            TallerRepository tr = new TallerRepository();
            AlumnoRepository ar = new AlumnoRepository();
            InscripcionService service = new InscripcionService();

            InscripcionController controller = new InscripcionController(view, tr, ar, service);
            view.setController(controller);

            view.setVisible(true);
            controller.cargarTalleres();
        });
    }
}
