
package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.EducationsDto;
import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.entity.Educations;
import com.backend.portfolioJB.service.EducationsService;
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
@RequestMapping("/educations")
@CrossOrigin(origins = "*")
public class EducationControler {
    
    @Autowired
    EducationsService educationsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educations>> list(){
        List<Educations> list = educationsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educations> getById(@PathVariable("id") int id){
        if(!educationsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educations educations = educationsService.getOne(id).get();
        return new ResponseEntity(educations, HttpStatus.OK);
    }

    @GetMapping("/detailname/{titulo}")
    public ResponseEntity<Educations> getByTitulo(@PathVariable("titulo") String titulo){
        if(!educationsService.existsByTitulo(titulo))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educations educations = educationsService.getByTitulo(titulo).get();
        return new ResponseEntity(educations, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationsDto educationsDto){
        
        if(StringUtils.isBlank(educationsDto.getTitulo()))            
            return new ResponseEntity(new Mensaje("el Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(educationsDto.getDescripcion()))            
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(educationsDto.getFecha_final()))            
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educations educations = new Educations(educationsDto.getTitulo(),educationsDto.getDescripcion(),
                educationsDto.getFecha_final(),educationsDto.getEstado(), educationsDto.getLinkCert());
        
        educationsService.save(educations);
        return new ResponseEntity(new Mensaje("Datos Academicos guardados"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EducationsDto educationsDto){
        if(!educationsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        
        if(StringUtils.isBlank(educationsDto.getTitulo()))
            return new ResponseEntity(new Mensaje("el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(educationsDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("La descricpion es obligatorio"), HttpStatus.BAD_REQUEST);
        
                if(StringUtils.isBlank(educationsDto.getFecha_final()))
            return new ResponseEntity(new Mensaje("La fecha es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Educations educations = educationsService.getOne(id).get();
        educations.setTitulo(educationsDto.getTitulo());
        educations.setDescripcion(educationsDto.getDescripcion());
        educations.setFecha_final(educationsDto.getFecha_final());
        educations.setEstado(educationsDto.getEstado());
        educations.setLinkCert(educationsDto.getLinkCert());
        educationsService.save(educations);
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!educationsService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        educationsService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
    
    
}
