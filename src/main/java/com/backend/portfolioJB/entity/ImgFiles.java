
package com.backend.portfolioJB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ImgFiles {    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nombre") 
private String nombre;

@Column(name = "origen") 
private String origen;

@Column(name = "URL") 
private String linkimg;

    public ImgFiles() {
    }

    public ImgFiles(String nombre, String origen, String linkimg) {
        this.nombre = nombre;
        this.origen = origen;
        this.linkimg = linkimg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
