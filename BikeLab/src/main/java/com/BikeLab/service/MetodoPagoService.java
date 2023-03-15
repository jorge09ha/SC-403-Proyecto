package com.BikeLab.service;

import com.BikeLab.entity.MetodoPago;
import com.BikeLab.repository.MetodoPagoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodoPagoService implements IMetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> getAllMetodoPago() {
        return (List<MetodoPago>) metodoPagoRepository.findAll();
    }

    @Override
    public MetodoPago getMetodoPagoById(long id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMetodoPago(MetodoPago metodoPago) {
        metodoPagoRepository.save(metodoPago);
    }

    @Override
    public void deleteMetodoPago(long id) {
        metodoPagoRepository.deleteById(id);
    }

}
