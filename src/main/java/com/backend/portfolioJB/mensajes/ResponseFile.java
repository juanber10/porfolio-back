
package com.backend.portfolioJB.mensajes;


public class ResponseFile {
    
  private String idfile;
  private String name;
  private String url;
  private String type;
  private String source;
  private long size;

    public ResponseFile(String idfile, String name, String url, String type, String source, long size) {
        this.idfile = idfile;
        this.name = name;
        this.url = url;
        this.type = type;
        this.source = source;
        this.size = size;
    }

    public String getIdFile() {
        return idfile;
    }

    public void setIdFile(String IdFile) {
        this.idfile = idfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

  

    
    
    
  
}
