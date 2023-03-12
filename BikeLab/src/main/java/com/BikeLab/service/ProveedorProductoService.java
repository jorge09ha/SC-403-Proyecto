package com.BikeLab.service;

import com.BikeLab.entity.ProveedorProducto;
import com.BikeLab.repository.ProveedorProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorProductoService implements IProveedorProductoService {

    @Autowired
    private ProveedorProductoRepository proveedorProductoRepository;

    @Override
    public List<ProveedorProducto> getAllProveedorProducto() {
        return (List<ProveedorProducto>) proveedorProductoRepository.findAll();

    }

    @Override
    public ProveedorProducto getProveedorProductoById(long id) {
        return proveedorProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProveedorProducto(ProveedorProducto proveedorProducto) {
        proveedorProductoRepository.save(proveedorProducto);
    }

    @Override
    public void deleteProveedorProducto(long id) {
        proveedorProductoRepository.deleteById(id);
    }

}
