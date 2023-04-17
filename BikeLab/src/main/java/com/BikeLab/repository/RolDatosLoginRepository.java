/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BikeLab.repository;

import com.BikeLab.entity.RolDatosLogin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author bperez
 */
public interface RolDatosLoginRepository extends JpaRepository<RolDatosLogin, Long>  {
    
     @Query(value = "select dl.*,rol.rol from bikelab.roldatoslogin rdl join bikelab.datoslogin dl on rdl.usuario_id = dl.id join bikelab.rol on rdl.rol_id = rol.id", nativeQuery = true)
 List<RolDatosLogin> findByRol();
 
   @Modifying
@Query("delete from RolDatosLogin r where r.rolDatosLogin.usuario_id = :id and r.rolDatosLogin.rol_id = :rolId")
void eliminarRegistrosTablaIntermedia(@Param("id") long id, @Param("rolId") long rolId);
    
}
