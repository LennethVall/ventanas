package ventana;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Dialogo extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> comboBox;
	private JButton cancelButton;
	private JRadioButton rbOk;
	private JRadioButton rbCancelar;
	private String nombre;
	private JCheckBox chNo;
	private JCheckBox chSi;
	/**
	 * Create the dialog.
	 */
	public Dialogo(JFrame parent, String nombre) {
		super(parent, true); // tue por ser modal
		this.nombre=nombre;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("1. Que boton pasa a la siguientente ventana?");
			lblNewLabel.setBounds(10, 11, 239, 14);
			contentPanel.add(lblNewLabel);
		}

		rbOk = new JRadioButton("OK");
		rbOk.setBounds(30, 32, 109, 23);
		contentPanel.add(rbOk);

		rbCancelar = new JRadioButton("Cancelar");
		rbCancelar.setBounds(30, 54, 109, 23);
		contentPanel.add(rbCancelar);
		
		ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbOk);                        
        grupo.add(rbCancelar);
        
        ButtonGroup grupo2 = new ButtonGroup();
        grupo.add(chNo);
        grupo.add(chSi);

		JLabel lblNewLabel_1 = new JLabel("2. Que hace la x?");
		lblNewLabel_1.setBounds(10, 84, 98, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("3. Ha terminado la prueva?");
		lblNewLabel_2.setBounds(10, 150, 151, 14);
		contentPanel.add(lblNewLabel_2);

		chNo = new JCheckBox("No estoy seguro");
		chNo.setBounds(109, 171, 97, 23);
		contentPanel.add(chNo);

		chSi = new JCheckBox("Si, claro");
		chSi.setBounds(10, 171, 97, 23);
		contentPanel.add(chSi);

//		combo = new JComboBox<>();
//        combo.addItem("ESO");
//        combo.addItem("Bachillerato");
//        combo.insertItemAt("FP", 1);              // insertItemAt
//        combo.getItemCount();                     // getItemCount
//        combo.getItemAt(0);                       // getItemAt
//        combo.setSelectedIndex(0);                // setSelectedIndex
//        combo.getSelectedIndex();                 // getSelectedIndex
//        combo.getSelectedItem();  

		comboBox = new JComboBox<>();
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(30, 108, 151, 34);
		contentPanel.add(comboBox);
		comboBox.addItem("Sale del programa");
		comboBox.addItem("Marca el lugar");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == cancelButton)
			this.dispose();
	//}rbJava.setSelected(true);                 // setSelected
   // if(rbJava.isSelected()) {                      // isSelected
       // rbJava.getText().equals("SI"){
        //	cont++;
        }  
    }// getText
}