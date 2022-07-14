
package com.backend.portfolioJB.dto;

import javax.validation.constraints.NotBlank;


public class DataAccessDto {
    
    @NotBlank
    private String name;   
    
    @NotBlank
    private String  type;
    
    @NotBlank
    private String source;
   
    
    private byte[] data;

    public DataAccessDto() {
    }

    public DataAccessDto(String name, String type, String source, byte[] data) {
        this.name = name;
        this.type = type;
        this.source = source;
        this.data = data;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
    
    
}
