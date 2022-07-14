
package com.backend.portfolioJB.repository;

import com.backend.portfolioJB.entity.Educations;
import com.backend.portfolioJB.entity.FileDB;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DataAccessRepository  extends JpaRepository<FileDB, String> {
    Optional<FileDB> findById(String id);
    boolean existsById(String id);

    public Optional<Educations> findById(int id);
    
    
    
}
