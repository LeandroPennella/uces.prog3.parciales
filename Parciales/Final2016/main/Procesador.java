package main;

public class Procesador {
	private DatosProceso datosProceso;
	public Procesador(){};
	public Procesador(DatosProceso datosProceso) throws InterruptedException{
		this.datosProceso=datosProceso;
		procesar();
		}
	public void procesar() throws InterruptedException
	{
		int numero=datosProceso.getNumeroInicial();
		System.out.println("- arrancando proceso para "+numero+"...");
		long TInicio, TFin, TDelay=50,TIntervaloMaximo=5000;
		TInicio = System.currentTimeMillis(); 
		int numeroActual=numero;
		int intentos=0;

		while (numeroActual!=1 && System.currentTimeMillis()<(TInicio+TIntervaloMaximo))
		{
			
			Thread.sleep(TDelay);
			if(numeroActual%2==0){	//es par
				numeroActual/=2;
			} else {
				numeroActual+=3;
			}

			intentos++;
		}
		long tiempoTotal=System.currentTimeMillis()-TInicio;
		//return new DatosProceso(numero, numeroActual, intentos, tiempototal);
		datosProceso.setNumeroFinal(numeroActual);
		datosProceso.setIntentos(intentos);
		datosProceso.setTiempoProceso(tiempoTotal);
		
		
	}
}
