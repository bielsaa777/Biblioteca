package Biblio;

public class Main {
	
	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
		Interfaz interfaz = new Interfaz();
        int opcion = 0;
        
        biblioteca.agregarLibro(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "1111", 1605));
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "2222", 1967));
        biblioteca.agregarLibro(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", "3333", 1954));
        biblioteca.agregarLibro(new Libro("1984", "George Orwell", "4444", 1949));
        biblioteca.agregarLibro(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "5555", 1997));
        biblioteca.agregarLibro(new Libro("El Código Da Vinci", "Dan Brown", "6666", 2003));
        
        biblioteca.agregarSocio(new Socio("Pablo", "pablo@gmail.com", 1));
        biblioteca.agregarSocio(new Socio("David", "david@hotmail.com", 2));
        biblioteca.agregarSocio(new Socio("Nico", "nico@hotmail.com", 3));
        
        biblioteca.prestarLibro("S-1", "1111", new Fecha(1, 2, 2024));
        biblioteca.prestarLibro("S-2", "3333", new Fecha(5, 2, 2024));
        
        do {
            	
        	opcion = interfaz.mostrarMenuPrincipal();
                
            switch (opcion) {
            	case 1 -> {
                		
            		Libro nuevoLibro = interfaz.pedirDatosLibro();
                    if (biblioteca.agregarLibro(nuevoLibro)) {
                       	interfaz.mostrarTexto("Libro guardado.");
                    } else {
                    	interfaz.mostrarTexto("Error: Ya existe un libro con ese ISBN.");
                    }
                }
                	
                case 2 -> {
                    Socio nuevoSocio = interfaz.pedirDatosSocio();
                    if (biblioteca.agregarSocio(nuevoSocio)) {
                        interfaz.mostrarTexto("Socio guardado. Su ID es: " + nuevoSocio.getId()); 
                    } else {
                        interfaz.mostrarTexto("Error: Email duplicado.");
                    }
                }
                	
                case 3 -> {
                    interfaz.mostrarTexto("--- PRESTAR LIBRO ---");
                    String idSocio = interfaz.pedirTexto("ID del Socio: ");                  
                    String isbnPrestar = interfaz.pedirTexto("ISBN del Libro: ");                 
                    
                    Fecha fechaInicio = interfaz.pedirFecha("Inicio");
                        
                    String resultado = biblioteca.prestarLibro(idSocio, isbnPrestar, fechaInicio);
                    interfaz.mostrarTexto(resultado);
            	}
                	
            	case 4 -> {
                    interfaz.mostrarTexto("--- DEVOLVER LIBRO ---");
                    String isbnDev = interfaz.pedirTexto("ISBN del Libro a devolver: ");                    
                       
                    Fecha fechaFin = interfaz.pedirFecha("Devolución");                   
                        
                    String resultado = biblioteca.devolverLibro(isbnDev, fechaFin);
                    interfaz.mostrarTexto(resultado);
            	}
                	
              	case 5 -> {
                    interfaz.mostrarLibros(biblioteca.getLibrosDisponibles());
            	}
                	
                case 6 -> {
                        interfaz.mostrarTexto("Fin.");
               	}
                	
               	default -> {
               		interfaz.mostrarTexto("Opción no reconocida. Inténtalo de nuevo.");
               	}
            }
            
        } while (opcion != 6);
	}

}