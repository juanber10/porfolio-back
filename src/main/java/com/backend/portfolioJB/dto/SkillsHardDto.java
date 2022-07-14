
package com.backend.portfolioJB.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class SkillsHardDto {
    
    @NotBlank
    private String nombre;
    @Min(0)@Max(100)
    private int valor;
    
    @NotBlank
    private String color_barra; 
    
      
    private String icons;     
   

    public SkillsHardDto() {
    }

    public SkillsHardDto(String nombre, int valor, String color_barra, String icons) {
        this.nombre = nombre;
        this.valor = valor;
        this.color_barra = color_barra;
      
        this.icons = icons;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getColor_barra() {
        return color_barra;
    }

    public void setColor_barra(String color_barra) {
        this.color_barra = color_barra;
    }


    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

       
}
