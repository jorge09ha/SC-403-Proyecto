package com.BikeLab.service;

import com.BikeLab.entity.FamiliaProducto;
import com.BikeLab.repository.FamiliaProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliaProductoService implements IFamiliaProductoService {

    @Autowired
    private FamiliaProductoRepository familiaProductoRepository;

    @Override
    public List<FamiliaProducto> getAllFamiliaProducto() {
        return (List<FamiliaProducto>) familiaProductoRepository.findAll();
    }

    @Override
    public FamiliaProducto getFamiliaProductoById(long id) {
        return familiaProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveFamiliaProducto(FamiliaProducto familiaProducto) {
        familiaProductoRepository.save(familiaProducto);
    }

    @Override
    public void deleteFamiliaProducto(long id) {
        familiaProductoRepository.deleteById(id);
    }

}
