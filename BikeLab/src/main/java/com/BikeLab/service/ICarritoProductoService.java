package com.BikeLab.service;

import com.BikeLab.entity.CarritoProducto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ICarritoProductoService {

    public List<CarritoProducto> getAllCarritoProducto();

    public CarritoProducto getCarritoProductoById(long id);

    public void saveCarritoProducto(CarritoProducto carritoProducto);

    public void deleteCarritoProducto(long id);

}
