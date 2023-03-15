package com.BikeLab.repository;

import com.BikeLab.entity.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {

}
