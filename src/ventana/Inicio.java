package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JTextArea;

public class Inicio extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JTextArea jtaName;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Pregunta 1");
		
		JLabel lblTitulo = new JLabel("Empieza el juego");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20)); 
        lblTitulo.setText(lblTitulo.getText());              
        getContentPane().add(lblTitulo, BorderLayout.NORTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(89, 200, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this); {
		   
		}

		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(266, 200, 89, 23);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		
		jtaName = new JTextArea();
		jtaName.setBounds(131, 97, 146, 23);
		contentPane.add(jtaName);
		
		JLabel lblNewLabel = new JLabel("Introduce tu nombre");
		lblNewLabel.setBounds(131, 47, 146, 14);
		contentPane.add(lblNewLabel);
	}
	public static void main(String[] args) {
        new Inicio().setVisible(true);
    }
	private void abrirDialogo(String nombre) {
		Dialogo dialogo=new Dialogo(this,nombre);
		dialogo.setVisible(true);
	}
	private void cerrar() {
		this.dispose();
	}
	
    @Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == btnAceptar)
		{
			String nombre=jtaName.getText();
			abrirDialogo(nombre);
		}
			    
		if (event.getSource() == btnSalir) {
			cerrar();
		}
		
		
    }
		 
		    
    
}
		        
		 
    

