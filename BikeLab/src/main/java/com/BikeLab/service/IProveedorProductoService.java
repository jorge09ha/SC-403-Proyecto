package com.BikeLab.service;

import com.BikeLab.entity.ProveedorProducto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProveedorProductoService {

    public List<ProveedorProducto> getAllProveedorProducto();

    public ProveedorProducto getProveedorProductoById(long id);

    public void saveProveedorProducto(ProveedorProducto proveedorProducto);

    public void deleteProveedorProducto(long id);

}
