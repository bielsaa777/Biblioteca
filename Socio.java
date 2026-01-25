package Biblio;

public class Socio {
	
	private String id;
	private String nombre;
	private String email;
	private int numPrestamos;
	private int maxPrestamos;
	
	public Socio(String nombre, String email, int maxPrestamos) {
		this.id = null;
		this.nombre = nombre;
		this.email = email;
		this.numPrestamos = 0;
		this.maxPrestamos = maxPrestamos;
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getNumPrestamos() {
		return numPrestamos;
	}
	
	public int getMaxPrestamos() {
		return maxPrestamos;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setId(String id) {
        this.id = id;
    }

	public void setNumPrestamos(int numPrestamos) {
		this.numPrestamos = numPrestamos;
	}
	
	public String toString() {
		return "Socio: " + nombre + " - ID: " + id + " - Email: " + email + " - Prestamos actuales: " + numPrestamos + "/" + maxPrestamos;
	}
}