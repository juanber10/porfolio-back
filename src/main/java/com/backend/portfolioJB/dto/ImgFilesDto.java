
package com.backend.portfolioJB.dto;

import javax.validation.constraints.NotBlank;

public class ImgFilesDto {
    @NotBlank
    private String nombre;      
    @NotBlank
    private String origen;
    @NotBlank
    private String linkimg;

    public ImgFilesDto() {
    }

    public ImgFilesDto(String nombre, String origen, String linkimg) {
        this.nombre = nombre;
        this.origen = origen;
        this.linkimg = linkimg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(String linkimg) {
        this.linkimg = linkimg;
    }
    
    
    
}
