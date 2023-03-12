package com.BikeLab.service;

import com.BikeLab.entity.Orden;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IOrdenService {

    public List<Orden> getAllOrden();

    public Orden getOrdenById(long id);

    public void saveOrden(Orden orden);

    public void deleteOrden(long id);

}