package com.BikeLab.repository;

import com.BikeLab.entity.FamiliaProducto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaProductoRepository extends CrudRepository<FamiliaProducto, Long> {

}
