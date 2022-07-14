
package com.backend.portfolioJB.service;

import com.backend.portfolioJB.entity.Works;
import com.backend.portfolioJB.repository.WorksRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorksService {
    @Autowired
    WorksRepository worksRepository;
    
     public List<Works> list(){
        return worksRepository.findAll();
    }

    public Optional<Works> getOne(int id){
        return worksRepository.findById(id);
    }

    public Optional<Works> getByTitulo(String titulo){
        return worksRepository.findByTitulo(titulo);
    }
    
    public void  save(Works works){
        worksRepository.save(works);
    }  
    
 
    public void delete(int id){
        worksRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return worksRepository.existsById(id);
    }


    
}
