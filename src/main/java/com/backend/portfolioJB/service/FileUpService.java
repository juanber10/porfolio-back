
package com.backend.portfolioJB.service;

import com.backend.portfolioJB.entity.Educations;
import com.backend.portfolioJB.entity.FileDB;
import com.backend.portfolioJB.repository.FileDBRepository;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpService {
    @Autowired
  private FileDBRepository fileDBRepository;
    
  public FileDB store(MultipartFile file, String parametro ) throws IOException {
      
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    
    String nuevonombre = "JBimg"+ new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()) + fileName.substring(fileName.lastIndexOf("."));
           
    FileDB FileDB = new FileDB(nuevonombre, file.getContentType(),parametro,"", file.getBytes());
    return fileDBRepository.save(FileDB);
  }
  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
   public List<FileDB> list(){
     return fileDBRepository.findAll();
   }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
  
  public Optional<FileDB> getOne(String id){
     return fileDBRepository.findById(id);
    }
  
    public Optional<FileDB> getByName(String name){
        return fileDBRepository.findByName(name);
    }

    public boolean existsById(String id){
        return fileDBRepository.existsById(id);
    }  
  
  public void delete(String id){
    fileDBRepository.deleteById(id);
  }
    
}
