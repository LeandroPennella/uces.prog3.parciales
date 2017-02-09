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
		List <Verificador> v = new ArrayList <Verificador>();
		List <Numero> num = new ArrayList <Numero>();
		
		BufferedReader in = null;
				
		try {
			in = new BufferedReader(new FileReader(f));
		
			String aux = in.readLine();
			Numero n = null;
			
			while(aux != null){
				n = new Numero(Integer.parseInt(aux));
				num.add(n);
				v.add(new Verificador(n));
				aux = in.readLine();
			}
			
			
			for (Verificador verificador : v) {
				verificador.start();
			}
				
			Thread.sleep(5000);
					
			for (Verificador verificador : v) {
				verificador.interrupt();
			}
			
			Collections.sort(num, new CompNumero());
			
			for (Numero numero : num) {
				System.out.println(numero.toString());
			}
			

		} catch (FileNotFoundException  e) {
			System.out.println("No se encontro el archivo");
			
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo");	
		}catch (InterruptedException e) {
			System.out.println("Main Interrumpido");
		}finally{
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
