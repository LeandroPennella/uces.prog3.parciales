

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProcesadorArchivos {
	
	protected static final int CANT_MAX = 100;
	
	private File file;
	private SortedSet<Persona> personas = new TreeSet<Persona>();
	private List<MiThread> threads = new ArrayList<MiThread>();
	
	public ProcesadorArchivos(File file) {
		this.file = file;
	}
	
	public void iniciarLectura(){
		
		if(this.file.isDirectory()){
			File[] archivos = this.file.listFiles();
			
			for (int i = 0; i < archivos.length; i++) {
				MiThread thread = new MiThread(archivos[i], personas);
				threads.add(thread);
				thread.start();
			}
		
			esperarProcesos();
			imprimirListado();
		}
		
	}

	private void imprimirListado() {
		
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}

	private void esperarProcesos() {
		for (MiThread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.out.println("Me interrumpieron");
			}
		}
	}
}
