package Biblio;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Interfaz {

	Scanner sc = new Scanner(System.in);

    public Interfaz() {
        this.sc = new Scanner(System.in);
    }

    public int pedirEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                numero = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        return numero;
    }

    public String pedirTexto(String texto) {
        System.out.print(texto);
        return sc.nextLine();
    }

    public int mostrarMenuPrincipal() {
        System.out.println("--- MENU BIBLIOTECA ---");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Agregar Socio");
        System.out.println("3. Prestar Libro");
        System.out.println("4. Devolver Libro");
        System.out.println("5. Ver Libros Disponibles");
        System.out.println("6. Salir");
        return pedirEntero("Elige una opción: ");
    }

    public Libro pedirDatosLibro() {
        System.out.println("--- NUEVO LIBRO ---");
        String titulo = pedirTexto("Título: ");
        String autor = pedirTexto("Autor: ");
        String isbn = pedirTexto("ISBN: ");
        int year = pedirEntero("Año: ");
        return new Libro(titulo, autor, isbn, year);
    }

    public Socio pedirDatosSocio() {
        System.out.println("--- NUEVO SOCIO ---");
        String nombre = pedirTexto("Nombre: ");
        String email = pedirTexto("Email: ");
        return new Socio(nombre, email, 3);
    }

    public Fecha pedirFecha(String tipoFecha) {
        System.out.println("Introduce Fecha de " + tipoFecha + ":");
        int d = pedirEntero("Día: ");
        int m = pedirEntero("Mes: ");
        int a = pedirEntero("Año: ");
        return new Fecha(d, m, a);
    }
    
    public void mostrarTexto(String msg) {
        System.out.println(msg);
    }

    public void mostrarLibros(List<Libro> libros) {
        System.out.println("--- LIBROS DISPONIBLES ---");
        if (libros.isEmpty()) {
            System.out.println("(No hay libros disponibles)");
        } else {
            for (Libro l : libros) {
                System.out.println(l);
            }
        }
    }
}