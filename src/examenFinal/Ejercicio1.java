package examenFinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio1 {
	
	/*
	 * Muestra por pantalla todas aquellas palabras del fichero que tengan mas de 3
	 * vocales.
	 */
	static String ruta = "C:\\Users\\Nerea\\Desktop\\HablanosDelDon.txt";

	public static void main(String[] args) throws Exception {
		File fichero = new File(ruta);
		leerFichero(fichero, 'o');
	}

	public static void leerFichero(File fichero, char letra) throws Exception {
		Connection connect = null;
		Statement statement = null;
		String host = "localhost:3306/examen";
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
		

	}
	
}
