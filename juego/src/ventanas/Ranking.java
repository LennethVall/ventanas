package ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.util.*;

public class Ranking extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;

    public Ranking() {

        setTitle("Ranking de jugadores");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setIconImage(new ImageIcon("img/icono.png").getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        modelo = new DefaultTableModel();
        modelo.addColumn("Jugador");
        modelo.addColumn("Puntos");
        modelo.addColumn("Tiempo (s)");
        modelo.addColumn("Fecha");

        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
        tabla.setRowHeight(22);

        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar, BorderLayout.SOUTH);

        cargarRanking();
    }

    private void cargarRanking() {

        File archivo = new File("resultados.txt");
        if (!archivo.exists()) return;

        // Limpia la tabla para evitar duplicados
        modelo.setRowCount(0);

        List<String[]> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    lista.add(datos);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ORDENAR: puntos DESC, tiempo ASC
        lista.sort((a, b) -> {

            double puntosA = Double.parseDouble(a[1].replace(",", "."));
            double puntosB = Double.parseDouble(b[1].replace(",", "."));

            int cmp = Double.compare(puntosB, puntosA);
            if (cmp != 0) return cmp;

            long tiempoA = Long.parseLong(a[2]);
            long tiempoB = Long.parseLong(b[2]);

            return Long.compare(tiempoA, tiempoB);
        });

        // AÑADIR A LA TABLA
        for (String[] fila : lista) {
            modelo.addRow(fila);
        }
    }
}
