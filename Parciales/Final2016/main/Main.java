package main;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		List<DatosProceso> datosProcesos=new ArrayList<DatosProceso>();
		String ArchivoConNumeros="numeros.txt";
		String cadenaNumeros="";
		Procesador procesador=new Procesador();
		try{
			Leedor leedor=new Leedor(ArchivoConNumeros);
			cadenaNumeros=leedor.leer(); 					System.out.println("cadena="+cadenaNumeros);
			int numeros[]=extraerNumeros(cadenaNumeros);	System.out.println(numeros.length+" items extraidos: "+Arrays.toString(numeros));
			for(int i=0;i<numeros.length;i++)
			{
				datosProcesos.add(procesador.procesar(numeros[i]));
			}
			
			
			
			
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.exit(0); 
		
	}
	

	
	static private int[] extraerNumeros(String cadenaNumeros)
	{


	  //divido en string[] el string
	  String numerosString[] = cadenaNumeros.split(",");
	  
	  //convierto string[] en int[]
	  int numeros[]=new int[numerosString.length];
	  //System.out.println("- extraerNumeros - parseando string[] a int[] "+numerosString.length + " elementos" );
	  

	  for(int i = 0;i < numerosString.length;i++)
	  {
		  //System.out.println("- extraerNumeros - parsea item "+i);
		  numeros[i] = Integer.parseInt(numerosString[i].trim());
	  }
	  
	  System.out.println("numeros "+numeros.length);
	  return numeros;  

	}
	


}
