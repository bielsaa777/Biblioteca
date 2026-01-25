package Biblio;

public class Libro {
	
	private boolean disponible;
	private String isbn;
	private String titulo;
	private String autor;
	private int year;
	
	public Libro(String titulo, String autor, String isbn, int year) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.year = year;
		this.disponible = true;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getYear() {
		return year;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public String toString() {
		String estado = "";
		if (this.disponible) {
			estado = "Disponible";
		} else {
			estado = "No disponible";
		}		
		return "Libro: " + titulo + " - Autor: " + autor + " - ISBN: " + isbn + " - Año: " + year + " - Estado: " + estado;		
	}
}
