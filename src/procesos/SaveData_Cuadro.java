package procesos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
public class SaveData_Cuadro {
	private JTable ContenidoSD;
	private String NombreT;
	private String Directorio="src/libreria/";
	private String rutaG;
	public SaveData_Cuadro() {
		
	}
	public void setNombreT(String NombreT) {
		this.NombreT=NombreT;
	}
	public String getNombreT() {
		return NombreT;
	}
	public void GuardarTable(TableModel p) {
		//Error SD102
		try {
			ContenidoSD=new JTable();
			rutaG=Directorio + NombreT + ".txt";
			FileWriter Save=new FileWriter(rutaG);
			BufferedWriter Process= new BufferedWriter(Save);
			ContenidoSD.setModel(p);
			 for (int i = 0 ; i < ContenidoSD.getColumnCount(); i++) //realiza un barrido por filas.
	            {
	                for(int j = 0 ; j < ContenidoSD.getRowCount();j++) //realiza un barrido por columnas.
	                {
	                	Process.write("C"+ i + "F" + j + ": " +(String)(ContenidoSD.getValueAt(j,i)));
	                	Process.newLine();
	                }
	            }
			 Process.close();
		 } catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Error SD102", "SD Error", JOptionPane.WARNING_MESSAGE);
		}
	}

}
