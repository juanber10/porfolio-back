
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
    
    private String linkCert;
    

    public EducationsDto() {
    }

    public EducationsDto(String titulo, String descripcion, String fecha_final, String estado, String linkCert) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_final = fecha_final;
        this.estado = estado;
        this.linkCert = linkCert;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLinkCert() {
        return linkCert;
    }

    public void setLinkCert(String linkCert) {
        this.linkCert = linkCert;
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
