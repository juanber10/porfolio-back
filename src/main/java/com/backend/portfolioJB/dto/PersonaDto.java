
package com.backend.portfolioJB.dto;
import javax.validation.constraints.NotBlank;

public class PersonaDto {
    
     @NotBlank
    private String nombre;
   
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    
    private String urlimg;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String titulo, String descripcion, String urlimg) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlimg = urlimg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }
    
    
    
}
