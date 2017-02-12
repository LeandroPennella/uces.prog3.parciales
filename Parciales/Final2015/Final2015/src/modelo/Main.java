package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		File f = new File("C:/numeros.txt");
		List <Verificador> verificadores = new ArrayList <Verificador>(); //v
		List <Numero> numeros = new ArrayList <Numero>();						//num
		
		BufferedReader in = null;
				
		try {
			in = new BufferedReader(new FileReader(f));
		
			String linea = in.readLine();//aux
			Numero numero = null;			//N
			
			while(linea != null){
				numero = new Numero(Integer.parseInt(linea));
				numeros.add(numero);
				verificadores.add(new Verificador(numero));
				linea = in.readLine();
			}
			
			
			for (Verificador verificador : verificadores) {
				verificador.start();
			}
				
			Thread.sleep(5000);
					
			for (Verificador verificador : verificadores) {
				verificador.interrupt();
			}
			
			Collections.sort(numeros, new CompNumero());
			
			for (Numero numero : numeros) {
				System.out.println(numero.toString());
			}
			

		} catch (FileNotFoundException  e) {
			System.out.println("No se encontro el archivo");
			
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo");	
			
		} catch (InterruptedException e) {
			System.out.println("Main Interrumpido");
		
		} finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("No se pudo cerrar el archivo");
				}
			}
		}
		
		System.out.println("--- Fin del Main ---");
		
	}

}
