package modelo;

public class NodoLibro {
	private Libro libro;
    private NodoLibro izquierdo;
    private NodoLibro derecho;
    
    public NodoLibro(Libro libro) {
        this.libro = libro;
    }
    
    public Libro getLibro() {
        return libro;
    }

    public NodoLibro getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoLibro izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoLibro getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoLibro derecho) {
        this.derecho = derecho;
    }

}
