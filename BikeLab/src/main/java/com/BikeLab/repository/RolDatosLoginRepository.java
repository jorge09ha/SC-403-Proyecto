package com.BikeLab.repository;

import com.BikeLab.entity.RolDatosLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolDatosLoginRepository extends CrudRepository<RolDatosLogin, Long> {

}
