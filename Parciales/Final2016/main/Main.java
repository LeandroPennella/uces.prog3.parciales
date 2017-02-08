package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//abrir
		String ArchivoConNumeros="numeros.txt";

	}
	
	private String leerArchivo(string nombreArchivo)
	{
		try {
			FileReader fr = new FileReader(ArchivoConNumeros);
            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private int[] extraerNumeros(String numerosString)
	{
	  String cadena="";
	  BufferedReader b = new BufferedReader(fr);
	  
	  //extraigo string del archivo;
	  try {
		while((cadena = b.readLine())!=null) {
	  }
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
	  //divido en string[] el string
	  String numerosString[] = cadena.split(",");
	  
	  //convierto string[] en int[]
	  int numeros[]={};
	  for(int i = 0;i < numerosString.length;i++)
	  {
		  numeros[i] = Integer.parseInt(numerosString[i]);
	  }
	  return numeros;  

	}

}
