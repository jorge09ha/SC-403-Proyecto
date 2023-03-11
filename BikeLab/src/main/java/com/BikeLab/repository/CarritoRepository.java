package com.BikeLab.repository;

import com.BikeLab.entity.Carrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito, Long> {

}
