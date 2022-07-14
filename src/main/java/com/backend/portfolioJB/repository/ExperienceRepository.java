
package com.backend.portfolioJB.repository;

import com.backend.portfolioJB.entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    Optional<Experience> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo); 
    
    
}
