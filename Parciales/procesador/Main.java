

import java.io.File;

public class Main {
	
	public static void main(String[] args) {
		
		ProcesadorArchivos procesador = new ProcesadorArchivos(new File("procesador\\a"));
		procesador.iniciarLectura();
	}
}
