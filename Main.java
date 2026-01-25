package Biblio;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
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
        	System.out.println("--- MENU BIBLIOTECA ---");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Agregar Socio");
            System.out.println("3. Prestar Libro");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Ver Libros Disponibles");
            System.out.println("6. Salir");     
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
            	case 1 -> {
                	System.out.println("--- NUEVO LIBRO ---");
                	System.out.print("Título: ");
                	String titulo = sc.nextLine();
                
                	System.out.print("Autor: ");
                	String autor = sc.nextLine();
                
                	System.out.print("ISBN: ");
                	String isbn = sc.nextLine();
                
                	System.out.print("Año: ");
                	int year = sc.nextInt();
                	sc.nextLine();
                
                	if (biblioteca.agregarLibro(new Libro(titulo, autor, isbn, year))) {
                    	System.out.println("Libro guardado.");
                	} else {
                		System.out.println("Error: Ya existe un libro con ese ISBN.");
                	}
                	break;
            	}
            	
            	case 2 -> {
                    System.out.println("--- NUEVO SOCIO ---");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();                    
                    System.out.print("Email: ");
                    String email = sc.nextLine();                   
                    int max = 3;                                     
                    Socio socio = new Socio(nombre, email, max);
                    if (biblioteca.agregarSocio(socio)) {
                        System.out.println("Socio guardado. Su ID es: " + socio.getId()); 
                    } else {
                        System.out.println("Error: Email duplicado.");
                    }
                    break;
            	}
            	case 3 -> {
                    System.out.println("--- PRESTAR LIBRO ---");
                    System.out.print("ID del Socio: ");
                    String idSocio = sc.nextLine();                  
                    System.out.print("ISBN del Libro: ");
                    String isbnPrestar = sc.nextLine();                 
                    System.out.println("Introduce Fecha de Inicio:");
                    System.out.print("Día: ");
                    int d = sc.nextInt();                    
                    System.out.print("Mes: ");
                    int m = sc.nextInt();                   
                    System.out.print("Año: ");
                    int a = sc.nextInt();                    
                    sc.nextLine();
                    Fecha fechaInicio = new Fecha(d, m, a);
                    System.out.println(biblioteca.prestarLibro(idSocio, isbnPrestar, fechaInicio));
                    break;
            	}
            	case 4 -> {
                    System.out.println("--- DEVOLVER LIBRO ---");
                    System.out.print("ISBN del Libro a devolver: ");
                    String isbnDev = sc.nextLine();                    
                    System.out.println("Introduce Fecha de Devolución:");
                    System.out.print("Día: ");
                    int d = sc.nextInt();                    
                    System.out.print("Mes: ");
                    int m = sc.nextInt();                   
                    System.out.print("Año: ");
                    int a = sc.nextInt();                    
                    sc.nextLine();
                    Fecha fechaFin = new Fecha(d, m, a);                   
                    System.out.println(biblioteca.devolverLibro(isbnDev, fechaFin));
                    break;
            	}
            	case 5 -> {
                    System.out.println("--- LIBROS DISPONIBLES ---");
                    for (Libro i : biblioteca.getLibrosDisponibles()) {
                        System.out.println(i);
                    }
                    break;
            	}
            	case 6 -> {
                    System.out.println("Fin");
                    break;
            	}
            }
            
        } while (opcion != 6);
	}
}