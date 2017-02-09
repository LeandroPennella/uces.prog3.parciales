package modelo;

import java.util.Comparator;

public class CompNumero implements Comparator <Numero>{

	@Override
	public int compare(Numero n1, Numero n2) {
		
		if(n1.getNumero() != n2.getNumero()){
			if(n1.getNumero() > n2.getNumero()){
				return 1;
			}
			else{
				return -1;
			}
		}

		return 0;
	}
	
	
	
	
	
	
}	
