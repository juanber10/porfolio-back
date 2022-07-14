
package com.backend.portfolioJB.controller;

import com.backend.portfolioJB.dto.DataAccessDto;
import com.backend.portfolioJB.dto.Mensaje;
import com.backend.portfolioJB.entity.FileDB;
import com.backend.portfolioJB.service.DataService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dataacces")
@CrossOrigin(origins = "*")
public class FilesDataAccesController {
    
        
    @Autowired
    DataService dataService;

    @GetMapping("/listaDB")
    public ResponseEntity<List<FileDB>> list(){
        List<FileDB> list = dataService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

//    @GetMapping("/detail/{id}")
//    public ResponseEntity<FileDB> getById(@PathVariable("id") String id){
//        if(!dataService.existsById(id))
//            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
//        FileDB fileDB = dataService.getOne(id).get();
//        return new ResponseEntity(fileDB, HttpStatus.OK);
//    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateDB/{id}")
    public ResponseEntity<?> update(@PathVariable("id")String id, @RequestBody DataAccessDto dataAccessDto){
        if(!dataService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        
        if(StringUtils.isBlank(dataAccessDto.getName() ))
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dataAccessDto.getType()))
            return new ResponseEntity(new Mensaje("El tipo de archivo es obligatorio"), HttpStatus.BAD_REQUEST);
        
                if(StringUtils.isBlank(dataAccessDto.getSource()))
            return new ResponseEntity(new Mensaje("El origen es obligatorio"), HttpStatus.BAD_REQUEST);
        
        FileDB fileDB = dataService.getOne(id).get();
        fileDB.setName(dataAccessDto.getName());
        fileDB.setType(dataAccessDto.getType());
        fileDB.setSource(dataAccessDto.getSource());
        fileDB.setData(dataAccessDto.getData());
        dataService.save(fileDB);
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteDB/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")String id){
        if(!dataService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        dataService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }
    
    
}
