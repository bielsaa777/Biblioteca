package Biblio;

public class Prestamo {
	
	private int contador = 1;
	private String idPrestamo;
	private Socio socio;      
	private Libro libro;      
	private Fecha fechaInicio;
	private Fecha fechaFin;
	
	public Prestamo(Socio socio, Libro libro, Fecha fechaInicio) {
		this.idPrestamo = "P-" + contador;
		this.socio = socio;
		this.libro = libro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = null;
	}
	
	public String getIdPrestamo() {
		return idPrestamo;
	}
	
	public Socio getSocio() {
		return socio;
	}
	
	public Libro getLibro() {
		return libro;
	}
	
	public Fecha getFechaInicio() {
		return fechaInicio;
	}
	
	public Fecha getFechaFin() {
		return fechaFin;
	}
	
	public void devolverLibro(Fecha fechaDevolucion) {
		this.fechaFin = fechaDevolucion;
	}
	
	public boolean prestamoActivo() {
		return this.fechaFin == null;
	}
	
	public String toString() {
		String estado = "";
		if (this.prestamoActivo()) {
			estado = "Activo";
		} else {
			estado = "Devuelto el " + this.fechaFin;
		}		
		return "-- PRESTAMO --\n" + 
				"ID: " + idPrestamo + "\n" +
				"Socio: " + socio + "\n" +
				"Libro: " + libro + "\n" +
				"Desde: " + fechaInicio + "\n" +
				"Estado: " + estado;
	}	
}