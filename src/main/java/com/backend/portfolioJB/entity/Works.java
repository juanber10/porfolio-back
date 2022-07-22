
package com.backend.portfolioJB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Works {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Titulo")    
    private String titulo;    
              
    @Column(name = "SubTitulo")    
    private String subtitulo;  
    
    @Column(name = "Descripcion")
    @Size(max=1000)
    private String descripcion;  
    
    @Column(name = "Origenes")    
    private String origen; 
    
    @Column(name = "imagenesUrl")    
    private String linkImagen; 
    
    @Column(name = "link_proyectos")    
    private String linkProyectos; 

    public Works() {
    }

    public Works(String titulo, String subtitulo, String descripcion, String origen, String linkImagen,String linkProyectos) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
        this.origen = origen;
        this.linkImagen = linkImagen;
        this.linkProyectos = linkProyectos;
    }

    public String getLinkProyectos() {
        return linkProyectos;
    }

    public void setLinkProyectos(String linkProyectos) {
        this.linkProyectos = linkProyectos;
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
