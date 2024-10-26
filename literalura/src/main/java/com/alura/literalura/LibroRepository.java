package com.alura.literalura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libros, Long> {
    // Aquí puedes definir métodos de consulta personalizados si los necesitas.
}
