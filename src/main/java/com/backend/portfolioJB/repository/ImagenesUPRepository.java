
package com.backend.portfolioJB.repository;


import com.backend.portfolioJB.entity.ImgFiles;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenesUPRepository extends JpaRepository<ImgFiles, Integer> {
    
     Optional<ImgFiles> findByNombre(String nombre);
    boolean existsByNombre(String nombre);    
}
