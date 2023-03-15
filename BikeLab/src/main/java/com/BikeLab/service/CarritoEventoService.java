package com.BikeLab.service;

import com.BikeLab.entity.CarritoEvento;
import com.BikeLab.repository.CarritoEventoRepository;
import com.BikeLab.service.ICarritoEventoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoEventoService implements ICarritoEventoService {

    @Autowired
    private CarritoEventoRepository carritoEventoRepository;

    @Override
    public List<CarritoEvento> getAllCarritoEvento() {
        return (List<CarritoEvento>) carritoEventoRepository.findAll();
    }

    @Override
    public CarritoEvento getCarritoEventoById(long id) {
        return carritoEventoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCarritoEvento(CarritoEvento carritoEvento) {
        carritoEventoRepository.save(carritoEvento);
    }

    @Override
    public void deleteCarritoEvento(long id) {
        carritoEventoRepository.deleteById(id);
    }

}
