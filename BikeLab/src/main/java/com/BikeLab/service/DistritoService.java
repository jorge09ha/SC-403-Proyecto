package com.BikeLab.service;

import com.BikeLab.entity.Distrito;
import com.BikeLab.repository.DistritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistritoService implements IDistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<Distrito> getAllDistrito() {
        return (List<Distrito>) distritoRepository.findAll();
    }

    @Override
    public Distrito getDistritoById(long id) {
        return distritoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveDistrito(Distrito distrito) {
        distritoRepository.save(distrito);
    }

    @Override
    public void deleteDistrito(long id) {
        distritoRepository.deleteById(id);
    }

}
