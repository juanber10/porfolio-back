
package com.backend.portfolioJB.dto;

import javax.validation.constraints.NotBlank;


public class EducationsDto {
        
    @NotBlank
    private String titulo;      
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fecha_final;

    public EducationsDto() {
    }

    public EducationsDto(@NotBlank String titulo,  @NotBlank String descripcion,  @NotBlank String fecha_final) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_final = fecha_final;
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

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
       
}
