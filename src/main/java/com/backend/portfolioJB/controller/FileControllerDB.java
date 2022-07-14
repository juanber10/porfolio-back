
package com.backend.portfolioJB.controller;


import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.dto.fileDBDto;
import com.backend.portfolioJB.entity.FileDB;
import com.backend.portfolioJB.mensajes.ResponseFile;
import com.backend.portfolioJB.mensajes.ResponseMenssage;
import com.backend.portfolioJB.service.FileUpService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@CrossOrigin("*")
public class FileControllerDB {
    
  @Autowired
  private FileUpService storageService;
  @PostMapping("/uploadDB")
  public ResponseEntity<ResponseMenssage> uploadFile(@RequestParam("file") MultipartFile file,
                                                      @RequestParam String origen ) {
    String message = "";
    try {
      storageService.store(file ,origen);
      message = "Archivos subidos correctamente " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMenssage(message));
    } catch (Exception e) {
      message = "No se pudo pudo subir el archivo: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMenssage(message));
    }
  }
  @GetMapping("/filesDB")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/filesDB/")
          .path(dbFile.getId()).toUriString();
       String IdArchivo = (dbFile.getId());
      return new ResponseFile(
                            IdArchivo,
                            dbFile.getName(),
                            fileDownloadUri,
                            dbFile.getType(),
                            dbFile.getSource(),
                            dbFile.getData().length);
                      }).collect(Collectors.toList());
    
    return ResponseEntity.status(HttpStatus.OK).body(files);
  }
  
  @PutMapping("/updateDB/{id}")
    public ResponseEntity<?> update(@PathVariable("id")String id, @RequestBody fileDBDto FileDBDto) throws IOException{
        if(!storageService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);        
        if(StringUtils.isBlank(FileDBDto.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(FileDBDto.getSource()))
            return new ResponseEntity(new Mensaje("El origen es obligatorio"), HttpStatus.BAD_REQUEST);        
        if(StringUtils.isBlank(FileDBDto.getType()))
            return new ResponseEntity(new Mensaje("El tipo de archivo es obligatorio"), HttpStatus.BAD_REQUEST);
                      
        FileDB fileDB = storageService.getOne(id).get();
        fileDB.setName(FileDBDto.getName());
        fileDB.setSource(FileDBDto.getSource());
        fileDB.setType(FileDBDto.getType());
        storageService.store((MultipartFile) fileDB, fileDB.getSource()) ;
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }
    
     @GetMapping("/listaDB")
    public ResponseEntity<List<FileDB>> list(){
        List<FileDB> list = storageService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/filesDB1/{id}")
    public ResponseEntity<FileDB> getByTitulo(@PathVariable("id") String id){
        if(!storageService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        FileDB files = storageService.getOne(id).get();
        return new ResponseEntity(files, HttpStatus.OK);
    }
   
  @GetMapping("/filesDB/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable ("id") String id) {
    FileDB fileDB = storageService.getFile(id);
    return ResponseEntity.ok()
           .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
           .body(fileDB.getData());
  }
    
    
    @DeleteMapping("/deleteDB/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")String id){
        if(!storageService.existsById(id))             
        return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        System.out.println("Id recibido: "+ id);
        storageService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
    
    
    
}
