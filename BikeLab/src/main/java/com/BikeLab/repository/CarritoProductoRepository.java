package com.BikeLab.repository;

import com.BikeLab.entity.CarritoProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoProductoRepository extends CrudRepository<CarritoProducto, Long> {
    
}
