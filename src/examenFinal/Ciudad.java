package examenFinal;

public class Ciudad {
	// Atributos de la clase
	private String nombre;
	private int contadorDivorciosTotales;
	
	

	/**
	 * @param nombre
	 */
	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * @param nombre
	 * @param contadorDivorciosTotales
	 */
	public Ciudad(String nombre, int contadorDivorciosTotales) {
		super();
		this.nombre = nombre;
		this.contadorDivorciosTotales = contadorDivorciosTotales;
	}

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
		return "Ciudad [nombre=" + nombre + ", contadorDivorciosTotales=" + contadorDivorciosTotales + "]";
	}

}
