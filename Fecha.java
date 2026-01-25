package Biblio;

public class Fecha {

	private int dia;
	private int mes;
	private int year;
	
	public Fecha(int dia, int mes, int year) {
		this.setDia(dia);
		this.setMes(mes);
		this.setYear(year);		
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setDia(int nuevoDia) {
		if(nuevoDia > 31 || nuevoDia < 1) return;
		this.dia = nuevoDia;
	}
	
	public void setMes(int nuevoMes) {
		if(nuevoMes > 12 || nuevoMes < 1) return;
		this.mes = nuevoMes;
	}
	
	public void setYear(int nuevoYear) {
		this.year = nuevoYear;
	}
	
	public String toString() {
		return this.getDia() + "/" + this.getMes() + "/" + this.getYear();
	}	
}