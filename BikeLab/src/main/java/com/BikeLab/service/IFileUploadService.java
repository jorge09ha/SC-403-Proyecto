package com.BikeLab.service;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jorge Hernandez Araya | jorge09ha
 */
public interface IFileUploadService {

    public String saveImageProducto(MultipartFile imagefile) throws IOException;
    
    public String saveImageEvento(MultipartFile imagefile) throws IOException;
    
    public void deleteImage(String nombre);

}
