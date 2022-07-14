
package com.backend.portfolioJB.service;


import com.backend.portfolioJB.entity.ImgFiles;
import com.backend.portfolioJB.repository.ImagenesUPRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImagenesUPService {
    
     @Autowired
    ImagenesUPRepository  imagenesUPRepository;

    public List<ImgFiles> list(){
        return imagenesUPRepository.findAll();
    }

    public Optional<ImgFiles> getOne(int id){
        return imagenesUPRepository.findById(id);
    }

    public Optional<ImgFiles> getByNombre(String nombre){
        return imagenesUPRepository.findByNombre(nombre);
    }

    public void  save(ImgFiles imagenes){
        imagenesUPRepository.save(imagenes);
    }

    public void delete(int id){
        imagenesUPRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return imagenesUPRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return imagenesUPRepository.existsByNombre(nombre);
    }
    
    
}
