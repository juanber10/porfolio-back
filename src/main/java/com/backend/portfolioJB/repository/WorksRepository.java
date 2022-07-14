
package com.backend.portfolioJB.repository;

import com.backend.portfolioJB.entity.Works;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorksRepository extends JpaRepository<Works, Integer> {
    
    Optional<Works> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);
    
}
