package com.BikeLab.service;

import com.BikeLab.entity.CarritoProducto;
import com.BikeLab.repository.CarritoProductoRepository;
import com.BikeLab.service.ICarritoProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoProductoService implements ICarritoProductoService {

    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    @Override
    public List<CarritoProducto> getAllCarritoProducto() {
        return (List<CarritoProducto>) carritoProductoRepository.findAll();
    }

    @Override
    public CarritoProducto getCarritoProductoById(long id) {
        return carritoProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCarritoProducto(CarritoProducto carritoProducto) {
        carritoProductoRepository.save(carritoProducto);
    }

    @Override
    public void deleteCarritoProducto(long id) {
        carritoProductoRepository.deleteById(id);
    }

}
