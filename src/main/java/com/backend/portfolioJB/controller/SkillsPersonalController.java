package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.dto.SkillPersonalDto;
import com.backend.portfolioJB.entity.SkillsPersonal;
import com.backend.portfolioJB.service.SkillsPersonalService;
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
@RequestMapping("/habilidadPsonal")
@CrossOrigin(origins = "*")
public class SkillsPersonalController {
    
    @Autowired
    SkillsPersonalService skillsPersonalService;

    @GetMapping("/lista")
    public ResponseEntity<List<SkillsPersonal>>list(){
        List<SkillsPersonal> list = skillsPersonalService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SkillsPersonal>getById(@PathVariable("id") int id){
        if(!skillsPersonalService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SkillsPersonal skillsHard = skillsPersonalService.getOne(id).get();
        return new ResponseEntity(skillsHard, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")    
    
  public ResponseEntity<?> create(@RequestBody SkillPersonalDto skillsPersonalDto){  
      
        if(StringUtils.isBlank(skillsPersonalDto.getNombre()))            
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(skillsPersonalDto.getColor_barra()))            
            return new ResponseEntity(new Mensaje("el color de la barra es obligatorio"), HttpStatus.BAD_REQUEST);
    
                
        SkillsPersonal skillsPersonal = new SkillsPersonal(
                skillsPersonalDto.getNombre(),
                skillsPersonalDto.getColor_barra());        
        skillsPersonalService.save(skillsPersonal);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
}

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody SkillPersonalDto skillsPersonalDto){
       
        if(!skillsPersonalService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(skillsPersonalService.existsByNombre(skillsPersonalDto.getNombre()) &&
           skillsPersonalService.getByNombre(skillsPersonalDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(skillsPersonalDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
  
        if(StringUtils.isBlank(skillsPersonalDto.getColor_barra()))            
            return new ResponseEntity(new Mensaje("el color es obligatorio"), HttpStatus.BAD_REQUEST);      
        
        SkillsPersonal skillsPersonal = skillsPersonalService.getOne(id).get();
        skillsPersonal.setNombre(skillsPersonalDto.getNombre());
       
        skillsPersonal.setColor_barra(skillsPersonalDto.getColor_barra());
      
        skillsPersonalService.save(skillsPersonal);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillsPersonalService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       skillsPersonalService.delete(id);
        return new ResponseEntity(new Mensaje("Valor eliminado"), HttpStatus.OK);
    }
    
}
