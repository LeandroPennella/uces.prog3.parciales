

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedSet;

public class MiThread extends Thread{
	
	private File file;
	private SortedSet<Persona> personas;
	
	public MiThread(File file, SortedSet<Persona> personas) {
		this.file = file;
		this.personas = personas;
	}

	@Override
	public void run(){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(this.file));
			String line = "";
			
			while( (line = reader.readLine()) != null){
				
				String[] atributos = line.split(",");
				Persona persona = new Persona(atributos[0], atributos[1], Integer.parseInt(atributos[2]));
				
				synchronized(this.personas){
					if(this.personas.size() == ProcesadorArchivos.CANT_MAX){
						return;
					}
					this.personas.add(persona);
				}
			}
		}catch(NumberFormatException e){
			System.out.println("El formato de edad no es correcto. " + e.getMessage());
		}catch(IOException e){
			System.out.println("Ocurrio un Error al procesar el archivo. " + e.getMessage());
		}finally{
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Ocurrio un error al cerrar el archivo." + e.getMessage());
				}
			}
		}
	}

	public SortedSet<Persona> getPersonas() {
		return personas;
	}
	
	
}
