
package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.dto.SkillsHardDto;
import com.backend.portfolioJB.entity.SkillsHard;
import com.backend.portfolioJB.service.SkillsHardService;
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
@RequestMapping("/habilidadesHard")
@CrossOrigin(origins = "*")
public class SkillsHardController {
    
    @Autowired
    SkillsHardService skillsHardService;

    @GetMapping("/lista")
    public ResponseEntity<List<SkillsHard>> list(){
        List<SkillsHard> list = skillsHardService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SkillsHard> getById(@PathVariable("id") int id){
        if(!skillsHardService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SkillsHard skillsHard = skillsHardService.getOne(id).get();
        return new ResponseEntity(skillsHard, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<SkillsHard> getByNombre(@PathVariable("nombre") String nombre){
        if(!skillsHardService.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        SkillsHard skillsHard = skillsHardService.getByNombre(nombre).get();
        return new ResponseEntity(skillsHard, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")    
    
  public ResponseEntity<?> create(@RequestBody SkillsHardDto skillsHardDto){  
      
        if(StringUtils.isBlank(skillsHardDto.getNombre()))            
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillsHardDto.getValor()<0 || skillsHardDto.getValor()>100 )
            return new ResponseEntity(new Mensaje("El valor debe estar dentro del rango [0-100] "), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(skillsHardDto.getColor_barra()))            
            return new ResponseEntity(new Mensaje("el color de la barra es obligatorio"), HttpStatus.BAD_REQUEST);
    
                
        SkillsHard skillsHard = new SkillsHard(
                skillsHardDto.getNombre(),
                skillsHardDto.getValor(),
                skillsHardDto.getColor_barra(),
                skillsHardDto.getIcons());
        
        skillsHardService.save(skillsHard);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
}

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody SkillsHardDto skillsHardDto){
       
        if(!skillsHardService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(skillsHardService.existsByNombre(skillsHardDto.getNombre()) &&
           skillsHardService.getByNombre(skillsHardDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(skillsHardDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(skillsHardDto.getValor()<0 || skillsHardDto.getValor()>100 )
            return new ResponseEntity(new Mensaje("El valor debe ser mayor que 0 y menor o igual que 100"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillsHardDto.getColor_barra()))            
            return new ResponseEntity(new Mensaje("el color es obligatorio"), HttpStatus.BAD_REQUEST);
       
       
        
        SkillsHard skillsHard = skillsHardService.getOne(id).get();
        skillsHard.setNombre(skillsHardDto.getNombre());
        skillsHard.setValor(skillsHardDto.getValor());
        skillsHard.setColor_barra(skillsHardDto.getColor_barra());
        skillsHard.setIcons(skillsHardDto.getIcons());
        skillsHardService.save(skillsHard);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillsHardService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       skillsHardService.delete(id);
        return new ResponseEntity(new Mensaje("Valor eliminado"), HttpStatus.OK);
    }

    
    
    
    
}
