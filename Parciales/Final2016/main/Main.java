package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Leedor.Leedor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//abrir
		
		String ArchivoConNumeros="numeros.txt";
		Leedor leedor=new Leedor(ArchivoConNumeros);
		String cadenaNumeros="";

		try{
		
			cadenaNumeros=leedor.leer();
			System.out.println("cadena="+cadenaNumeros);
			System.out.println("parseando a int[]...");
			int numeros[]=extraerNumeros(cadenaNumeros);
			System.out.println(numeros.length+"items extraidos.");
			for(int i=0;i<numeros.length;i++)
			{
				System.out.println("procesando "+i+" item");
				procesar(numeros[i]);
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.exit(0); 
		
	}
	

	
	static private int[] extraerNumeros(String cadenaNumeros)
	{

	  System.out.println("diviendo en string[]...");
	  //divido en string[] el string
	  String numerosString[] = cadenaNumeros.split(",");
	  
	  //convierto string[] en int[]
	  int numeros[]={};
	  System.out.println("parseando string[] a int...");
	  for(int i = 0;i < numerosString.length;i++)
	  {
		  numeros[i] = Integer.parseInt(numerosString[i]);
	  }
	  return numeros;  

	}
	
	static private void procesar(int numero)
	{
		
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		long IntervaloMaximo=50;
		TInicio = System.currentTimeMillis(); 
		int numeroActual=numero;
		int intentos=0;
		System.out.println("arrancando bucle proceso....");
		while (numeroActual!=1 && System.currentTimeMillis()>(TInicio+IntervaloMaximo))
		{
			System.out.println("intento:" +intentos);
			//todo: delay
			if(numeroActual%2==0)//es par
			{numeroActual=numeroActual/2;}
			else
			{numeroActual+=3;}
			intentos++;
		}
		System.out.println("numero inicizl="+numero);
		System.out.println("numero final="+numeroActual);
		System.out.println("intentos="+intentos);
		
	}

}
