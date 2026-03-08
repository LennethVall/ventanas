package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inicio extends JFrame implements ActionListener {

    private JButton btnJugar;
    private JButton btnSalir;
    private JButton btnRanking;
    private JTextField txtNombre;
    private JLabel lblTitulo;
    private JLabel lblNombre;

    public Inicio() {

        setTitle("Inicio del juego");
        setSize(500, 400);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon("img/icono.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // TÍTULO
        lblTitulo = new JLabel("¡Bienvenido al Juego!", JLabel.CENTER);
        lblTitulo.setBounds(0, 30, 500, 40);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        getContentPane().add(lblTitulo);

        // TEXTO "Introduce un nombre"
        lblNombre = new JLabel("Introduce un nombre para jugar:");
        lblNombre.setBounds(80, 110, 250, 30);
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        getContentPane().add(lblNombre);

        // CAMPO DE TEXTO PARA EL NOMBRE
        txtNombre = new JTextField();
        txtNombre.setBounds(80, 145, 220, 30);
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        getContentPane().add(txtNombre);

        // BOTÓN JUGAR A LA DERECHA DEL CAMPO
        btnJugar = new JButton("Jugar");
        btnJugar.setBounds(310, 145, 100, 30);
        btnJugar.setFont(new Font("Arial", Font.BOLD, 16));
        btnJugar.addActionListener(this);
        getContentPane().add(btnJugar);

        // BOTÓN RANKING
        btnRanking = new JButton("Ver ranking");
        btnRanking.setBounds(41, 288, 150, 40);
        btnRanking.setFont(new Font("Arial", Font.BOLD, 18));
        btnRanking.addActionListener(this);
        getContentPane().add(btnRanking);

        // BOTÓN SALIR
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(310, 288, 150, 40);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 18));
        btnSalir.addActionListener(this);
        getContentPane().add(btnSalir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnJugar) {

            String nombre = txtNombre.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debes introducir un nombre para jugar.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            Dialogo d = new Dialogo(this, true, nombre);
            d.setVisible(true);
        }

        if (e.getSource() == btnRanking) {
            Ranking r = new Ranking();
            r.setVisible(true);
        }

        if (e.getSource() == btnSalir) {
            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que quieres salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
       
            new Inicio().setVisible(true);
        
    }
}
