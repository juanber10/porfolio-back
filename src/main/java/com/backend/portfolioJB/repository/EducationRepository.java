package com.backend.portfolioJB.repository;

import com.backend.portfolioJB.entity.Educations;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Educations, Integer> {
    Optional<Educations> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);    
}
