package modelo;

public class Complejidad {
	private String nombre;
	private double valor;
	
	public Complejidad(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	public double getValor(){
		return valor;
	}
	
	@Override
	public String toString() {
		return nombre + " = " + valor;
	}

}




