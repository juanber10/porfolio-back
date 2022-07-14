package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.ImgFilesDto;
import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.entity.ImgFiles;
import com.backend.portfolioJB.service.ImagenesUPService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ImagenesUp")
@CrossOrigin(origins = "*")

public class ImagenesUPController {
    @Autowired
    ImagenesUPService imagenesService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<ImgFiles>> list(){
        List<ImgFiles> list = imagenesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<ImgFiles> getById(@PathVariable("id") int id){
        if(!imagenesService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ImgFiles imgFiles = imagenesService.getOne(id).get();
        return new ResponseEntity(imgFiles, HttpStatus.OK);
    }
    
    
        @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")    
    
  public ResponseEntity<?> create(@RequestBody ImgFilesDto imgFilesDto){  
      
        if(StringUtils.isBlank(imgFilesDto.getNombre()))            
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(imagenesService.existsByNombre(imgFilesDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(imgFilesDto.getNombre()))            
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(imgFilesDto.getOrigen()))            
            return new ResponseEntity(new Mensaje("El origen es obligatorio"), HttpStatus.BAD_REQUEST);
       
        
        ImgFiles imgFiles = new ImgFiles(imgFilesDto.getNombre(),imgFilesDto.getOrigen(),imgFilesDto.getLinkimg());
        
        imagenesService.save(imgFiles);
        return new ResponseEntity(new Mensaje("Archivos guardados"), HttpStatus.OK);
}
    
}
