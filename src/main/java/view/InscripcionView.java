/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.InscripcionController;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import model.*;

/**
 *
 * @author Chino
 */
public class InscripcionView extends JFrame {

    private final DefaultListModel<Taller> talleresModel = new DefaultListModel<>();
    private final JList<Taller> listTalleres = new JList<>(talleresModel);

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel panelDerecho = new JPanel(cardLayout);


    private final JPanel cardEmpty = new JPanel(new BorderLayout());
    private final JTextArea areaDetalles = new JTextArea();
    private final JPanel cardDetalles = new JPanel(new BorderLayout());

    private final JPanel cardBuscarAlumno = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JTextField txtIdAlumno = new JTextField(10);

    private final JTextArea areaAlumno = new JTextArea();
    private final JPanel cardAlumno = new JPanel(new BorderLayout());

    private final JTextArea areaTicket = new JTextArea();
    private final JPanel cardTicket = new JPanel(new BorderLayout());

    private InscripcionController controller;

    public InscripcionView() {
        super("Semana ISW - Inscripción a Taller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);


        listTalleres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(listTalleres);
        JPanel left = new JPanel(new BorderLayout());
        left.add(new JLabel("Talleres disponibles"), BorderLayout.NORTH);
        left.add(scroll, BorderLayout.CENTER);

       
        cardEmpty.add(new JLabel("Seleccione un taller"), BorderLayout.CENTER);

        areaDetalles.setEditable(false);
        JButton btnInscribirse = new JButton("Inscribirse");
        cardDetalles.add(new JScrollPane(areaDetalles), BorderLayout.CENTER);
        cardDetalles.add(btnInscribirse, BorderLayout.SOUTH);

        JButton btnBuscar = new JButton("Buscar");
        cardBuscarAlumno.add(new JLabel("ID del alumno:"));
        cardBuscarAlumno.add(txtIdAlumno);
        cardBuscarAlumno.add(btnBuscar);

        areaAlumno.setEditable(false);
        JButton btnConfirmar = new JButton("Confirmar inscripción");
        JPanel southAlumno = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southAlumno.add(btnConfirmar);
        cardAlumno.add(new JScrollPane(areaAlumno), BorderLayout.CENTER);
        cardAlumno.add(southAlumno, BorderLayout.SOUTH);

        areaTicket.setEditable(false);
        cardTicket.add(new JScrollPane(areaTicket), BorderLayout.CENTER);

        panelDerecho.add(cardEmpty, "EMPTY");
        panelDerecho.add(cardDetalles, "DETALLES");
        panelDerecho.add(cardBuscarAlumno, "BUSCAR");
        panelDerecho.add(cardAlumno, "ALUMNO");
        panelDerecho.add(cardTicket, "TICKET");

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, panelDerecho);
        split.setDividerLocation(350);
        add(split);

 
        listTalleres.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && controller != null) {
                Taller t = listTalleres.getSelectedValue();
                if (t != null) controller.seleccionarTaller(t.getId());
            }
        });

        btnInscribirse.addActionListener(e -> cardLayout.show(panelDerecho, "BUSCAR"));

        btnBuscar.addActionListener(e -> {
            if (controller == null) return;
            controller.buscarAlumno(txtIdAlumno.getText().trim());
        });

        btnConfirmar.addActionListener(e -> {
            if (controller == null) return;
            controller.confirmarInscripcion();
        });

        cardLayout.show(panelDerecho, "EMPTY");
    }

    public void setController(InscripcionController controller) {
        this.controller = controller;
    }

    public void mostrarTalleres(List<Taller> talleres) {
        talleresModel.clear();
        for (Taller t : talleres) talleresModel.addElement(t);
    }

    public void mostrarDetalles(Taller taller) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        areaDetalles.setText(
            "ID: " + taller.getId() + "\n" +
            "Taller: " + taller.getNombreCompleto() + "\n" +
            "Instructor: " + taller.getInstructor() + "\n" +
            "Fecha: " + sdf.format(taller.getFecha()) + "\n" +
            "Horario: " + taller.getHorario() + "\n" +
            "Cupo: " + taller.getCupoActual() + "/" + taller.getCupoMax() + "\n"
        );
        cardLayout.show(panelDerecho, "DETALLES");
    }

    public void mostrarDatosAlumno(Alumno alumno) {
        areaAlumno.setText(
            "ID: " + alumno.getId() + "\n" +
            "Nombre: " + alumno.getNombre() + "\n" +
            "Semestre: " + alumno.getSemestre() + "\n" +
            "Programa: " + alumno.getPrograma() + "\n"
        );
        cardLayout.show(panelDerecho, "ALUMNO");
    }

    public void mostrarTicket(Ticket ticket) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Inscripcion ins = ticket.getInscripcion();
        areaTicket.setText(
            "=== TICKET DE INSCRIPCIÓN ===\n" +
            "Folio: " + ticket.getFolio() + "\n" +
            "Estado: " + ticket.getStatus() + "\n" +
            "Fecha emisión: " + sdf.format(ticket.getFechaEmision()) + "\n\n" +
            "Alumno: " + ins.getAlumno().getNombre() + " (" + ins.getAlumno().getId() + ")\n" +
            "Taller: " + ins.getTaller().getNombreCompleto() + " (" + ins.getTaller().getId() + ")\n" +
            "Horario: " + ins.getTaller().getHorario() + "\n"
        );
        cardLayout.show(panelDerecho, "TICKET");
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
