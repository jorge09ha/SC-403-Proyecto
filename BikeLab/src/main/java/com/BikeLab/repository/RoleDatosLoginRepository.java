package com.BikeLab.repository;

import com.BikeLab.entity.RoleDatosLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDatosLoginRepository extends CrudRepository<RoleDatosLogin, Long> {

}
