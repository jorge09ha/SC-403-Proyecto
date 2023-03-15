package com.BikeLab.service;

import com.BikeLab.entity.Producto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IProductoService {

    public List<Producto> getAllProducto();

    public Producto getProductoById(long id);

    public void saveProducto(Producto producto);

    public void deleteProducto(long id);

}
