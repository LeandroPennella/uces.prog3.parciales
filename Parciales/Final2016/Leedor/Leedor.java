package Leedor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Leedor {
	String nombreArchivo;
	private FileReader fr;
	public Leedor(String nombreArchivo){
		this.nombreArchivo=nombreArchivo;
		}

	public void abrir(String nombreArchivo)
	{			
		try {
			 fr = new FileReader(nombreArchivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		BufferedReader b = new BufferedReader(fr);

		//extraigo string del archivo;
		try {
			while((cadena += b.readLine())!=null) {

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cadena;
	}
	
}
