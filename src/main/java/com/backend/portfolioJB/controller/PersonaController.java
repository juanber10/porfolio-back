package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.dto.PersonaDto;
import com.backend.portfolioJB.entity.Persona;
import com.backend.portfolioJB.service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/datosPersona")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Persona> getByNombre(@PathVariable("nombre") String nombre){
        if(!personaService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getByNombre(nombre).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")    
    
  public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){  
      
        if(StringUtils.isBlank(personaDto.getNombre()))            
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaService.existsByNombre(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getTitulo()))            
            return new ResponseEntity(new Mensaje("el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getDescripcion()))            
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
         
        Persona persona = new Persona(personaDto.getNombre(),personaDto.getTitulo(),
               personaDto.getDescripcion(), personaDto.getUrlimg(),personaDto.getFblink(),
               personaDto.getIglink(),personaDto.getLinkding(),personaDto.getSnaplink(),
                personaDto.getGitlink(),personaDto.getCodeLink(),personaDto.getYtlink());
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("perfil creado"), HttpStatus.OK);
}

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PersonaDto personaDto){
       
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(personaService.existsByNombre(personaDto.getNombre()) &&
           personaService.getByNombre(personaDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
                     
        if(StringUtils.isBlank(personaDto.getTitulo()))
            return new ResponseEntity(new Mensaje("el Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(personaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descricpion es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setTitulo(personaDto.getTitulo());
        persona.setDescripcion(personaDto.getDescripcion());
        persona.setUrlimg(personaDto.getUrlimg());
        persona.setFblink(personaDto.getFblink());
        persona.setIglink(personaDto.getIglink());
        persona.setLinkding(personaDto.getLinkding());
        persona.setSnaplink(personaDto.getSnaplink());
        persona.setGitlink(personaDto.getGitlink());
        persona.setCodeLink(personaDto.getCodeLink());
        persona.setYtlink(personaDto.getYtlink());
        
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Datos eliminados"), HttpStatus.OK);
    }


}
