package procesos;

import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class LoadData_Cuadro {
	public String ruta;
	private Properties ld = new Properties();
	private int Ancho;
	private int Largo;
	public DefaultTableModel Carga;
	public LoadData_Cuadro() {		
	}
	public void Cargando_datos(String archivoLoad){
		ruta = archivoLoad;
		try {
			ld.load(new FileReader(ruta));
			Ancho = Integer.parseInt(ld.getProperty("Columnas"));
			Largo = Integer.parseInt(ld.getProperty("Filas"));
			Carga= new DefaultTableModel(Largo ,Ancho);
			String veri;
			for(int x =Largo-1; x>=0; x--) {
				for (int y = Ancho-1; y>=0; y--) {
					veri=ld.getProperty("C"+ x + "F" + y);
					if ((veri=="null") || (veri.equals("null"))) {
						Carga.setValueAt("", x, y);
					}else {
						Carga.setValueAt(ld.getProperty("C"+ y + "F" + x), x, y);
					}
				}
				
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error LD101", "LD Error", JOptionPane.WARNING_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error LD101", "LD Error", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
