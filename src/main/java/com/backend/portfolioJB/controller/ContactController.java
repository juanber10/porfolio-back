
package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.ContactDto;
import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.entity.Contact;
import com.backend.portfolioJB.service.ContactService;
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
@RequestMapping("/Contact")
@CrossOrigin(origins = "*")
public class ContactController {
    @Autowired
    ContactService contactService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/lista")
    public ResponseEntity<List<Contact>> list(){
        List<Contact> list = contactService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contact> getById(@PathVariable("id") int id){
        if(!contactService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Contact contact = contactService.getOne(id).get() ;
        return new ResponseEntity(contact, HttpStatus.OK);
    }
   
  @PostMapping("/create")    
    
  public ResponseEntity<?> create(@RequestBody ContactDto contactDto){  
      
        if(StringUtils.isBlank(contactDto.getNombre()))            
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(contactDto.getEmail()))            
            return new ResponseEntity(new Mensaje("El Email es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(contactDto.getAsunto()))            
            return new ResponseEntity(new Mensaje("El Asunto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(contactDto.getMensaje()))            
            return new ResponseEntity(new Mensaje("El el mensaje es obligatorio"), HttpStatus.BAD_REQUEST);
    
          
        Contact contact = new Contact(
                contactDto.getNombre(),
                contactDto.getEmail(),
                contactDto.getAsunto(),
                contactDto.getMensaje(),
                contactDto.getEstado());
        
        contactService.save(contact);
        return new ResponseEntity(new Mensaje("mensaje enviado"), HttpStatus.OK);
}

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!contactService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       contactService.delete(id);
        return new ResponseEntity(new Mensaje("Mensaje eliminado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ContactDto contactDto){
        if(!contactService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);  
        
        if(StringUtils.isBlank(contactDto.getNombre()))
            return new ResponseEntity(new Mensaje("el Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(contactDto.getEmail()))
            return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(contactDto.getAsunto()))
            return new ResponseEntity(new Mensaje("El asunto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(contactDto.getMensaje()))            
            return new ResponseEntity(new Mensaje("El el mensaje es obligatorio"), HttpStatus.BAD_REQUEST);
        
             Contact contact = contactService.getOne(id).get();

             contact.setEstado(Boolean.TRUE);
             contactService.save(contact);
        return new ResponseEntity(new Mensaje("Mensaje actualizado"), HttpStatus.OK);
    }
    
    
    
}
