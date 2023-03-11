package com.BikeLab.repository;

import com.BikeLab.entity.DatosLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosLoginRepository extends CrudRepository<DatosLogin, Long> {

}
