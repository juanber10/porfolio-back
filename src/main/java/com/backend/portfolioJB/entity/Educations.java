package com.backend.portfolioJB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Educations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "titulo")    
    private String titulo;    
           
    @Column(name = "descripcion")
    @Size(max=800)
    private String descripcion;    
    
    @Column(name = "fecha_final")    
    private String fecha_final;
    
    @Column(name = "estado")    
    private String estado;

    @Column(name = "link")    
    private String link;
    
    public Educations() {
    }

    public Educations(String titulo, String descripcion, String fecha_final, String estado, String link) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_final = fecha_final;
        this.estado = estado;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    
    
}
