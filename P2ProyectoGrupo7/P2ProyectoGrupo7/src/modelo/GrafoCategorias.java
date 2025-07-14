package modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class GrafoCategorias {
	private Map<String, LinkedList<String>> adyacencias = new HashMap<>();
	
	public void agregarCategoria(String categoria) {
		adyacencias.putIfAbsent(categoria, new LinkedList<>());
		
	}
	
	public void agregarRelacion(String cat1, String cat2) {
		adyacencias.get(cat1).add(cat2);
		adyacencias.get(cat2).add(cat1);
	}
	
	public LinkedList<String> obtenerRelacionadas(String categoria){
		return adyacencias.getOrDefault(categoria, new LinkedList<>());
	}
	
	public Set<String> obtenerCategorias(){
		return adyacencias.keySet();
	}
}
