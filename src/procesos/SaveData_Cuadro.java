package procesos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
public class SaveData_Cuadro {
	private JTable ContenidoSD;
	private String NombreT="";
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
	public void GuardarTable(TableModel p, int g, int t) {
		//Error SD102
		try {
			if (NombreT!="") {
				ContenidoSD=new JTable();
				rutaG=Directorio + NombreT;
				FileWriter Save=new FileWriter(rutaG);
				BufferedWriter Process= new BufferedWriter(Save);
				ContenidoSD.setModel(p);
				Process.write("Columnas= " + g);
				Process.newLine();
				Process.write("Filas= " + t);
				Process.newLine();
				 for (int i = 0 ; i < g; i++) //realiza un barrido por columnas.
		            {
		                for(int j = 0 ; j < t;j++) //realiza un barrido por Filas.
		                {
		                	Process.write("C"+ i + "F" + j + "= " +(String)(ContenidoSD.getValueAt(j,i)));
		                	Process.newLine();
		                }
		            }
				 Process.close();
			}else {
				JOptionPane.showMessageDialog(null, "Esta sin nombre", "", JOptionPane.WARNING_MESSAGE);
			}
			
		 } catch (IOException e) {

			JOptionPane.showMessageDialog(null, "Error SD102", "SD Error", JOptionPane.WARNING_MESSAGE);
		}
	}

}
