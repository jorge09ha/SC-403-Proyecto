package com.BikeLab.service;

import com.BikeLab.entity.Provincia;
import com.BikeLab.repository.ProvinciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<Provincia> getAllProvincia() {
        return (List<Provincia>) provinciaRepository.findAll();
    }

    @Override
    public Provincia getProvinciaById(long id) {
        return provinciaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProvincia(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public void deleteProvincia(long id) {
        provinciaRepository.deleteById(id);
    }

}
