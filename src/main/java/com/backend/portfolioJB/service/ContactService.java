
package com.backend.portfolioJB.service;

import com.backend.portfolioJB.entity.Contact;
import com.backend.portfolioJB.repository.ContactRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactService {
    @Autowired
    ContactRepository contactRepository; 
    
     public List<Contact> list(){
        return contactRepository.findAll();
    }

    public Optional<Contact> getOne(int id){
        return contactRepository.findById(id);
    }

    public Optional<Contact> getByNombre(String nombre){
        return contactRepository.findByNombre(nombre);
    }    
    public void  save(Contact contact){
        contactRepository.save(contact);
    }       
    public void delete(int id){
        contactRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return contactRepository.existsById(id);
    }
    
}
