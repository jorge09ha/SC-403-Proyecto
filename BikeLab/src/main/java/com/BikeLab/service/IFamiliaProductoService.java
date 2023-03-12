package com.BikeLab.service;

import com.BikeLab.entity.FamiliaProducto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IFamiliaProductoService {

    public List<FamiliaProducto> getAllFamiliaProducto();

    public FamiliaProducto getFamiliaProductooById(long id);

    public void saveFamiliaProducto(FamiliaProducto familiaProducto);

    public void deleteFamiliaProducto(long id);

}
