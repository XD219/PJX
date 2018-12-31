package datos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.print.PrinterException;
import java.io.File;
import java.text.MessageFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import procesos.SaveData_Cuadro;
import procesos.LoadData_Cuadro;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;

public class In_Cuadro extends JFrame {
	
	private JLabel Label_Path = new JLabel("");
	private JFileChooser sa = new JFileChooser();
	private File archivo;
	private int S_Colum=8;
	private int S_Filas=41;
	private JLabel Label_Prueba;
	private JComboBox<String> com_Columnas;
	private JComboBox<String> com_Filas;
	private Object Columnas[];
	private Object Filas[][];
	private JPanel contentPane;
	private JTextField textField_NLista;
	private JTable table;
	private DefaultTableModel TModel;
	private JPasswordField passwordField;
	int n=1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					In_Cuadro frame = new In_Cuadro();
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
	public In_Cuadro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1650, 1050);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sa.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int resultado=sa.showOpenDialog(mntmAbrir);
				archivo=sa.getSelectedFile();
				if (resultado!=JFileChooser.CANCEL_OPTION){
					LoadData_Cuadro k= new LoadData_Cuadro();
					Label_Path.setText(archivo.getAbsolutePath());
					k.Cargando_datos(archivo.getAbsolutePath());
					table.setModel(k.Carga);
				}else {
					JOptionPane.showMessageDialog(null, "Cancelado", "Mensaje", JOptionPane.YES_OPTION);
				}
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProcessSave();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmConfiguracion = new JMenuItem("Configuracion");
		mnPerfil.add(mntmConfiguracion);
		
		JMenu mnConexion = new JMenu("Conexion");
		menuBar.add(mnConexion);
		
		JMenuItem mntmIniciarSesion = new JMenuItem("Iniciar sesion");
		mnConexion.add(mntmIniciarSesion);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mnConexion.add(mntmCerrarSesion);
		
		JMenuItem mntmConfigurar = new JMenuItem("Configurar");
		mnConexion.add(mntmConfigurar);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);
		
		JMenuItem mntmActualizacion = new JMenuItem("Actualizacion");
		mnAcercaDe.add(mntmActualizacion);
		
		JMenuItem mntmInformacion = new JMenuItem("Informacion");
		mnAcercaDe.add(mntmInformacion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 11, 840, 656);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"A", "B", "C", "D", "E", "F", "G", "H"
			}
		));
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				utilJTablePrint(table, textField_NLista.getText(), "Código Xules", true );
			}
		});
		btnImprimir.setBounds(42, 644, 89, 23);
		contentPane.add(btnImprimir);
		
		JPanel panel_OpBasico = new JPanel();
		panel_OpBasico.setBounds(10, 11, 153, 200);
		contentPane.add(panel_OpBasico);
		panel_OpBasico.setLayout(null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la lista");
		lblNombreDeLa.setBounds(22, 5, 107, 14);
		panel_OpBasico.add(lblNombreDeLa);
		
		textField_NLista = new JTextField();
		textField_NLista.setBounds(22, 24, 107, 20);
		textField_NLista.setText("SinNombre");
		panel_OpBasico.add(textField_NLista);
		textField_NLista.setColumns(10);
		
		JLabel lblColumnas = new JLabel("Columnas:");
		lblColumnas.setBounds(10, 55, 50, 14);
		panel_OpBasico.add(lblColumnas);
		
		JComboBox com_Columnas_1 = new JComboBox<String>();
		com_Columnas_1.setBounds(70, 55, 47, 20);
		panel_OpBasico.add(com_Columnas_1);
		com_Columnas_1.setModel(new DefaultComboBoxModel(new String[] {"8", "7", "6", "5", "4", "3", "2", "1"}));
		
		JComboBox com_Filas_1 = new JComboBox();
		com_Filas_1.setBounds(70, 86, 47, 20);
		panel_OpBasico.add(com_Filas_1);
		com_Filas_1.setModel(new DefaultComboBoxModel(new String[] {"41", "40", "39", "38", "37", "36", "35", "34", "33", "32", "31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"}));
		
		JLabel lblFilas = new JLabel("Filas:");
		lblFilas.setBounds(10, 89, 46, 14);
		panel_OpBasico.add(lblFilas);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 186, 153, 14);
		panel_OpBasico.add(separator_1);
		
		JPanel panel_OpAvanzando = new JPanel();
		panel_OpAvanzando.setBounds(10, 222, 153, 411);
		contentPane.add(panel_OpAvanzando);
		panel_OpAvanzando.setLayout(null);
		
		JLabel lblOpcionesAvanzadas = new JLabel("Opciones Avanzadas");
		lblOpcionesAvanzadas.setBounds(23, 5, 107, 13);
		lblOpcionesAvanzadas.setFont(new Font("Times New Roman", Font.BOLD, 11));
		panel_OpAvanzando.add(lblOpcionesAvanzadas);
		
		JLabel lblOpcionVisitante = new JLabel("Opcion Visitante");
		lblOpcionVisitante.setBounds(38, 23, 77, 14);
		panel_OpAvanzando.add(lblOpcionVisitante);
		
		JRadioButton rdbtnModoLectura = new JRadioButton("Modo lectura");
		rdbtnModoLectura.setBounds(23, 44, 87, 23);
		rdbtnModoLectura.setEnabled(false);
		panel_OpAvanzando.add(rdbtnModoLectura);
		
		JRadioButton rdbtnConContrasea = new JRadioButton("Con Contraseña");
		rdbtnConContrasea.setBounds(23, 70, 103, 23);
		rdbtnConContrasea.setEnabled(false);
		panel_OpAvanzando.add(rdbtnConContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setEnabled(false);
		passwordField.setBounds(23, 95, 107, 23);
		panel_OpAvanzando.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 129, 153, 14);
		panel_OpAvanzando.add(separator);
		
		JLabel lblMarcosbordes = new JLabel("Marcos-Bordes");
		lblMarcosbordes.setBounds(10, 142, 100, 14);
		panel_OpAvanzando.add(lblMarcosbordes);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		buttonGroup.add(rdbtnNormal);
		rdbtnNormal.setSelected(true);
		rdbtnNormal.setBounds(6, 163, 109, 23);
		panel_OpAvanzando.add(rdbtnNormal);
		rdbtnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				if (o.getSource()==rdbtnNormal) {
					table.setShowHorizontalLines(true);
					table.setShowVerticalLines(true);
				}
			}
		});
		
		JRadioButton rdbtnPersonalizado = new JRadioButton("Personalizado");
		buttonGroup.add(rdbtnPersonalizado);
		rdbtnPersonalizado.setBounds(6, 189, 109, 23);
		panel_OpAvanzando.add(rdbtnPersonalizado);
		
		Label_Path.setBounds(589, 678, 421, 14);
		contentPane.add(Label_Path);
		rdbtnPersonalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				if (o.getSource()==rdbtnPersonalizado) {
					table.setShowHorizontalLines(false);
					table.setShowVerticalLines(false);
				}
			}
		});
		
		com_Filas_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				if (o.getSource()==com_Filas_1) {
					if (com_Filas_1.getSelectedItem()=="41") {
						S_Filas=41;
					}else if(com_Filas_1.getSelectedItem()=="40") {
						S_Filas=40;
					}else if(com_Filas_1.getSelectedItem()=="39") {
						S_Filas=39;
					}else if(com_Filas_1.getSelectedItem()=="38") {
						S_Filas=38;
					}else if(com_Filas_1.getSelectedItem()=="37") {
						S_Filas=37;
					}else if(com_Filas_1.getSelectedItem()=="36") {
						S_Filas=36;
					}else if(com_Filas_1.getSelectedItem()=="35") {
						S_Filas=35;
					}else if(com_Filas_1.getSelectedItem()=="34") {
						S_Filas=34;
					}else if(com_Filas_1.getSelectedItem()=="33") {
						S_Filas=33;
					}else if(com_Filas_1.getSelectedItem()=="32") {
						S_Filas=32;
					}else if(com_Filas_1.getSelectedItem()=="31") {
						S_Filas=31;
					}else if(com_Filas_1.getSelectedItem()=="30") {
						S_Filas=30;
					}else if(com_Filas_1.getSelectedItem()=="29") {
						S_Filas=29;
					}else if(com_Filas_1.getSelectedItem()=="28") {
						S_Filas=28;
					}else if(com_Filas_1.getSelectedItem()=="27") {
						S_Filas=27;
					}else if(com_Filas_1.getSelectedItem()=="26") {
						S_Filas=26;
					}else if(com_Filas_1.getSelectedItem()=="25") {
						S_Filas=25;
					}else if(com_Filas_1.getSelectedItem()=="24") {
						S_Filas=24;
					}else if(com_Filas_1.getSelectedItem()=="23") {
						S_Filas=23;
					}else if(com_Filas_1.getSelectedItem()=="22") {
						S_Filas=22;
					}else if(com_Filas_1.getSelectedItem()=="21") {
						S_Filas=21;
					}else if(com_Filas_1.getSelectedItem()=="20") {
						S_Filas=20;
					}else if(com_Filas_1.getSelectedItem()=="19") {
						S_Filas=19;
					}else if(com_Filas_1.getSelectedItem()=="18") {
						S_Filas=18;
					}else if(com_Filas_1.getSelectedItem()=="17") {
						S_Filas=17;
					}else if(com_Filas_1.getSelectedItem()=="16") {
						S_Filas=16;
					}else if(com_Filas_1.getSelectedItem()=="15") {
						S_Filas=15;
					}else if(com_Filas_1.getSelectedItem()=="14") {
						S_Filas=14;
					}else if(com_Filas_1.getSelectedItem()=="13") {
						S_Filas=13;
					}else if(com_Filas_1.getSelectedItem()=="12") {
						S_Filas=12;
					}else if(com_Filas_1.getSelectedItem()=="11") {
						S_Filas=11;
					}else if(com_Filas_1.getSelectedItem()=="10") {
						S_Filas=10;
					}else if(com_Filas_1.getSelectedItem()=="9") {
						S_Filas=9;
					}else if(com_Filas_1.getSelectedItem()=="8") {
						S_Filas=8;
					}else if(com_Filas_1.getSelectedItem()=="7") {
						S_Filas=7;
					}else if(com_Filas_1.getSelectedItem()=="6") {
						S_Filas=6;
					}else if(com_Filas_1.getSelectedItem()=="5") {
						S_Filas=5;
					}else if(com_Filas_1.getSelectedItem()=="4") {
						S_Filas=4;
					}else if(com_Filas_1.getSelectedItem()=="3") {
						S_Filas=3;
					}else if(com_Filas_1.getSelectedItem()=="2") {
						S_Filas=2;
					}else if(com_Filas_1.getSelectedItem()=="1") {
						S_Filas=1;
					}
					JTable_Tam();
					
				}
			}

		});
		com_Columnas_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==com_Columnas_1) {
					if (com_Columnas_1.getSelectedItem()=="8") {
						S_Colum=8;
					}else if (com_Columnas_1.getSelectedItem()=="7") {
						S_Colum=7;
					}else if (com_Columnas_1.getSelectedItem()=="6") {
						S_Colum=6;
					}else if (com_Columnas_1.getSelectedItem()=="5") {
						S_Colum=5;
					}else if (com_Columnas_1.getSelectedItem()=="4") {
						S_Colum=4;
					}else if (com_Columnas_1.getSelectedItem()=="3") {
						S_Colum=3;
					}else if (com_Columnas_1.getSelectedItem()=="2") {
						S_Colum=2;
					}else if (com_Columnas_1.getSelectedItem()=="1") {
						S_Colum=1;
					}
					JTable_Tam();
				}
		}});
		
	}
	public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog){        
	    boolean fitWidth = true;        
	    boolean interactive = true;
	    // We define the print mode (Definimos el modo de impresión)
	    JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
	    try {
	        // Print the table (Imprimo la tabla)             
	        boolean complete = jTable.print(mode,
	                new MessageFormat(header),
	                new MessageFormat(footer),
	                showPrintDialog,
	                null,
	                interactive);                 
	        if (complete) {
	            // Mostramos el mensaje de impresión existosa
	            JOptionPane.showMessageDialog(jTable,
	                    "Print complete (Impresión completa)",
	                    "Print result (Resultado de la impresión)",
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            // Mostramos un mensaje indicando que la impresión fue cancelada                 
	            JOptionPane.showMessageDialog(jTable,
	                    "Print canceled (Impresión cancelada)",
	                    "Print result (Resultado de la impresión)",
	                    JOptionPane.WARNING_MESSAGE);
	        }
	    } catch (PrinterException pe) {
	        JOptionPane.showMessageDialog(jTable, 
	                "Print fail (Fallo de impresión): " + pe.getMessage(), 
	                "Print result (Resultado de la impresión)", 
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
	public void JTable_Tam() {	
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		//sumar columnas
		if (S_Colum>table.getColumnCount()) {
			Object T_Filas[]=new Object [S_Filas];
			for (int l=table.getColumnCount(); l<S_Colum; l++) {
				modelo.addColumn(T_Filas);
			}
		}
		//restar filas
		if (S_Filas<table.getRowCount()) {
			for(int l=table.getRowCount()-1; l>=S_Filas; l--) {
				modelo.removeRow(l); 
			}
		}
		//sumar fila
		if (S_Filas>table.getRowCount()) {
			Object T_Colum[]=new Object [S_Colum];
			for (int l=table.getRowCount(); l<S_Filas; l++) {
				modelo.addRow(T_Colum);
			}
		}
		//restar columnas
		if (S_Colum<table.getColumnCount()) {
			for(int l=table.getColumnCount()-1; l>=S_Colum; l--) {
				table.removeColumn (table.getColumnModel().getColumn(l));
			}
		}

	}
	public void ProcessSave() {
		table.selectAll();
		SaveData_Cuadro Guardar= new SaveData_Cuadro();
		Guardar.setNombreT(textField_NLista.getText());
		Guardar.GuardarTable(table.getModel(), S_Colum, S_Filas);
	}
	public void Nuevo() {
		Columnas=new Object[S_Colum];
		Filas=new Object [S_Filas][S_Colum];
		textField_NLista.setText("SinNombre" + n);

		TModel= new DefaultTableModel(Filas, Columnas);
		table.setModel(TModel);	
		n++;
	}
}
