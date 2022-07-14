
package com.backend.portfolioJB.service;


import com.backend.portfolioJB.entity.Experience;
import com.backend.portfolioJB.repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;

    public List<Experience> list(){
        return experienceRepository.findAll();
    }

    public Optional<Experience> getOne(int id){
        return experienceRepository.findById(id);
    }

    public Optional<Experience> getByTitulo(String titulo){
        return experienceRepository.findByTitulo(titulo);
    }

    public void  save(Experience experience){
        experienceRepository.save(experience);
    }

    public void delete(int id){
        experienceRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return experienceRepository.existsById(id);
    }

    public boolean existsByTitulo(String titulo){
        return experienceRepository.existsByTitulo(titulo);
    }
    
    
    
}
