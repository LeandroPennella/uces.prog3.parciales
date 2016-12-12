package escritoresSimultaneos;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import source.Escritor;

//import threads.Escritor;

public class Main {

	public static void main(String[] args) {
		List<Escritor> lista = new ArrayList<Escritor>();
		String nombreArchivo="escritores\\archivo.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(nombreArchivo);
			for (int i = 0; i < 10; ++i) {
				lista.add(new Escritor(("Thread numero " + i), fw));
			}

			for (Escritor escritor : lista) {
				escritor.start();
			}

			for (Escritor escritor : lista) {
				escritor.join();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error en la escritura");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Algun hilo fue interrumpido");
			e.printStackTrace();
		} finally {
			System.out.println("Escritura completa");
			if (fw != null) {
				try {
					fw.flush();
					fw.close();
				} catch (IOException e) {
					System.out
							.println("Ha surgido un problema al cerrar el archivo");
					e.printStackTrace();
				}
			}
		}

		System.out.println("Programa Terminado");

		int cantidad = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(nombreArchivo));
			String linea = br.readLine();
			while (linea != null) {
				++cantidad;
				System.out.println(linea);
				linea = br.readLine();
			}
			System.out.println("La cantidad total de lineas escritas fue de: "
					+ cantidad);
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo");
		} catch (IOException e) {
			System.out.println("Error en la lectura");
		} finally {
			System.out.println("Lectura completa");
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}
		}

		System.out.println("Programa terminado");

	}

}
