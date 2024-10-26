package com.alura.literalura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsolaLibroRunner implements CommandLineRunner {

    private final LibroService libroService;

    @Autowired
    public ConsolaLibroRunner(LibroService libroService) {
        this.libroService = libroService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro que desea buscar: ");
        String titulo = scanner.nextLine();

        System.out.println("Buscando libros con el título: " + titulo);
        List<Libros> librosGuardados = libroService.buscarYGuardarLibrosPorTitulo(titulo);

        if (!librosGuardados.isEmpty()) {
            System.out.println("Libros guardados exitosamente en la base de datos:");
            librosGuardados.forEach(libro -> System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()));
        } else {
            System.out.println("No se encontraron libros con el título ingresado.");
        }
    }
}
