
package com.backend.portfolioJB.service;

import com.backend.portfolioJB.entity.FileDB;
import com.backend.portfolioJB.repository.DataAccessRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DataService {
    
    @Autowired
    DataAccessRepository dataAccessRepository;
    
    public List<FileDB> list(){
        return dataAccessRepository.findAll();
    }
    public FileDB getFile(String id) {
    return dataAccessRepository.findById(id).get();
    }
    
    public Optional<FileDB> getOne(String id){
        return dataAccessRepository.findById(id);
    }

    public Optional<FileDB> getById(String id){
        return dataAccessRepository.findById(id);
    }

    public void  save(FileDB fileDB){
        dataAccessRepository.save(fileDB);
    }

    public void delete(String id){
        dataAccessRepository.deleteById(id);
    }

    public boolean existsById(String id){
        return dataAccessRepository.existsById(id);
    }

}
