
package com.backend.portfolioJB.service;

import com.backend.portfolioJB.entity.SkillsHard;
import com.backend.portfolioJB.repository.SkillsHardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SkillsHardService {
    
    @Autowired
    SkillsHardRepository skillsHardRepository;

    public List<SkillsHard> list(){
        return skillsHardRepository.findAll();
    }

    public Optional<SkillsHard> getOne(int id){
        return skillsHardRepository.findById(id);
    }

    public Optional<SkillsHard> getByNombre(String nombre){
        return skillsHardRepository.findByNombre(nombre);
    }
    
    public void  save(SkillsHard skillsHard){
        skillsHardRepository.save(skillsHard);
    }  
    
 
    public void delete(int id){
        skillsHardRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return skillsHardRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return skillsHardRepository.existsByNombre(nombre);
    }
    
    
    
}
