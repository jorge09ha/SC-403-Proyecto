package com.BikeLab.repository;

import com.BikeLab.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
