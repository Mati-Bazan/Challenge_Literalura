package com.alura.literalura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public LibroService(LibroRepository libroRepository, RestTemplate restTemplate) {
        this.libroRepository = libroRepository;
        this.restTemplate = restTemplate;
    }

    public void guardarLibrosPorNombre(String nombre) {
        LibroResponse response = restTemplate.getForObject(
                "https://gutendex.com/books?search=" + nombre, LibroResponse.class);
        if (response != null) {
            response.getResults().forEach(libroDTO -> {
                Libros libro = new Libros();
                libro.setTitulo(libroDTO.getTitle());
                libro.setAutor(libroDTO.getAuthors().get(0).getName());
                libro.setIdioma(libroDTO.getLanguages().get(0));
                libro.setDescargas(libroDTO.getDownloadCount());
                libroRepository.save(libro);
            });
        }
    }

    public List<Libros> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public List<Libros> buscarPorNombre(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Libros> buscarPorAutor(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    public List<Libros> buscarPorIdioma(String idioma) {
        return libroRepository.findByIdiomaContainingIgnoreCase(idioma);
    }
}

