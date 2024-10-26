package com.alura.literalura;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LibroService {

    private final RestTemplate restTemplate;
    private final LibroRepository libroRepository;

    public LibroService(RestTemplate restTemplate, LibroRepository libroRepository) {
        this.restTemplate = restTemplate;
        this.libroRepository = libroRepository;
    }

    // Método para buscar y guardar libros usando el título como filtro
    public List<Libros> buscarYGuardarLibrosPorTitulo(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo;
        LibroResponse response = restTemplate.getForObject(url, LibroResponse.class);
        if (response != null) {
            List<Libros> libros = response.toLibrosList();
            return libroRepository.saveAll(libros);
        }
        return List.of();
    }
}
