package modelo;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioLibros {
	private NodoLibro raiz;
	
	 public void insertar(Libro libro) {
	        raiz = insertarRec(raiz, libro);
	 }
	 
	 private NodoLibro insertarRec(NodoLibro actual, Libro libro) {
		 if (actual == null) {
			 return new NodoLibro(libro);
	     }
	     if (libro.getTitulo().compareToIgnoreCase(actual.getLibro().getTitulo()) < 0) {
	    	 actual.setIzquierdo(insertarRec(actual.getIzquierdo(), libro));
	     } else {
	         actual.setDerecho(insertarRec(actual.getDerecho(), libro));
	     }
	     return actual;
	 }
	 
	 public List<Libro> inOrden() {
		 List<Libro> resultado = new ArrayList<>();
	     inOrdenRec(raiz, resultado);
	     return resultado;
	 }
	 
	 private void inOrdenRec(NodoLibro nodo, List<Libro> lista) {
		 if (nodo != null) {
			 inOrdenRec(nodo.getIzquierdo(), lista);
	         lista.add(nodo.getLibro());
	         inOrdenRec(nodo.getDerecho(), lista);
	     }
	 }
	 
	 public List<Libro> preOrden() {
		 List<Libro> resultado = new ArrayList<>();
	     preOrdenRec(raiz, resultado);
	     return resultado;
	 }
	 
	 private void preOrdenRec(NodoLibro nodo, List<Libro> lista) {
		 if (nodo != null) {
			 lista.add(nodo.getLibro());
	         preOrdenRec(nodo.getIzquierdo(), lista);
	         preOrdenRec(nodo.getDerecho(), lista);
	     }
	 }
	 
	 public List<Libro> postOrden() {
		 List<Libro> resultado = new ArrayList<>();
		 postOrdenRec(raiz, resultado);
	     return resultado;
	 }
	 
	 private void postOrdenRec(NodoLibro nodo, List<Libro> lista) {
		 if (nodo != null) {
			 postOrdenRec(nodo.getIzquierdo(), lista);
	         postOrdenRec(nodo.getDerecho(), lista);
	         lista.add(nodo.getLibro());
	     }
	 }
	 

}
