
package com.backend.portfolioJB.repository;


import com.backend.portfolioJB.entity.FileDB;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileDB, String>{
    
     Optional<FileDB> findByName(String name);
    boolean existsByName(String name); 
    
}
