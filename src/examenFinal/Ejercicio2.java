package examenFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio2 {
	
	static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	/**
	 * Pre: ---
	 * Post: 
	 */
	public static void main(String[] args) {
		informacionDivorcios();
		/*
		 * Para obtener la ciudad con mas divorcios lo que hacemos
		 * es ordenarlas de mayor a menor numero de divorcios y 
		 * mostrar por pantalla la que queda en primera posicion.
		 */
		System.out.println("\nLa ciudad con mayor numero de divorcios es: ");
		Collections.sort(ciudades);
		System.out.println(ciudades.get(0).toString());
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
				String linea = f.nextLine();
				// Asi evitamos la cabecera del archivo
				if (contador != 0) {
					// Limpiamos la linea de puntos para poder coger los numeros
					linea = linea.replace(".","");
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
					// Pasamos a int los siguientes datos para poder trabajar con ellos
					int anyo = Integer.parseInt(datos[2]);
					int numeroDivorcios;
					// Si el dato del numero de divorcios esta vacio lo seteamos a 0
					if(datos.length == 3) {
						numeroDivorcios = 0;
					} else {
						// Si no esta vacio lo parsemos
						numeroDivorcios = Integer.parseInt(datos[3]);						
					}
					if (anyo == 2019 && separacion == true) {
						contadorConSeparacion2019 += numeroDivorcios;
					} else if (anyo == 2018 && separacion == false) {
						contadorSinSeparacion2018 += numeroDivorcios;
					}
					/*
					 * Hacemos lo correspondiente para averiguar la ciudad 
					 * con mas divorcios. Si es la primera ciudad que leemos
					 * la añadimos al ArrayList de ciudades y si no antes
					 * de añadirla preguntamos si esta yo o o. 
					 */
					if (contador == 1) {
						Ciudad nueva = new Ciudad (nombre);
						ciudades.add(nueva);
						ciudades.get(0).setContadorDivorciosTotales(numeroDivorcios);
					} 
					// En el resto de casos
					else {
						// Si la ciudad esta ya almacenada
						if (comprobarCiudad(nombre)) {
							//Buscamos su posicion en el ArrayList
							int posicion = devolverPosicionCiudad(nombre);
							// Le sumamos el numero de divorcios
							ciudades.get(posicion).setContadorDivorciosTotales
								(ciudades.get(posicion).getContadorDivorciosTotales() 
										+ numeroDivorcios);
						} 
						// Si la ciudad no estaba almacenada la insertamos
						else {
							Ciudad nueva = new Ciudad (nombre);
							ciudades.add(nueva);
							//Buscamos su posicion en el ArrayList
							int posicion = devolverPosicionCiudad(nombre);
							// Le sumamos el numero de divorcios
							ciudades.get(posicion).setContadorDivorciosTotales
								(ciudades.get(posicion).getContadorDivorciosTotales() 
										+ numeroDivorcios);
						}
					}
				}
				contador++;
			}
			f.close();
			System.out.println("En el año 2019 hubo un total de " + contadorConSeparacion2019
					+ " divorcios con separacion.");
			System.out.println("En el año 2018 hubo un total de " + contadorSinSeparacion2018
					+ " divorcios sin separacion.");
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
