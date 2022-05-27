package examenFinal;

import java.util.ArrayList;

public class Ciudad {
	// Atributos de la clase
	private String nombre;
	private ArrayList<DatosPorAnyo> datos = new ArrayList<DatosPorAnyo>();
	
	/**
	 * @param nombre
	 * @param datos
	 */
	public Ciudad(String nombre, ArrayList<DatosPorAnyo> datos) {
		super();
		this.nombre = nombre;
		this.datos = datos;
	}

	/**
	 * @param nombre
	 */
	public Ciudad(String nombre) {
		this.nombre = nombre;
	}
	// Metodos get y set
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<DatosPorAnyo> getDatos() {
		return datos;
	}
	
	public void setDatos(ArrayList<DatosPorAnyo> datos) {
		this.datos = datos;
	}
	
}
