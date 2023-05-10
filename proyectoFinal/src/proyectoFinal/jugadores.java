package proyectoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class jugadores extends menuPrincipal{

	

	   String nombre;
	   int puntuacion;
	
	
	public jugadores(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}
	


	    public String getNombre() {
	        return nombre;
	    }

	    public int getPuntos() {
	        return puntuacion;
	    }

	    public void setPuntos(int puntos) {
	        this.puntuacion = puntos;
	    }

	public void mostrarDatos() {
		System.out.println("Nombre: "+nombre);
		
	}

	
	

}
