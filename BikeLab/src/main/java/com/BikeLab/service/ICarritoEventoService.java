package com.BikeLab.service;

import com.BikeLab.entity.CarritoEvento;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ICarritoEventoService {

    public List<CarritoEvento> getAllCarritoEvento();

    public CarritoEvento getCarritoEventoById(long id);

    public void saveCarritoEvento(CarritoEvento carritoEvento);

    public void deleteCarritoEvento(long id);

}
