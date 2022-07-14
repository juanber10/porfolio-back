
package com.backend.portfolioJB.repository;

import com.backend.portfolioJB.entity.SkillsHard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface SkillsHardRepository extends JpaRepository<SkillsHard, Integer> {
    Optional<SkillsHard> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
    
    
}
