package com.BikeLab.repository;

import com.BikeLab.entity.MetodoPago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepository extends CrudRepository<MetodoPago, Long> {

}
