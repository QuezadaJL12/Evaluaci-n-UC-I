/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;


import model.Ticket;
import view.InscripcionView;

/**
 *
 * @author Chino
 */
public class ObserverInscripcion implements IInscripcionObserver {
    private final InscripcionView view;

    public ObserverInscripcion(InscripcionView view) {
        this.view = view;
    }

    @Override
    public void update(Ticket ticket) {
     
        javax.swing.SwingUtilities.invokeLater(() -> view.mostrarTicket(ticket));
    }
}