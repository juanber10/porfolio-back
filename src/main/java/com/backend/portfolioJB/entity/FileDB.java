package com.backend.portfolioJB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "Archivos")

public class FileDB {  
  

  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idmain")
  private int IDmain;  
  @Column(name = "Nombre") 
  private String name;
  @Column(name = "Tipo") 
  private String type;
  @Column(name = "Origenes") 
  private String source;
  @Column(name = "LinkImg") 
  private String url; 
  @Column(name = "Archivo") 
  @Lob
  private byte[] data;

    public FileDB() {
    }

    public FileDB( String name, String type, String source, String url, byte[] data) {
        this.name = name;
        this.type = type;
        this.source = source;
        this.url = url;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIDmain() {
        return IDmain;
    }

    public void setIDmain(int IDmain) {
        this.IDmain = IDmain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

   
 

   
       
    
}
