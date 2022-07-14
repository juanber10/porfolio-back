
package com.backend.portfolioJB.service;

import com.backend.portfolioJB.entity.SkillsPersonal;
import com.backend.portfolioJB.repository.SkillsPersonalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsPersonalService {
    @Autowired
     SkillsPersonalRepository skillsPersonalRepository;

    public List<SkillsPersonal> list(){
        return skillsPersonalRepository.findAll();
    }
    
     public Optional<SkillsPersonal> getOne(int id){
        return skillsPersonalRepository.findById(id);
    }

    public Optional<SkillsPersonal> getByNombre(String nombre){
        return skillsPersonalRepository.findByNombre(nombre);
    }
    
    public void  save(SkillsPersonal skillsPersonal){
        skillsPersonalRepository.save(skillsPersonal);
    }   
 
    public void delete(int id){
        skillsPersonalRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return skillsPersonalRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return skillsPersonalRepository.existsByNombre(nombre);
    }
    
}
