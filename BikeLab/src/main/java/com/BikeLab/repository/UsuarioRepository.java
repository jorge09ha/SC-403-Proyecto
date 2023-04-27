package com.BikeLab.repository;

import com.BikeLab.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select  u.id,u.nombre,u.apellido1,u.apellido2,u.telefono,u.cedula,u.direccion,u.provincia_id,u.canton_id,u.distrito_id,u.iddatoslogin from usuario u where u.iddatoslogin = :loginId" , nativeQuery = true)
         Usuario getUserById(@Param("loginId") Long userId);
            

}
