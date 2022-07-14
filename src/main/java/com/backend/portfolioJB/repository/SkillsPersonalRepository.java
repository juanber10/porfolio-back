
package com.backend.portfolioJB.repository;

import com.backend.portfolioJB.entity.SkillsPersonal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsPersonalRepository extends JpaRepository<SkillsPersonal , Integer> {
     Optional<SkillsPersonal> findByNombre(String nombre);
    boolean existsByNombre(String nombre);   
    
}
