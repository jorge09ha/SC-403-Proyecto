package com.BikeLab.service;

import com.BikeLab.entity.Provincia;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProvinciaService {

    public List<Provincia> getAllProvincia();

    public Provincia getProvinciaById(long id);

    public void saveProvincia(Provincia provincia);

    public void deleteProvincia(long id);

}
