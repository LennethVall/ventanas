package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Resultado extends JFrame implements ActionListener {

    private JButton btnCerrar;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private  String textoPuntos;
    private JLabel lblAciertos;
    private JLabel lblTiempo;

    public Resultado(String nombre, double puntos, long segundos){

        setTitle("Resultado final");
        setAlwaysOnTop(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        setIconImage(new ImageIcon("img/icono.png").getImage());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int opcion = JOptionPane.showConfirmDialog(
                        Resultado.this,
                        "¿Seguro que quieres cerrar?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        lblTitulo = new JLabel("¡Resultados del juego!", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setBounds(0, 10, 600, 40);
        add(lblTitulo);

        lblNombre = new JLabel("Jugador: " + nombre, JLabel.CENTER);
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNombre.setBounds(0, 60, 600, 25);
        add(lblNombre);

        textoPuntos = String.format("Aciertos: %.1f/6", puntos);
        lblAciertos = new JLabel(textoPuntos, JLabel.CENTER);
        lblAciertos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblAciertos.setBounds(0, 90, 600, 25);
        add(lblAciertos);

        // TIEMPO YA VIENE EN SEGUNDOS
        long minutos = segundos / 60;
        long segundosRestantes = segundos % 60;

        lblTiempo = new JLabel("Tiempo empleado: " + minutos + " min " + segundosRestantes + " s", JLabel.CENTER);
        lblTiempo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTiempo.setBounds(0, 120, 600, 25);
        add(lblTiempo);

        String mensaje;
        if (puntos <= 2) {
            mensaje = "¡Sigue practicando, lo estás haciendo bien!";
        } else if (puntos <= 4) {
            mensaje = "¡Buen trabajo! Vas por buen camino.";
        } else {
            mensaje = "¡Excelente! ¡Eres toda una experta!";
        }

        JLabel lblMensaje = new JLabel(mensaje, JLabel.CENTER);
        lblMensaje.setFont(new Font("Arial", Font.ITALIC, 18));
        lblMensaje.setForeground(new Color(0, 102, 204));
        lblMensaje.setBounds(0, 150, 600, 30);
        add(lblMensaje);

        ImageIcon imgOriginal;

        if (puntos <= 2) {
            imgOriginal = new ImageIcon("img/mal.png");
        } else if (puntos <= 4) {
            imgOriginal = new ImageIcon("img/regular.png");
        } else {
            imgOriginal = new ImageIcon("img/bien.png");
        }

        Image imgEscalada = imgOriginal.getImage().getScaledInstance(260, 260, Image.SCALE_SMOOTH);
        ImageIcon imgFinal = new ImageIcon(imgEscalada);

        JLabel lblImagen = new JLabel(imgFinal);
        lblImagen.setBounds(170, 190, 260, 260);
        add(lblImagen);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCerrar.setBounds(250, 460, 100, 35);
        btnCerrar.addActionListener(this);
        add(btnCerrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
