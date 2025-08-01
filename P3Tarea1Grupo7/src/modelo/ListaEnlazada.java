package modelo;

public class ListaEnlazada {
	private Nodo cabeza;
	private int tamanio;
	
	public ListaEnlazada() {
		this.cabeza = null;
		this.tamanio = 0;
	}
	public boolean isEmpty() {
		return cabeza == null;
	}
	public void agregar(Object dato) {
		Nodo nuevoNodo = new Nodo(dato);
		if(isEmpty()) {
			cabeza = nuevoNodo;
		}else {
			Nodo actual = cabeza;
			while (actual.getSiguiente()!= null) {
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(nuevoNodo);
		}
		tamanio++;
	}
	public int getTamanio() {
		return tamanio;		
	}
	public Nodo getCabeza() {
		return cabeza;
	}

}


