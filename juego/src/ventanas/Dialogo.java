package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Dialogo extends JDialog implements ActionListener {

    private JButton okButton, cancelButton;

    private JRadioButton r1, r2, r3;
    private JComboBox<String> comboBox;
    private JCheckBox ch1, ch2, ch3;
    private JTextField txtP4;
    private JSpinner spP5;
    private JComboBox<String> cbColor;
    private JLabel lblPreview;
    private JPanel panel;
    private String nombre;
    private JScrollPane scroll;
    private JLabel lblP1;
    private  JLabel lblP2;
    private JLabel lblP3;
    private ButtonGroup grupo1;
    private JLabel lblP4;
    private JLabel lblP5;
    private JLabel lblP6;
    private JPanel buttonPane;
    
    private double puntos = 0;
    
    private long tiempoInicio;

    public Dialogo(Frame owner, boolean modal, String nombre) {
        super(owner, modal);
        this.nombre = nombre;

        setTitle("Preguntas");
        setSize(500, 500);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        setIconImage(new ImageIcon("img/icono.png").getImage());

        // Confirmación al cerrar con la X
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        Dialogo.this,
                        "¿Seguro que quieres salir?\nPerderás la puntuación.",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (opcion == JOptionPane.YES_OPTION) dispose();
            }
        });

        // PANEL CON SCROLL
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(480, 650));

        scroll = new JScrollPane(panel);
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, BorderLayout.CENTER);

        // -------------------------
        // PREGUNTA 1 - RADIOBUTTONS
        // -------------------------
        lblP1 = new JLabel("1. ¿Qué criatura suele acompañar al héroe en muchas aventuras fantásticas?");
        lblP1.setBounds(10, 10, 450, 20);
        panel.add(lblP1);

        r1 = new JRadioButton("Un dragón bebé");
        r1.setBounds(30, 35, 200, 20);
        panel.add(r1);

        r2 = new JRadioButton("Un cactus gigante");
        r2.setBounds(30, 60, 200, 20);
        panel.add(r2);

        r3 = new JRadioButton("Un zapato volador");
        r3.setBounds(30, 85, 200, 20);
        panel.add(r3);

        grupo1 = new ButtonGroup();
        grupo1.add(r1);
        grupo1.add(r2);
        grupo1.add(r3);

        // -------------------------
        // PREGUNTA 2 - COMBOBOX
        // -------------------------
        lblP2 = new JLabel("2. ¿Qué objeto es típico para guardar objetos mágicos?");
        lblP2.setBounds(10, 120, 450, 20);
        panel.add(lblP2);

        comboBox = new JComboBox<>();
        comboBox.addItem("Mochila dimensional");
        comboBox.addItem("Caja de cartón normal");
        comboBox.addItem("Piedra parlante");
        comboBox.setBounds(30, 145, 200, 25);
        comboBox.setSelectedIndex(-1);
        panel.add(comboBox);

        // -------------------------
        // PREGUNTA 3 - CHECKBOXES
        // -------------------------
        lblP3 = new JLabel("3. ¿Qué elementos suelen aparecer en un videojuego de aventuras?");
        lblP3.setBounds(10, 185, 450, 20);
        panel.add(lblP3);

        ch1 = new JCheckBox("Cofres con tesoros");
        ch1.setBounds(30, 210, 200, 20);
        panel.add(ch1);

        ch2 = new JCheckBox("Llaves misteriosas");
        ch2.setBounds(30, 235, 200, 20);
        panel.add(ch2);

        ch3 = new JCheckBox("Facturas de la luz");
        ch3.setBounds(30, 260, 200, 20);
        panel.add(ch3);

        // -------------------------
        // PREGUNTA 4 - TEXTO LIBRE
        // -------------------------
        lblP4 = new JLabel("4. ¿Cómo se llama la espada legendaria que aparece en muchas historias de fantasía?");
        lblP4.setBounds(10, 300, 470, 20);
        panel.add(lblP4);

        txtP4 = new JTextField();
        txtP4.setBounds(30, 325, 200, 25);
        panel.add(txtP4);

        // -------------------------
        // PREGUNTA 5 - SPINNER
        // -------------------------
        lblP5 = new JLabel("5. ¿Cuántas vidas tiene un gato místico según las leyendas?");
        lblP5.setBounds(10, 365, 450, 20);
        panel.add(lblP5);

        spP5 = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        spP5.setBounds(30, 390, 60, 25);
        panel.add(spP5);

        // -------------------------
        // PREGUNTA 6 - COLOR
        // -------------------------
        lblP6 = new JLabel("6. ¿De qué color es la energía mágica más estable en las historias de fantasía?");
        lblP6.setBounds(10, 430, 470, 20);
        panel.add(lblP6);

        cbColor = new JComboBox<>(new String[]{"Azul", "Verde", "Morado"});
        cbColor.setBounds(30, 455, 120, 25);
        panel.add(cbColor);

        lblPreview = new JLabel("Vista previa");
        lblPreview.setBounds(170, 455, 120, 25);
        panel.add(lblPreview);

        cbColor.addActionListener(e -> {
            String c = (String) cbColor.getSelectedItem();
            switch (c) {
                case "Azul" -> lblPreview.setForeground(Color.BLUE);
                case "Verde" -> lblPreview.setForeground(Color.GREEN);
                case "Morado" -> lblPreview.setForeground(new Color(128, 0, 128));
            }
        });

        // -------------------------
        // BOTONES
        // -------------------------
        buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(buttonPane, BorderLayout.SOUTH);

        okButton = new JButton("OK");
        okButton.addActionListener(this);
        buttonPane.add(okButton);

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(this);
        buttonPane.add(cancelButton);

        getRootPane().setDefaultButton(okButton);

        tiempoInicio = System.currentTimeMillis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == okButton) {
            puntos = 0;

            // PREGUNTA 1
            if (r1.isSelected()) puntos += 1;

            // PREGUNTA 2
            if ("Mochila dimensional".equals(comboBox.getSelectedItem())) puntos += 1;

            // PREGUNTA 3
            double puntosP3 = 0;
            boolean ok1 = ch1.isSelected();
            boolean ok2 = ch2.isSelected();
            boolean bad = ch3.isSelected();

            if (!bad) {
                if (ok1) puntosP3 += 0.5;
                if (ok2) puntosP3 += 0.5;
            }

            puntos += puntosP3;

            // PREGUNTA 4
            String p4 = txtP4.getText().trim().toLowerCase();
            if (p4.equals("espada maestra") || p4.equals("master sword") || p4.equals("la espada legendaria"))
                puntos += 1;

            // PREGUNTA 5
            if ((int) spP5.getValue() == 9) puntos += 1;

            // PREGUNTA 6
            if ("Azul".equals(cbColor.getSelectedItem())) puntos += 1;

            // TIEMPO
            long tiempoFin = System.currentTimeMillis();
            long tiempoTotal = tiempoFin - tiempoInicio;
            long segundos = tiempoTotal / 1000;

            // MOSTRAR RESULTADO
            Resultado r = new Resultado(nombre, puntos, segundos);

            try (PrintWriter out = new PrintWriter(new FileWriter("resultados.txt", true))) {
                out.println(nombre + ";" + String.format("%.1f", puntos) + ";" + segundos + ";" + LocalDateTime.now());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            r.setVisible(true);
            dispose();
        }

        if (e.getSource() == cancelButton) {
            dispose();
        }
    }
}
