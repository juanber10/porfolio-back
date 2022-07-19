
package com.backend.portfolioJB.dto;

import javax.validation.constraints.NotBlank;


public class EducationsDto {
        
    @NotBlank
    private String titulo;      
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fecha_final;    
    @NotBlank
    private String estado;
    
    private String link;
    

    public EducationsDto() {
    }

    public EducationsDto(String titulo, String descripcion, String fecha_final, String estado, String link) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_final = fecha_final;
        this.estado = estado;
        this.link = link;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
