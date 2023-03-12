package com.BikeLab.service;

import com.BikeLab.entity.Marca;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IMarcaService {

    public List<Marca> getAllMarca();

    public Marca getMarcaById(long id);

    public void saveMarca(Marca marca);

    public void deleteMarca(long id);

}
