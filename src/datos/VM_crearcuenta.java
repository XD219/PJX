package datos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VM_crearcuenta extends JFrame {

	ButtonGroup grupoderadios;
	private boolean AccessAdmin=false;
	private boolean AccessAcept=false;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_Nombre;
	private JTextField textField_Usuario;
	private JTextField textField_Apellido;
	private JLabel Label_Aviso;
	private String data_Usuario;
	private String data_Password;
	private String data_Nombre;
	private String data_Apellido;

	public VM_crearcuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		grupoderadios = new ButtonGroup();
		
		JLabel lblNombreDeCuenta = new JLabel("Nombre de cuenta");
		lblNombreDeCuenta.setBounds(22, 114, 96, 14);
		contentPane.add(lblNombreDeCuenta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 33, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(22, 58, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(22, 150, 66, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 147, 135, 20);
		contentPane.add(passwordField);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(78, 30, 121, 20);
		contentPane.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(118, 111, 135, 20);
		contentPane.add(textField_Usuario);
		textField_Usuario.setColumns(10);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setBounds(78, 55, 121, 20);
		contentPane.add(textField_Apellido);
		textField_Apellido.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnAceptar.setBounds(278, 196, 89, 23);
		contentPane.add(btnAceptar);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setEnabled(AccessAdmin);
		rdbtnAdmin.setSelected(false);
		rdbtnAdmin.setBounds(258, 29, 109, 23);
		contentPane.add(rdbtnAdmin);
		
		JRadioButton rdbtnVisitante = new JRadioButton("Visitante");
		rdbtnVisitante.setSelected(true);
		rdbtnVisitante.setBounds(258, 64, 109, 23);
		contentPane.add(rdbtnVisitante);
		
		grupoderadios.add(rdbtnAdmin);
		grupoderadios.add(rdbtnVisitante);
		
	    Label_Aviso = new JLabel("");
		Label_Aviso.setBounds(10, 196, 155, 23);
		Label_Aviso.setText("");
		contentPane.add(Label_Aviso);
	}
	public void guardar() {
		String ruta = "src/cuentas/" + textField_Usuario.getText();
		data_Usuario="String Usuario =" + textField_Usuario.getText();
		data_Password="String Password =" + passwordField.getText();
		data_Nombre="String Nombre =" + textField_Nombre.getText();
		data_Apellido="String Apellido =" + textField_Apellido.getText();
		FileWriter gr;	
		File ex = new File(ruta);
		if (!(ex.exists())) {
			
		    try
		        {
		            gr = new FileWriter(ruta);
		            BufferedWriter grabar = new BufferedWriter(gr);
		            grabar.write(data_Usuario);
		            grabar.newLine();
		            grabar.write(data_Password);
		            grabar.newLine();
		            grabar.write(data_Nombre);
		            grabar.newLine();
		            grabar.write(data_Apellido);
		            grabar.newLine();
		            grabar.close();
		            Label_Aviso.setText("Guardado exictosamente");
		        }

		        catch(IOException io)

		        {
		        	
		        	Label_Aviso.setText("Error al abrir el fichero");

		            return;
		 
		        }
		}else {
			Label_Aviso.setText("La cuenta ya existe");
		}
	}
}
