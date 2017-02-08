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
		String cadenaNumeros=leedor.leerPorLinea();
		int numeros[]=extraerNumeros(cadenaNumeros);
		for(int i=0;i<numeros.length;i++)
		{
			procesar(numeros[i]);
			
		}
	}
	

	
	static private int[] extraerNumeros(String cadenaNumeros)
	{

	  
	  //divido en string[] el string
	  String numerosString[] = cadenaNumeros.split(",");
	  
	  //convierto string[] en int[]
	  int numeros[]={};
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
		while (numeroActual!=1 && System.currentTimeMillis()>(TInicio+IntervaloMaximo))
		{
			
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
