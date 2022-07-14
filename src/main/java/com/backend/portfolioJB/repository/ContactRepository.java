
package com.backend.portfolioJB.repository;

import com.backend.portfolioJB.entity.Contact;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Integer>{
    Optional<Contact> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    
}
