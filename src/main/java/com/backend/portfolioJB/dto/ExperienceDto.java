
package com.backend.portfolioJB.dto;

import javax.validation.constraints.NotBlank;


public class ExperienceDto {
    
    @NotBlank
    private String titulo;      
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fecha; 

    public ExperienceDto() {
    }

    public ExperienceDto(String titulo, String descripcion, String fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
