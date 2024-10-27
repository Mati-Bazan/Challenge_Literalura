package com.alura.literalura;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsolaLibroRunner implements CommandLineRunner {

    private final LibroService libroService;

    public ConsolaLibroRunner(LibroService libroService) {
        this.libroService = libroService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1 - Agregar libro");
            System.out.println("2 - Listar libros");
            System.out.println("3 - Buscar libro por nombre");
            System.out.println("4 - Buscar libros por nombre de autor");
            System.out.println("5 - Buscar libro por idioma");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del libro a agregar: ");
                    String nombre = scanner.nextLine();
                    libroService.guardarLibrosPorNombre(nombre);
                    System.out.println("Libros agregados a la base de datos.");
                    break;
                case 2:
                    List<Libros> todosLibros = libroService.obtenerTodosLosLibros();
                    System.out.println("Listado de libros guardados:");
                    todosLibros.forEach(libro ->
                            System.out.println(libro.getTitulo() + " - " + libro.getAutor()));
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del libro a buscar: ");
                    String titulo = scanner.nextLine();
                    libroService.buscarPorNombre(titulo).forEach(libro ->
                            System.out.println(libro.getTitulo() + " - " + libro.getAutor()));
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del autor: ");
                    String autor = scanner.nextLine();
                    libroService.buscarPorAutor(autor).forEach(libro ->
                            System.out.println(libro.getTitulo() + " - " + libro.getAutor()));
                    break;
                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String idioma = scanner.nextLine();
                    libroService.buscarPorIdioma(idioma).forEach(libro ->
                            System.out.println(libro.getTitulo() + " - " + libro.getIdioma()));
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
            }
        }
        scanner.close();
    }
}

