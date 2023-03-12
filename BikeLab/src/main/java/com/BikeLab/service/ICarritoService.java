package com.BikeLab.service;

import com.BikeLab.entity.Carrito;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ICarritoService {

    public List<Carrito> getAllCarrito();

    public Carrito getCarritoById(long id);

    public void saveCarrito(Carrito carrito);

    public void deleteCarrito(long id);

}
