package datos;


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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VM_crearcuenta extends JFrame {

	ButtonGroup grupoderadios;
	private boolean AccessAdmin=false;
	private boolean AccessAcept=false;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField_Nombre;
	private JTextField textField_Usuario;
	private JTextField textField_ApellidoPaterno;
	private JLabel Label_Aviso;
	private String data_Usuario;
	private String data_Password;
	private String data_Nombre;
	private String data_ApellidoP;
	private String data_ApellidoM;
	private String data_Question;
	private String data_Answer;
	private String data_Nombre_Vsb;
	private JTextField textField_ApellidoMaterno;
	private JTextField textField_Nombre_Visible;
	private JTextField textField_SPregunta;
	private JTextField textField_SRespuesta;

	public VM_crearcuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		grupoderadios = new ButtonGroup();
		
		JLabel lblNombreDeCuenta = new JLabel("Nombre de cuenta");
		lblNombreDeCuenta.setBounds(22, 145, 96, 14);
		contentPane.add(lblNombreDeCuenta);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 33, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(22, 58, 82, 14);
		contentPane.add(lblApellidoPaterno);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(22, 217, 66, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 214, 145, 20);
		contentPane.add(passwordField);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(103, 30, 155, 20);
		contentPane.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		textField_Nombre.setText(textField_Nombre.getText().toLowerCase());
		
		textField_Usuario = new JTextField();
		textField_Usuario.setBounds(128, 142, 145, 20);
		contentPane.add(textField_Usuario);
		textField_Usuario.setColumns(10);
		textField_Usuario.setText(textField_Usuario.getText().toLowerCase());
		
		textField_ApellidoPaterno = new JTextField();
		textField_ApellidoPaterno.setBounds(103, 55, 155, 20);
		contentPane.add(textField_ApellidoPaterno);
		textField_ApellidoPaterno.setColumns(10);
		textField_ApellidoPaterno.setText(textField_ApellidoPaterno.getText().toLowerCase());
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnAceptar.setBounds(305, 339, 89, 23);
		contentPane.add(btnAceptar);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setEnabled(AccessAdmin);
		rdbtnAdmin.setSelected(false);
		rdbtnAdmin.setBounds(292, 54, 109, 23);
		contentPane.add(rdbtnAdmin);
		
		JRadioButton rdbtnVisitante = new JRadioButton("Visitante");
		rdbtnVisitante.setSelected(true);
		rdbtnVisitante.setBounds(292, 79, 109, 23);
		contentPane.add(rdbtnVisitante);
		
		grupoderadios.add(rdbtnAdmin);
		grupoderadios.add(rdbtnVisitante);
		
	    Label_Aviso = new JLabel("");
	    Label_Aviso.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		Label_Aviso.setBounds(22, 339, 262, 23);
		Label_Aviso.setText("");
		contentPane.add(Label_Aviso);
		
		JLabel lblTipo = new JLabel("Tipo de cuenta");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(292, 33, 89, 14);
		contentPane.add(lblTipo);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(22, 83, 82, 14);
		contentPane.add(lblApellidoMaterno);
		
		textField_ApellidoMaterno = new JTextField();
		textField_ApellidoMaterno.setBounds(103, 80, 155, 20);
		contentPane.add(textField_ApellidoMaterno);
		textField_ApellidoMaterno.setColumns(10);
		textField_ApellidoMaterno.setText(textField_ApellidoMaterno.getText().toLowerCase());
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosPersonales.setBounds(22, 8, 109, 14);
		contentPane.add(lblDatosPersonales);
		
		JLabel lblDatosDeCuenta = new JLabel("Datos de cuenta");
		lblDatosDeCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosDeCuenta.setBounds(22, 120, 96, 14);
		contentPane.add(lblDatosDeCuenta);
		
		JLabel lblApodo = new JLabel("Nombre Visible");
		lblApodo.setBounds(22, 181, 74, 14);
		contentPane.add(lblApodo);
		
		textField_Nombre_Visible = new JTextField();
		textField_Nombre_Visible.setBounds(128, 178, 145, 20);
		contentPane.add(textField_Nombre_Visible);
		textField_Nombre_Visible.setColumns(10);
		textField_Nombre_Visible.setText(textField_Nombre_Visible.getText().toLowerCase());
		
		JLabel lblPreguntaDeSeguridad = new JLabel("Pregunta de seguridad");
		lblPreguntaDeSeguridad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreguntaDeSeguridad.setBounds(22, 255, 133, 14);
		contentPane.add(lblPreguntaDeSeguridad);
		
		JLabel lblPregunta = new JLabel("Pregunta");
		lblPregunta.setBounds(22, 280, 66, 14);
		contentPane.add(lblPregunta);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setBounds(22, 314, 66, 14);
		contentPane.add(lblRespuesta);
		
		textField_SPregunta = new JTextField();
		textField_SPregunta.setBounds(91, 277, 182, 20);
		contentPane.add(textField_SPregunta);
		textField_SPregunta.setColumns(10);
		textField_SPregunta.setText(textField_SPregunta.getText().toLowerCase());
		
		textField_SRespuesta = new JTextField();
		textField_SRespuesta.setBounds(91, 311, 182, 20);
		contentPane.add(textField_SRespuesta);
		textField_SRespuesta.setColumns(10);
		textField_SRespuesta.setText(textField_SRespuesta.getText().toLowerCase());
	}
	public void guardar() {
		String ruta = "src/cuentas/" + textField_Usuario.getText();
		data_Usuario="Usu_Account=" + textField_Usuario.getText();
		data_Password="Pass_Account=" + passwordField.getText();
		data_Nombre="Nombre_Data=" + textField_Nombre.getText();
		data_ApellidoP="ApellidoP_Data =" + textField_ApellidoPaterno.getText();
		data_ApellidoM="ApellidoM_Data =" + textField_ApellidoMaterno.getText();
		data_Nombre_Vsb="NV_Data =" + textField_Nombre_Visible.getText();
		data_Question="Question_Segurity =" + textField_SPregunta.getText();
		data_Answer="Answer_Segurity =" + textField_SRespuesta.getText();
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
		            grabar.write(data_ApellidoP);
		            grabar.newLine();
		            grabar.write(data_ApellidoM);
		            grabar.newLine();
		            grabar.write(data_Nombre_Vsb);
		            grabar.newLine();
		            grabar.write(data_Question);
		            grabar.newLine();
		            grabar.write(data_Answer);
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
