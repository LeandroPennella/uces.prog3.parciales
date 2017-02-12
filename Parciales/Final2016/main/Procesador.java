package main;

public class Procesador extends Thread{
	private DatosProceso datosProceso;
	public Procesador(){};
	public Procesador(DatosProceso datosProceso) throws InterruptedException{
		this.datosProceso=datosProceso;
		
		}
	public void run() 
	{
		int numero=datosProceso.getNumeroInicial();
		System.out.println("- arrancando proceso para "+numero+"...");
		long TDelay=50;


		int numeroActual=numero;
		int intentos=0;

		try {
			while (numeroActual!=1 )
			{
				
				
					//todo: try arriba de while? porque?
					
					Thread.sleep(TDelay);
				
				if(numeroActual%2==0){	//es par
					numeroActual/=2;
				} else {
					numeroActual+=3;
				}
	
				intentos++;
			}
		} catch (InterruptedException e) {
			//todo: thorwear excepcion
			System.out.println("thread " +numero+" interrumpido");
		}

finally{
		datosProceso.setNumeroFinal(numeroActual);
		datosProceso.setIntentos(intentos);
}
		
		
	}
}
