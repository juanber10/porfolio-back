
package com.backend.portfolioJB.dto;

import javax.validation.constraints.NotBlank;


public class WorksDto {
    
    @NotBlank  
    private String titulo;    
              
    @NotBlank 
    private String subtitulo;  
    
    @NotBlank   
    private String descripcion;  
    
    @NotBlank    
    private String origen; 
    
    
    private String linkImagen;
    
    private String linkProyectos; 

    public WorksDto() {
    }

    public WorksDto(String titulo, String subtitulo, String descripcion, String origen, String linkImagen, String linkProyectos) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
        this.origen = origen;
        this.linkImagen = linkImagen;
        this.linkProyectos = linkProyectos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getLinkProyectos() {
        return linkProyectos;
    }

    public void setLinkProyectos(String linkProyectos) {
        this.linkProyectos = linkProyectos;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }
    
    
    
}
