package com.BikeLab.service;

import com.BikeLab.entity.Proveedor;
import com.BikeLab.repository.ProveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getAllProveedor() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    @Override
    public Proveedor getProveedorById(long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public void deleteProveedor(long id) {
        proveedorRepository.deleteById(id);
    }

}
