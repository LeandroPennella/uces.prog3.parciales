package main;

public class Procesador {
	private int numero;
	public Procesador(){};
	public Procesador(int numero){this.numero=numero;}
	public void procesar(int numero) throws InterruptedException
	{
		System.out.println("- arrancando proceso...");
		long TInicio, TFin, TDelay=50,TIntervaloMaximo=5000;
		TInicio = System.currentTimeMillis(); 
		int numeroActual=numero;
		int intentos=0;
		System.out.println("- arrancando bucle proceso....");
		while (numeroActual!=1 && System.currentTimeMillis()<(TInicio+TIntervaloMaximo))
		{
			//System.out.println("intento:" +intentos);
			Thread.sleep(TDelay);
			if(numeroActual%2==0)//es par
			{numeroActual=numeroActual/2;}
			else
			{numeroActual+=3;}
			//System.out.println("- numero actual: " + numeroActual);
			intentos++;
		}
		System.out.println((numeroActual==1)?"Exito!!!":"Fracaso...");
		System.out.println("* numero inicizl="+numero);
		System.out.println("* numero final="+numeroActual);
		System.out.println("* intentos="+intentos);
		long tiempototal=System.currentTimeMillis()-TInicio;
		System.out.println("* tiempo invertido: "+tiempototal);
		
	}
}
