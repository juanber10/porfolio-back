
package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.ExperienceDto;
import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.entity.Experience;
import com.backend.portfolioJB.service.ExperienceService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "*")

public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = experienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @GetMapping("/detailname/{titulo}")
    public ResponseEntity<Experience> getByTitulo(@PathVariable("titulo") String titulo){
        if(!experienceService.existsByTitulo(titulo))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experience experience = experienceService.getByTitulo(titulo).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDto experienceDto){
        
        if(StringUtils.isBlank(experienceDto.getTitulo()))            
            return new ResponseEntity(new Mensaje("El Titulo de exp es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(experienceDto.getDescripcion()))            
            return new ResponseEntity(new Mensaje("La descripcion de exp es obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(experienceDto.getFecha()))            
            return new ResponseEntity(new Mensaje("La fecha es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experience experience = new Experience(
                experienceDto.getTitulo(),
                experienceDto.getDescripcion(),
                experienceDto.getFecha(),
                experienceDto.getFecha_final());
        
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("Experiencias guardadas"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ExperienceDto experienceDto){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        
        if(StringUtils.isBlank(experienceDto.getTitulo()))
            return new ResponseEntity(new Mensaje("el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(experienceDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descricpion es obligatorio"), HttpStatus.BAD_REQUEST);
        
                if(StringUtils.isBlank(experienceDto.getFecha()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Experience experience = experienceService.getOne(id).get();
        experience.setTitulo(experienceDto.getTitulo());
        experience.setDescripcion(experienceDto.getDescripcion());
        experience.setFecha(experienceDto.getFecha());
        experience.setFecha_final(experienceDto.getFecha_final());
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        experienceService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
    
}
