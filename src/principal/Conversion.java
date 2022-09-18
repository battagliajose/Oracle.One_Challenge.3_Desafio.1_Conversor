package principal;

public class Conversion {
	private String nombre;
	private double tasaDeCambio;
	
	public Conversion(String nombre, double tasa) {
		this.nombre = nombre;
		this.tasaDeCambio = tasa;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTasaDeCambio() {
		//Validar
		return tasaDeCambio;
	}
	public void setTasaDeCambio(double tasaDeCambio) {
		//Validar
		this.tasaDeCambio = tasaDeCambio;
	}
}
