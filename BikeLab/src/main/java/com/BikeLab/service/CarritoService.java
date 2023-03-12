package com.BikeLab.service;

import com.BikeLab.entity.Carrito;
import com.BikeLab.repository.CarritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements ICarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<Carrito> getAllCarrito() {
        return (List<Carrito>) carritoRepository.findAll();
    }

    @Override
    public Carrito getCarritoById(long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public void deleteCarrito(long id) {
        carritoRepository.deleteById(id);
    }

}
