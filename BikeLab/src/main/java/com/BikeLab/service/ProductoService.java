package com.BikeLab.service;

import com.BikeLab.entity.Producto;
import com.BikeLab.repository.ProductoRepository;
import com.BikeLab.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProducto() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findByFamilia(String familia) {
        return productoRepository.findByFamilia(familia);
    }

    @Override
    public List<Producto> findBySearch(String search) {
        return productoRepository.findBySearch(search);
    }

}
