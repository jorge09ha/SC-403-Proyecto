package com.BikeLab.service;

import com.BikeLab.entity.Proveedor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProveedorService {

    public List<Proveedor> getAllProveedor();

    public Proveedor getProveedorById(long id);

    public void saveProveedor(Proveedor proveedor);

    public void deleteProveedor(long id);

}
