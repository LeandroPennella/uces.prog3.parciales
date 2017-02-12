package main;

public class DatosProceso {

	private int numeroInicial;
	private int numeroFinal;
	private int intentos;
	

	public int getNumeroInicial() {
		return numeroInicial;
	}

	public int getNumeroFinal() {
		return numeroFinal;
	}
	public void setNumeroFinal(int numeroFinal) {
		this.numeroFinal = numeroFinal;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	
	public DatosProceso( int numeroInicial)
	{
		
		this.numeroInicial=numeroInicial;

	}
}
