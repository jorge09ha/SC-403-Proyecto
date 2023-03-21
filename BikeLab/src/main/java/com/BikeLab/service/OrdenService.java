package com.BikeLab.service;

import com.BikeLab.entity.Orden;
import com.BikeLab.repository.OrdenRepository;
import com.BikeLab.service.IOrdenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService implements IOrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<Orden> getAllOrden() {
        return (List<Orden>) ordenRepository.findAll();
    }

    @Override
    public Orden getOrdenById(long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrden(Orden orden) {
        ordenRepository.save(orden);
    }

    @Override
    public void deleteOrden(long id) {
        ordenRepository.deleteById(id);
    }

}
