package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Leedor {
	String nombreArchivo;
	private FileReader fr=null;
	public Leedor(String nombreArchivo){
		this.nombreArchivo=nombreArchivo;
		
		}


	
	public String leer() throws Exception
	{
		String cadena="";
		System.out.println("abriendo archivo..");
		try {
			 fr = new FileReader(nombreArchivo);
			 System.out.println("leyendo archivo...");
			 cadena=leerPorLinea();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Exception("no se pudo abrir el archivo");
			//e.printStackTrace();
		} finally {
			if (fr!=null)
			{
				System.out.println("cerrando...");
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new Exception("no se pudo cerrar el archivo");
					
					
				}
			}

		}
		return cadena;

	}
	
	public String leerPorCaracter()
	{
		String cadena="";
		try {

            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return cadena;

	}
	public String leerPorLinea()
	{		  
		String cadena="";
		String linea="";
		BufferedReader b = new BufferedReader(fr);
		System.out.println("entrando al bucle");
		//extraigo string del archivo;
		try {
			linea = b.readLine();
			while(linea!=null){
				cadena+=linea;
				linea=b.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena;
	}
	
}
