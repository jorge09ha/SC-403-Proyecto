package com.BikeLab.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService implements IFileUploadService {
    
    private final Logger LOGGER = LoggerFactory.getLogger(UploadFileService.class);

//---------------------------------------EVENTOS--------------------------------------------------------
    @Override
    public String saveImageEvento(MultipartFile imagefile) throws IOException {
        if (!imagefile.isEmpty()) {
            Path directorioImagen = Paths.get("src//main//resources//static/images/evento");
            String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagefile.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagefile.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                LOGGER.info("UPLOAD - Se carga la imagen: "+ imagefile.getOriginalFilename());
                return "/images/evento/" + imagefile.getOriginalFilename();
            } catch (Exception e) {
                e.printStackTrace();
                return "/images/no_image.jpg";
            }
        }
        return "/images/no_image.jpg";
    }
//---------------------------------------PRODUCTO--------------------------------------------------------
    @Override
    public String saveImageProducto(MultipartFile imagefile) throws IOException {
        if (!imagefile.isEmpty()) {
            Path directorioImagen = Paths.get("src//main//resources//static/images/producto");
            String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagefile.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagefile.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                LOGGER.info("UPLOAD - Se carga la imagen: "+ imagefile.getOriginalFilename());
                return "/images/producto/" + imagefile.getOriginalFilename();
            } catch (Exception e) {
                e.printStackTrace();
                return "/images/no_image.jpg";
            }
        }
        return "/images/no_image.jpg";
    }
//---------------------------------------DELETE--------------------------------------------------------
    @Override
    public void deleteImage(String nombre) {
        try {
            if (!nombre.equals("/images/no_image.jpg")) {
                String ruta = "src//main//resources//static";
                File file = new File(ruta + nombre);
                file.delete();
                 LOGGER.info("DELETE - Se elimina la imagen: "+ nombre);
            } else {
                LOGGER.info("No se elimina la imagen. Es la imagen DEFAULT: "+ nombre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
