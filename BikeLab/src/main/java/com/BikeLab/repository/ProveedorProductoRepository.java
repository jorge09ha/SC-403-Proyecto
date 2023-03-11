package com.BikeLab.repository;

import com.BikeLab.entity.ProveedorProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorProductoRepository extends CrudRepository<ProveedorProducto, Long> {

}
