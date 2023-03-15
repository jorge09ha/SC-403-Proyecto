package com.BikeLab.repository;

import com.BikeLab.entity.TipoProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends CrudRepository<TipoProducto, Long> {

}
