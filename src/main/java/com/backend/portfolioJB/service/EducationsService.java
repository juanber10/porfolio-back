
package com.backend.portfolioJB.service;

import com.backend.portfolioJB.entity.Educations;
import com.backend.portfolioJB.repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducationsService {
    
    @Autowired
    EducationRepository educationRepository;

    public List<Educations> list(){
        return educationRepository.findAll();
    }

    public Optional<Educations> getOne(int id){
        return educationRepository.findById(id);
    }

    public Optional<Educations> getByTitulo(String titulo){
        return educationRepository.findByTitulo(titulo);
    }

    public void  save(Educations educations){
        educationRepository.save(educations);
    }

    public void delete(int id){
        educationRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return educationRepository.existsById(id);
    }

    public boolean existsByTitulo(String titulo){
        return educationRepository.existsByTitulo(titulo);
    }
    
}
