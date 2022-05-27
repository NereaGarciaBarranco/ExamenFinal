package examenFinal;

/**
 * Esta clase crea objetos de tipo Ciudad que se utilizan
 * para almacenar las distintas ciudades que aparecen 
 * en un fichero. Ademas, junto al nombre de la ciudad
 * se almacena un contador de divorcios.
 *
 */

public class Ciudad implements Comparable <Ciudad>{
	// Atributos de la clase
	private String nombre;
	private int contadorDivorciosTotales;
	
	// Metodos constructores
	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Ciudad(String nombre, int contadorDivorciosTotales) {
		super();
		this.nombre = nombre;
		this.contadorDivorciosTotales = contadorDivorciosTotales;
	}

	// Metodos get y set
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre; 
	}
	
	public int getContadorDivorciosTotales() {
		return contadorDivorciosTotales;
	}
	
	public void setContadorDivorciosTotales(int contadorDivorciosTotales) {
		this.contadorDivorciosTotales = contadorDivorciosTotales;
	}
	
	@Override
	public String toString() {
		return "Ciudad [nombre = " + nombre + ", contadorDivorciosTotales = " 
				+ contadorDivorciosTotales + "]";
	}
	
	@Override
	public int compareTo(Ciudad c) {
		if (this.contadorDivorciosTotales > c.contadorDivorciosTotales) {
			return -1;
		} else if (this.contadorDivorciosTotales < c.contadorDivorciosTotales) {
			return 1;
		} else {
			// Si son iguales
			return 0;
		}	
	}
}
