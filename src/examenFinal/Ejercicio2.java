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
			// Creamos los contadores necesarios
			int contadorConSeparacion2019 = 0;
			int contadorSinSeparacion2018 = 0;
			// Mientras el .csv siga teniendo lineas
			while(f.hasNextLine()) {
				System.out.println("Vamos en la linea " + (contador + 1));
				String linea = f.nextLine();
				System.out.println(linea);
				// Asi evitamos la cabecera del archivo
				if (contador != 0) {
					// Limpiamos la linea de puntos
					linea = linea.replace("...", "");
					linea = linea.replace(".","");
					// Separamos las lineas por el separador del .csv
					String[] datos = linea.split(";");
					// A la ciudad le quitamos el identificador
					if(datos.length == 3) {
						String nombre = datos[0];
						System.out.println(nombre);
						// Para saber si ese registro es con y sin separacion creamos un boolean
						boolean separacion;
						if(datos[1].equals("Si")) {
							separacion = true;
						} else {
							separacion = false;
						}
						// Pasamos a String los siguientes datos para poder trabajar con ellos
						int anyo = Integer.parseInt(datos[2]);
						System.out.println(anyo);
						int numeroDivorcios = Integer.parseInt(datos[3]);
						if (anyo == 2019 && separacion == true) {
							contadorConSeparacion2019++;
						} else if (anyo == 2018 && separacion == false) {
							contadorSinSeparacion2018++;
						}			
					} else {
						System.out.println("Ignoramos linea");
					}
				}
				contador++;
			}
			f.close();
			System.out.println(contadorConSeparacion2019);
			System.out.println(contadorSinSeparacion2018);
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
	
	/**
	 * Pre: ---
	 * Post: Este metodo devuelve la posicion de una ciudad en un 
	 * ArrayList de objetos de tipo ciudad, encontrandolo por su 
	 * nombre pasado por parametro.
	 * @param nombre
	 * @return
	 */
	public static int devolverPosicionCiudad(String nombre) {
		for (int i = 0; i < ciudades.size(); i++) {
			if(ciudades.get(i).getNombre().equals(nombre)) {
				return i;
			}
		}
		return -1;
	}
	
}
