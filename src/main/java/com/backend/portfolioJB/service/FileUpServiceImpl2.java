
package com.backend.portfolioJB.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileUpServiceImpl2 implements FileUpService2 {    
    private final Path root = Paths.get("uploadsnva");

  @Override
  public void init() {
    try {
      Files.createDirectory(root);
    } catch (IOException e) {
      throw new RuntimeException("¡No se pudo inicializar la carpeta para cargar!");
    }
  }
  @Override
  public void save(MultipartFile file) {

     String filename = StringUtils.cleanPath(file.getOriginalFilename());
//     filename = filename.toLowerCase().replaceAll(" ", "-");     
     
     String nuevonombre = "JBimg"+ new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + filename.substring(filename.lastIndexOf("."));
       try {        
            if (nuevonombre.isEmpty()) {
                  throw new RuntimeException("No se pudo almacenar el archivo vacío" + nuevonombre);
                   }
            if (nuevonombre.contains("..")) {
                throw new RuntimeException(
                 "No se puede almacenar el archivo con la ruta relativa fuera del directorio actual"+ nuevonombre);
                   }      
      Files.copy(file.getInputStream(), this.root.resolve(nuevonombre),
         StandardCopyOption.REPLACE_EXISTING);      
        
//      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()),
//             StandardCopyOption.REPLACE_EXISTING );
         
      
    } catch (Exception e) {
      throw new RuntimeException("No se pudo almacenar el archivo. Error: " + e.getMessage());
    }
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("No se pudo leer el archivo!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

//  @Override
//  public void deleteAll() {
//    FileSystemUtils.deleteRecursively(root.toFile());
//  }      
    
  @Override
    public void delete(String filename){
        try {
         FileSystemUtils.deleteRecursively(root.resolve(filename));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo eliminar los archivos");
        } 
    } 

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("No se pudieron cargar los archivos!");
    }
  }


    
}
