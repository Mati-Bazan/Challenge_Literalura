package com.alura.literalura;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LibroDTO {

    private String title;
    private List<Autor> authors;
    private List<String> languages;

    @JsonProperty("download_count")
    private int downloadCount;

    // Getters y Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    // Método para convertir LibroDTO a Libros
    public Libros toLibros() {
        Libros libro = new Libros();
        libro.setTitulo(this.title);
        libro.setAutor(this.authors.isEmpty() ? "Desconocido" : this.authors.get(0).getName());
        libro.setIdioma(this.languages.isEmpty() ? "Desconocido" : this.languages.get(0));
        libro.setDescargas(this.downloadCount);
        return libro;
    }
}
