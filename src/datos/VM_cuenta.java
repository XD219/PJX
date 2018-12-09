package datos;

import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import procesos.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VM_cuenta extends JFrame {
	private JLabel Label_Aviso = new JLabel("");
	private JPanel contentPane;
	private JTextField Cuenta_Usuario;
	private JPasswordField Cuenta_Password;
	private Properties p = new Properties();

	public VM_cuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Iniciando sesion");
		
		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuenta.setBounds(44, 58, 46, 14);
		contentPane.add(lblCuenta);
		
		Cuenta_Usuario = new JTextField();
		Cuenta_Usuario.setColumns(10);
		Cuenta_Usuario.setBounds(125, 55, 196, 20);
		contentPane.add(Cuenta_Usuario);
		Cuenta_Usuario.setText(Cuenta_Usuario.getText().toUpperCase());
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(44, 111, 71, 14);
		contentPane.add(lblContrasea);
		
		Cuenta_Password = new JPasswordField();
		Cuenta_Password.setBounds(125, 108, 196, 20);
		contentPane.add(Cuenta_Password);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Account_Process();
			}
		});
		btnAceptar.setBounds(291, 168, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VM_crearcuenta op = new VM_crearcuenta();
				op.setVisible(true);
				dispose();
			}
		});
		btnCrear.setBounds(26, 168, 89, 23);
		contentPane.add(btnCrear);
		

		Label_Aviso.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		Label_Aviso.setBounds(125, 172, 156, 14);
		contentPane.add(Label_Aviso);
	}
	@SuppressWarnings("deprecation")
	public void Account_Process() {
		String r ="src/cuentas/" + Cuenta_Usuario.getText();
		File ex = new File(r);
		if (ex.exists()) {
			Label_Aviso.setText("Procesando datos");
			try {
				Usuario Access_Usu=new Usuario();
				p.load(new FileReader(r));
				Access_Usu.setPassword_segurity(p.getProperty("Pass_Account"));
				if ((Cuenta_Password.getText()).equals(Access_Usu.getPassword_segurity())) {
					Access_Usu.setUsuario(p.getProperty("Usu_Account"));
					Access_Usu.setNombre(p.getProperty("Nombre_Data"));
					Access_Usu.setApellidoP(p.getProperty("ApellidoP_Data"));
					Access_Usu.setApellidoM(p.getProperty("ApellidoM_Data"));
					Access_Usu.setNV(p.getProperty("NV_Data"));
					Access_Usu.setQuestion_segurity(p.getProperty("Question_Segurity"));
					Access_Usu.setAnswer_segurity(p.getProperty("Answer_Segurity"));
					Label_Aviso.setText("correcto");
				}else {
					Label_Aviso.setText("Contraseña incorrecta");
				}
			} catch (FileNotFoundException e) {
				Label_Aviso.setText("error al carga de la cuenta");
			} catch (IOException e) {
				Label_Aviso.setText("error al carga de la cuenta");
			}
		}else {
			Label_Aviso.setText("No existe la cuenta");
		}
	}
}
