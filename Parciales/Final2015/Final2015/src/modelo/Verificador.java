package modelo;

public class Verificador extends Thread {

	private Numero numero;
	private int cont;
	private boolean encontro;
	

	public Verificador(Numero numero) {
		this.cont = 0;
		this.numero = numero;
	}

	public void run() {
		
		int num = numero.getNumero();
		
		try {
			while (num != 1) {
				
				if(num % 2 == 0){
					num /= 2;
				}
				else{
					num += 3;
				}
				this.cont ++;
				Thread.sleep(50);				
			}
			
			this.encontro = true;
			
		} catch (InterruptedException e) {
			System.out.println("Thread Interrumpido");
		}finally{
			numero.setOperaciones(this.cont);
			numero.setSeRealizo(this.encontro);
		}

	}

}
