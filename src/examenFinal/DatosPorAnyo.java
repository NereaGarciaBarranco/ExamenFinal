package examenFinal;

public class DatosPorAnyo {
	// Atributos de la clase 
	private int anyo;
	private int divorciosConSeparacion;
	private int divorciosSinSeparacion;

	/**
	 * @param anyo
	 * @param divorciosConSeparacion
	 * @param divorciosSinSeparacion
	 */
	public DatosPorAnyo(int anyo, int divorciosConSeparacion, int divorciosSinSeparacion) {
		this.anyo = anyo;
		this.divorciosConSeparacion = divorciosConSeparacion;
		this.divorciosSinSeparacion = divorciosSinSeparacion;
	}
	
	public DatosPorAnyo(int anyo, int divorciosConSeparacion) {
		
	}
	
	// Metodos get y set
	public int getAnyo() {
		return anyo;
	}
	
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	public int getDivorciosConSeparacion() {
		return divorciosConSeparacion;
	}
	
	public void setDivorciosConSeparacion(int divorciosConSeparacion) {
		this.divorciosConSeparacion = divorciosConSeparacion;
	}
	
	public int getDivorciosSinSeparacion() {
		return divorciosSinSeparacion;
	}
	
	public void setDivorciosSinSeparacion(int divorciosSinSeparacion) {
		this.divorciosSinSeparacion = divorciosSinSeparacion;
	}

	@Override
	public String toString() {
		return "[anyo=" + anyo + ", divorciosConSeparacion=" + divorciosConSeparacion
				+ ", divorciosSinSeparacion=" + divorciosSinSeparacion + "]";
	}
	
}
