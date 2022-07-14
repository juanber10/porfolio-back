
package com.backend.portfolioJB.dto;

import javax.validation.constraints.NotBlank;


public class SkillPersonalDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String color_barra; 

    public SkillPersonalDto() {
    }

    public SkillPersonalDto(String nombre, String color_barra) {
        this.nombre = nombre;
        this.color_barra = color_barra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor_barra() {
        return color_barra;
    }

    public void setColor_barra(String color_barra) {
        this.color_barra = color_barra;
    }
    
    
    
}
