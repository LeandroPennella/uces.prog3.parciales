package modelo;

public class Numero{
	
	
	private int numero;
	private int operaciones = 0;
	private boolean seRealizo = false;
	
	public Numero(int numero){

		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(int operaciones) {
		this.operaciones = operaciones;
	}

	public boolean isSeRealizo() {
		return seRealizo;
	}

	public void setSeRealizo(boolean seRealizo) {
		this.seRealizo = seRealizo;
	}

	@Override
	public String toString() {
		
		String verificado;
		if(this.seRealizo){
			verificado = "SI";
		}
		else{
			verificado = "NO";
		}
		
		return "Numero: "+this.numero+"\nOperaciones: "+this.operaciones+"\nVerificado: "+verificado+"\n";
	}


	
	
	
	
	
	
	
	
}
