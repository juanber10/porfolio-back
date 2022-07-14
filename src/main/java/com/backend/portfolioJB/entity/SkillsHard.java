
package com.backend.portfolioJB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SkillsHard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")    
    private String nombre;    
           
    @Column(name = "valor")
    private int valor;
    
    @Column(name = "color_barra")    
    private String color_barra; 
    
 
    
    @Column(name = "icono")    
    private String icons; 
    
    

    public SkillsHard() {
    }

    public SkillsHard(String nombre, int valor, String color_barra,String icons) {
        this.nombre = nombre;
        this.valor = valor;
        this.color_barra = color_barra;
     
        this.icons = icons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
