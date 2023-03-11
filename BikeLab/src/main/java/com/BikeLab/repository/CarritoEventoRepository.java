package com.BikeLab.repository;

import com.BikeLab.entity.CarritoEvento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoEventoRepository extends CrudRepository<CarritoEvento, Long> {
    
}
