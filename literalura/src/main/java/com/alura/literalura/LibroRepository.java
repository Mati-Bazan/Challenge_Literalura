package com.alura.literalura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libros, Long> {
    List<Libros> findByTituloContainingIgnoreCase(String titulo);
    List<Libros> findByAutorContainingIgnoreCase(String autor);
    List<Libros> findByIdiomaContainingIgnoreCase(String idioma);
}