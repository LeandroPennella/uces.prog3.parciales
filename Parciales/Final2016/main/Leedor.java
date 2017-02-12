package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Leedor {
	String nombreArchivo;

	public Leedor(String nombreArchivo){
		this.nombreArchivo=nombreArchivo;
		
		}


	
	public String leer() throws Exception
	{
		String cadena="";
		FileReader fr=null;
		try {
			System.out.println("abriendo...");
			 fr = new FileReader(nombreArchivo);
			 cadena=leerPorLinea(fr);
		} catch (FileNotFoundException e) {
			throw new Exception("no se pudo abrir el archivo");
		} catch (IOException e) {
			throw new Exception(e.getMessage());
		} 
		finally {
			if (fr!=null)
			{
				System.out.println("cerrando...");
				try {
					fr.close();
				} catch (IOException e) {

					throw new Exception("no se pudo cerrar el archivo");

				}
			}

		}
		return cadena;

	}
	

	public String leerPorLinea(FileReader fr) throws IOException
	{		  
		System.out.println("leyendo...");
		String cadena="";
		String linea="";
		BufferedReader b = new BufferedReader(fr);

		try {
			linea = b.readLine();
			while(linea!=null){
				cadena+=linea;
				linea=b.readLine();
			}

		} catch (IOException e) {
			throw new IOException("no se pudo leer los datos");
		}
		return cadena;
	}
	
}
