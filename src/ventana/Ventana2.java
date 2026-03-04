package ventana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana2 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAceptar;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
		
	public Ventana2(String textoRecibido) { setTitle(textoRecibido);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(54, 190, 71, 23);
		contentPane.add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(289, 190, 89, 23);
		contentPane.add(btnSalir);
		
		
	}
	public static void main(String[] args) {
        new Inicio().setVisible(true);
    }
	private void abrirOtroFrame() {
		Ventana3 ventana3=new Ventana3();
		ventana3.setVisible(true);
	}
	private void cerrar() {
		this.dispose();
	}
	
    @Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == btnAceptar)
			abrirOtroFrame();
	            
	    
		if (event.getSource() == btnSalir) {
			cerrar();
		
    }
}
}
