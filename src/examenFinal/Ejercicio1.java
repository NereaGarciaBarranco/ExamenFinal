package examenFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

/**
* Esta clase ejecuta un programa que se encarga de extraer linea
* por linea de un fichero, para encontrar las palabras 
* 
* @Author Nerea Garcia Barranco
*/

public class Ejercicio1 {
	
	// Creacion de los objetos estaticos necesarios para la clase
	static String ruta = "C:\\Users\\Nerea\\Desktop\\HablanosDelDon.txt";
	
	/**
	 * Pre: ---
	 * Post: Este programa llama a un metodo que se encarga de analizar la 
	 * informacion de un fichero de texto. Muestra por pantalla las palabras 
	 * que empiezan o terminan por una letra en concreto y al lado aparece
	 * la linea en la que se encuentra dicha palabra. Ademas, se encarga
	 * de guardarlo en una BD para que el algoritmo sea persistente.
	 */
	public static void main(String[] args) throws Exception {
		// Creamos el fichero
		File fichero = new File(ruta);
		leerFichero(fichero, 'a');
	}
	
	/**
	 * Pre: ---
	 * Post: Este metodo recibe como parametro un fichero y una letra.
	 * Se encarga de leer linea por linea ese fichero buscando palabras
	 * que comiencen o acaben por dicha letra. Tambien se encarga de 
	 * hacer conexion con una BD y hacer los insert de dichas palabras.
	 */
	public static void leerFichero(File fichero, char letra) throws Exception {
		// Establecemos la conexion con la BD
		Connection connect = null;
		Statement statement = null;
		String host = "localhost:3306/examenProgramacion";
		String user = "root";
		String passwd = "sgz7MHM8@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host 
					+ "?user=" + user + "&password=" + passwd);
			statement = connect.createStatement();
		} catch (Exception e) {
			throw e; 
		}
		// Vamos leyendo el fichero
		try {
			// Le asociamos un objeto de tipo Scanner para leerlo
			Scanner f = new Scanner(fichero);
			// Este contador nos sirve para saber en que linea esta cada palabra
			int contadorLinea = 1;
			// Mientras el fichero tenga linea
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				/*
				 * Limpiamos todas las lineas de caracteres especiales
				 * y ponemos todas las letras minusculas para poder
				 * coger las palabras tal cual. Tambien quitamos los
				 * acentos.
				 */
				linea = linea.toLowerCase();
				linea = linea.replaceAll(",", "").replaceAll("\\.", "")
				.replaceAll(";", "").replaceAll("¿", "")
				.replaceAll("\\?", "").replaceAll("\\“", "")
				.replaceAll(":", "").replaceAll("á", "a")
				.replaceAll("é", "e").replaceAll("í", "i")
				.replaceAll("ó", "o").replaceAll("ú", "u");				
				// Obtenemos las palabras de cada linea separandola por espacios
				String[] datos = linea.split(" ");
				// Recorremos la linea
				for (int i = 0; i < datos.length; i++) {
					// Cogemos la primera y ultima letra de cada palanra
					char primeraLetra = datos[i].charAt(0);
					char ultimaLetra = datos[i].charAt(datos[i].length()-1);
					// Si alguna de las dos es igual a la letra pasada por parametro
					if (primeraLetra == letra || ultimaLetra == letra) {
						// Lo mostramos por consola
						System.out.println(datos[i] + " linea " + contadorLinea);
						/*
						 *  Hacemos el insert en la BD:
						 *  Letra (letra)
						 *  Palabra (datos[i])
						 *  Linea (contadorLinea)
						 */					
						try {
							PreparedStatement preparedStatement = connect
									.prepareStatement("insert into palabras(letra, palabra, linea) "
											+ "values (?, ?, ?)");
							preparedStatement.setString(1, Character.toString(letra));
							preparedStatement.setString(2, datos[i]);
							preparedStatement.setInt(3, contadorLinea);
							// Ejecutamos el insert
							preparedStatement.executeUpdate();
							}
						catch (Exception e) {
							throw e;
						}
					}
				}
				contadorLinea++;
			}
			f.close();
			// Cerramos la conexion con la BD
			try {
				statement.close();
				connect.close();
			} catch (Exception e) {
				throw e;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido acceder al fichero.");
			e.printStackTrace();
		}
	}	
}
