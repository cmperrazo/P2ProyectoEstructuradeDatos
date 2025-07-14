package modelo;

public class Libro {
	private String titulo;
	private String autor;
	private int anio;
	private String categoria;
	
	public Libro(String titulo, String autor, int anio, String categoria) {
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;}
	public void setTitulo(String titulo) {
		this.titulo = titulo;}
	public String getAutor() {
		return autor;}
	public void setAutor(String autor) {
		this.autor = autor;}
	public int getAnio() {
		return anio;}
	public void setAnio(int anio) {
		this.anio = anio;}
	public String getCategoria() {
		return categoria;}
	public void setCategoria(String categoria) {
		this.categoria = categoria;}
	
	@Override
	public String toString() {
		return titulo + " - " + autor + " (" + anio + ") [" + categoria + "]";
	}
	
	

}
