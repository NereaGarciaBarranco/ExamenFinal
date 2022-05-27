package examenFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
	
	static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	/**
	 * Pre: ---
	 * Post: 
	 */
	public static void main(String[] args) {
		informacionDivorcios();
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recorre un fichero y añade al array list de ciudades
	 * las diferentes ciudades. 
	 */
	public static void informacionDivorcios() {	
		String ruta = "C:\\Users\\Nerea\\Desktop\\divorcios.csv";
		File fichero = new File (ruta);
		try {
			// Creamos un escaner para poder leer el fichero
			Scanner f = new Scanner(fichero);
			// Para evitar la primera linea del csv
			int contador = 0;
			// Mientras el .csv siga teniendo lineas
			while(f.hasNextLine()) {
				String linea = f.nextLine();
				// Asi evitamos la cabecera del archivo
				if (contador != 0) {
					// Separamos las lineas por el separador del .csv
					String[] datos = linea.split(";");
					// A la ciudad le quitamos el identificador
					String nombre = datos[0].substring(3, datos[0].length());
					// Para saber si ese registro es con y sin separacion creamos un boolean
					boolean separacion;
					if(datos[1].equals("Si")) {
						separacion = true;
					} else {
						separacion = false;
					}
					// Pasamos a String los siguientes datos para poder trabajar con ellos
					int anyo = Integer.parseInt(datos[2]);
					int numeroDivorcios = Integer.parseInt(datos[3]);
					/*
					 * Comprobamos si la ciudad de la linea ya esta guardada en el
					 * ArrayList de ciudades para meterla o no. La primera vez
					 * siempre se añade porque es imposible que este.
					 */
					if (ciudades.size() == 0) {
						Ciudad nueva = new Ciudad (nombre);
						ciudades.add(nueva);
					} 
					// El resto de veces comprobamos si esta y si no, lo añadimos
					else { 					
						if(!comprobarCiudad(nombre)) {
							Ciudad nueva = new Ciudad (nombre);;
							ciudades.add(nueva);
						} // Si ya estaba 
						else {
							
						}
					}
				}
				contador++;
			}
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido acceder al fichero.");
			e.printStackTrace();
		}	
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo comprueba si un nombre de una ciudad pasada
	 * por parametro se encuentra ya en un ArrayList que almacena
	 * objetos de tipo Ciudad.
	 */	
	public static boolean comprobarCiudad(String ciudad) {
		boolean aparece = false;
		for (int i = 0; i < ciudades.size(); i++) {
			if(ciudades.get(i).getNombre().equals(ciudad)) {
				aparece = true;
				return aparece;
			}
		}
		return aparece;
	}
	
	public static int devolverPosicionCiudad(String nombre) {
		for (int i = 0; i < ciudades.size(); i++) {
			if(ciudades.get(i).getNombre().equals(nombre)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void agregarDatosPorAnyo(String nombre, boolean separacion, int anyo, int numeroDivorcios) {

	}
	
}
