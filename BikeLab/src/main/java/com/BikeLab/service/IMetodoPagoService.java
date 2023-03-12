package com.BikeLab.service;

import com.BikeLab.entity.MetodoPago;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IMetodoPagoService {

    public List<MetodoPago> getAllMetodoPago();

    public MetodoPago getMetodoPagoById(long id);

    public void saveMetodoPago(MetodoPago metodoPago);

    public void deleteMetodoPago(long id);

}
