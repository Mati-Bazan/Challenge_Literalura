package com.alura.literalura;
import java.util.List;

public class GutenbergResponse {
    private List<Libros> results;

    // Getters y Setters
    public List<Libros> getResults() {
        return results;
    }

    public void setResults(List<Libros> results) {
        this.results = results;
    }
}
