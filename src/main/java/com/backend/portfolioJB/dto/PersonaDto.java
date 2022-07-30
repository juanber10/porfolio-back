
package com.backend.portfolioJB.dto;
import javax.validation.constraints.NotBlank;

public class PersonaDto {
    
     @NotBlank
    private String nombre;   
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    
    private String fblink;
    private String iglink;
    private String linkding;
    private String snaplink;
    private String gitlink;
    private String codeLink;
    private String ytlink;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String titulo, String descripcion, String fblink, String iglink, String linkding, String snaplink, String gitlink, String codeLink, String ytlink) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fblink = fblink;
        this.iglink = iglink;
        this.linkding = linkding;
        this.snaplink = snaplink;
        this.gitlink = gitlink;
        this.codeLink = codeLink;
        this.ytlink = ytlink;
    }

    public String getFblink() {
        return fblink;
    }

    public void setFblink(String fblink) {
        this.fblink = fblink;
    }

    public String getIglink() {
        return iglink;
    }

    public void setIglink(String iglink) {
        this.iglink = iglink;
    }

    public String getLinkding() {
        return linkding;
    }

    public void setLinkding(String linkding) {
        this.linkding = linkding;
    }

    public String getSnaplink() {
        return snaplink;
    }

    public void setSnaplink(String snaplink) {
        this.snaplink = snaplink;
    }

    public String getGitlink() {
        return gitlink;
    }

    public void setGitlink(String gitlink) {
        this.gitlink = gitlink;
    }

    public String getCodeLink() {
        return codeLink;
    }

    public void setCodeLink(String codeLink) {
        this.codeLink = codeLink;
    }

    public String getYtlink() {
        return ytlink;
    }

    public void setYtlink(String ytlink) {
        this.ytlink = ytlink;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
   
}
