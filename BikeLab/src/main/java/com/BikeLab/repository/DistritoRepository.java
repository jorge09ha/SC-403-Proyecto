package com.BikeLab.repository;

import com.BikeLab.entity.Distrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Long> {

}
