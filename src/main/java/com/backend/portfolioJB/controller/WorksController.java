
package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.dto.WorksDto;
import com.backend.portfolioJB.entity.Works;
import com.backend.portfolioJB.service.WorksService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Works")
@CrossOrigin(origins = "*")
public class WorksController {
    @Autowired
    WorksService workServices;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Works>> list(){
        List<Works> list = workServices.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Works> getById(@PathVariable("id") int id){
        if(!workServices.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Works works = workServices.getOne(id).get() ;
        return new ResponseEntity(works, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")    
    
  public ResponseEntity<?> create(@RequestBody WorksDto worksDto){  
      
        if(StringUtils.isBlank(worksDto.getTitulo()))            
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(worksDto.getSubtitulo()))            
            return new ResponseEntity(new Mensaje("El subtitulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(worksDto.getDescripcion()))            
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(worksDto.getOrigen()))            
            return new ResponseEntity(new Mensaje("El origen de la publicacion es obligatorio"), HttpStatus.BAD_REQUEST);
    
                
        Works works = new Works(
                worksDto.getTitulo(),
                worksDto.getSubtitulo(),
                worksDto.getDescripcion(),
                worksDto.getOrigen(),
                worksDto.getLinkImagen(),
                worksDto.getLinkProyectos() );
        
        workServices.save(works);
        return new ResponseEntity(new Mensaje("Trabajo creado"), HttpStatus.OK);
}

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody WorksDto worksDto){
       
        if(!workServices.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        if(StringUtils.isBlank(worksDto.getTitulo()))            
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(worksDto.getSubtitulo()))            
            return new ResponseEntity(new Mensaje("El subtitulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(worksDto.getDescripcion()))            
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(worksDto.getOrigen()))            
            return new ResponseEntity(new Mensaje("El origen de la publicacion es obligatorio"), HttpStatus.BAD_REQUEST);
              
              Works works = workServices.getOne(id).get();
              works.setTitulo(worksDto.getTitulo());
              works.setSubtitulo(worksDto.getSubtitulo());
              works.setDescripcion(worksDto.getDescripcion());
              works.setOrigen(worksDto.getOrigen());
              works.setLinkImagen(worksDto.getLinkImagen());
              works.setLinkProyectos(worksDto.getLinkProyectos());           
              workServices.save(works);
        return new ResponseEntity(new Mensaje("Trabajo actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!workServices.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       workServices.delete(id);
        return new ResponseEntity(new Mensaje("Trabajo eliminado"), HttpStatus.OK);
    }

    
    
}
