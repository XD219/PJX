package datos;

import java.io.File;

public class Prueba {


	public static void main (String[]args) {
		String op = "Diego";
		File ex = new File("src/cuentas/", op);
		if (ex.exists()) {
			System.out.println("si existe");
		}else {
			System.out.println("No existe");
		}
	}
}
