package com.alura.literalura;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class LibroResponse {

    @JsonProperty("results")
    private List<LibroDTO> results;

    // Getters y Setters
    public List<LibroDTO> getResults() {
        return results;
    }

    public void setResults(List<LibroDTO> results) {
        this.results = results;
    }

    // Método para convertir la respuesta a una lista de Libros
    public List<Libros> toLibrosList() {
        return results.stream()
                .map(LibroDTO::toLibros)
                .toList();
    }
}
