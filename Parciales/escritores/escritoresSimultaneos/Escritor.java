package escritoresSimultaneos;


import java.io.FileWriter;
import java.io.IOException;

public class Escritor extends Thread {

	private String nombre;
	private int iteraciones;
	private FileWriter fw;

	public Escritor(String nombre, FileWriter fw) {
		this.nombre = nombre;
		this.iteraciones = 0;
		this.fw = fw;
	}

	public void run() {
		try {
			while (this.iteraciones < 10) {
				// try { El try no va dentro del while, porque si cachea una
				// excepcion, luego continua con el while
				synchronized (fw) { // Se sincroniza sólo cuando escribo
					fw.write(this.nombre + " " + "numero de iteracion: "
							+ this.iteraciones + "\r\n");
				}
				++this.iteraciones;
			}
			// Thread.sleep(200); esto estaba mal, no deberia estar
			// dentro del synchronized
		} catch (IOException e) {
			System.out.println("Error en la escritura");
			e.printStackTrace();
		}
		try {
			Thread.sleep(200); // Aca esta correctamente
		} catch (InterruptedException e) {
			System.out.println("El hilo: " + this.nombre + " fue interrumpido");
			e.printStackTrace();
		}
	}
}
