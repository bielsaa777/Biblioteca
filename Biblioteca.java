package Biblio;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private List<Libro> libros;
	private List<Socio> socios;
	private List<Prestamo> prestamos;
	
	public Biblioteca() {
		
		this.libros = new ArrayList<>();
		this.socios = new ArrayList<>();
		this.prestamos = new ArrayList<>();
		
	}
	
	public boolean agregarLibro(Libro nuevoLibro) {
		for (Libro i : this.libros) {
			if (i.getIsbn().equals(nuevoLibro.getIsbn())) {
				return false;
			}
		}
		this.libros.add(nuevoLibro);
		return true;
	}
	
	public boolean agregarSocio(Socio nuevoSocio) {
		for (Socio i : this.socios) {
			if (i.getEmail().equals(nuevoSocio.getEmail())) {
				return false;
			}
		}
		int siguienteNumero = this.socios.size() + 1;
		String idGenerado = "S-" + siguienteNumero;
		nuevoSocio.setId(idGenerado);
		this.socios.add(nuevoSocio);
		return true;
	}
	
	public String prestarLibro(String idSocio, String isbn, Fecha fechaInicio) {
		Socio socioEncontrado = null;
		for (Socio i : this.socios) {
			if (i.getId().equals(idSocio)) {
				socioEncontrado = i;
				break;
			}
		}
		
		if (socioEncontrado == null) {
			return "Error: El socio con ID " + idSocio + " no existe.";
		}
		
		Libro libroEncontrado = null;
		for (Libro i : this.libros) {
			if (i.getIsbn().equals(isbn)) {
				libroEncontrado = i;
				break;
			}
		}
		
		if (libroEncontrado == null) {
			return "Error: El libro con ISBN " + isbn + " no existe.";
		}
		
		if (!libroEncontrado.getDisponible()) {
			return "Error: El libro no está disponible.";
		}
		
		if (socioEncontrado.getNumPrestamos() >= socioEncontrado.getMaxPrestamos()) {
			return "Error: El socio ha alcanzado su límite de préstamos";
		}
		
		Prestamo nuevoPrestamo = new Prestamo(socioEncontrado, libroEncontrado, fechaInicio);		
		this.prestamos.add(nuevoPrestamo);
		libroEncontrado.setDisponible(false);
		socioEncontrado.setNumPrestamos(socioEncontrado.getNumPrestamos() + 1);

		return "Préstamo realizado. ID: " + nuevoPrestamo.getIdPrestamo();
	}
	
	public String devolverLibro(String isbn, Fecha fechaDevolucion) {
		Libro libro = null;
		for (Libro i : this.libros) {
			if (i.getIsbn().equals(isbn)) {
				libro = i;
				break;
			}
		}
		if (libro == null) {
			return "Error: Libro no encontrado.";
		}
		if (libro.getDisponible()) {
			return "Error: Ese libro no está prestado.";
		}
		Prestamo prestamoActivo = null;
		for (Prestamo i : this.prestamos) {
			if (i.getLibro().getIsbn().equals(isbn) && i.prestamoActivo()) {
				prestamoActivo = i;
				break;
			}
		}
		if (prestamoActivo == null) {
			return "Error: El libro no está prestado ahora mismo.";
		}
		prestamoActivo.devolverLibro(fechaDevolucion);
		libro.setDisponible(true);
		Socio socio = prestamoActivo.getSocio();
		socio.setNumPrestamos(socio.getNumPrestamos() - 1);
		return "Devolución completada para el libro " + libro.getTitulo();
	}
	
	public List<Libro> getLibrosDisponibles() {
		List<Libro> listaResultado = new ArrayList<>();
		
		for (Libro i : this.libros) {
			if (i.getDisponible()) {
				listaResultado.add(i);
			}
		}		
		return listaResultado;
	}
	
	public List<Libro> getLibros() {
		return libros;
	}
	
	public List<Socio> getSocios() {
		return socios;
	}
	
	public List<Prestamo> getPrestamosActivos() {
		List<Prestamo> activos = new ArrayList<>();
		for (Prestamo p : this.prestamos) {
			if (p.prestamoActivo()) {
				activos.add(p);
			}
		}
		return activos;
	}
	
	public List<Prestamo> getPrestamosDeSocio(String idSocio) {
		List<Prestamo> historial = new ArrayList<>();
		for (Prestamo p : this.prestamos) {
			if (p.getSocio().getId().equals(idSocio)) {
				historial.add(p);
			}
		}
		return historial;
	}
}