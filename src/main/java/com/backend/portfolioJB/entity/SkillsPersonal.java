
package com.backend.portfolioJB.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SkillsPersonal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")    
    private String nombre;    
              
    @Column(name = "color_barra")    
    private String color_barra;  

    public SkillsPersonal() {
    }

    public SkillsPersonal(String nombre, String color_barra) {
        this.nombre = nombre;
        this.color_barra = color_barra;
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

    public String getColor_barra() {
        return color_barra;
    }

    public void setColor_barra(String color_barra) {
        this.color_barra = color_barra;
    }
    
    

    
}
