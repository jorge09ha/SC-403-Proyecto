/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BikeLab.repository;

import com.BikeLab.entity.DatosLogin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bperez
 */
@Repository
public interface DatosLoginRepository extends JpaRepository<DatosLogin, Long> {
    
        //Custom query
 @Query(value = "select dl.*,rol.rol from bikelab.datoslogin dl join bikelab.roldatoslogin rdl on dl.id = rdl.usuario_id join bikelab.rol on rdl.rol_id = rol.id", nativeQuery = true)
 List<DatosLogin> findAllUser();     
 
 @Query(value = "select dl.*,rol.rol from bikelab.roldatoslogin rdl join bikelab.datoslogin dl on rdl.usuario_id = dl.id join bikelab.rol on rdl.rol_id = rol.id", nativeQuery = true)
 List<DatosLogin> findByRol();   
 

 @Query(value = "select distinct(dl.email),dl.id,dl.password from bikelab.datoslogin dl", nativeQuery = true)
 List<DatosLogin> findByDistinctEmail();  
 
  DatosLogin findByemail(String email);

    
}
