package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import Leedor.Leedor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//abrir
		
		String ArchivoConNumeros="numeros.txt";
		Leedor leedor=new Leedor(ArchivoConNumeros);
		String cadenaNumeros="";
		Procesador procesador=new Procesador();
		try{
		
			cadenaNumeros=leedor.leer();
			System.out.println("cadena="+cadenaNumeros);
			
			

			int numeros[]=extraerNumeros(cadenaNumeros);

			System.out.println(Arrays.toString(numeros));
			System.out.println(numeros.length+" items extraidos.");
			for(int i=0;i<numeros.length;i++)
			{
				System.out.println("> procesando "+i+" item");
				procesador.procesar(numeros[i]);
				System.out.println("< procesando "+i+" item");
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
