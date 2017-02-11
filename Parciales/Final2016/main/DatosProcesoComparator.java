package main;

import java.util.Comparator;

public class DatosProcesoComparator implements Comparator<DatosProceso>{
	@Override
	public int compare (DatosProceso d1, DatosProceso d2)
	{
	    if (d1.getNumeroInicial()== d2.getNumeroInicial()) {          //si la edad de la primer persona es igual a la edad de la segunda retornamos 0
	        return 0;
	    } else if (d1.getNumeroInicial()> d2.getNumeroInicial()) {    //si la edad de la primer persona es mayor la edad de la segunda retornamos 1
	        return 1;
	    } else {                           //si la edad de la primer persona es menor la edad de la segunda retornamos -1
	        return -1;
	    }
	}
}
