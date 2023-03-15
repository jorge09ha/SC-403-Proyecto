package com.BikeLab.service;

import com.BikeLab.entity.Marca;
import com.BikeLab.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService implements IMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> getAllMarca() {
        return (List<Marca>) marcaRepository.findAll();
    }

    @Override
    public Marca getMarcaById(long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMarca(Marca marca) {
        marcaRepository.save(marca);
    }

    @Override
    public void deleteMarca(long id) {
        marcaRepository.deleteById(id);
    }

}
