package main;

public class DatosProceso {
	private long tiempoProceso;
	private int numeroInicial;
	private int numeroFinal;
	private int intentos;
	
	public long getTiempoProceso() {
		return tiempoProceso;
	}
	public void setTiempoProceso(long tiempoProceso) {
		this.tiempoProceso = tiempoProceso;
	}
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
