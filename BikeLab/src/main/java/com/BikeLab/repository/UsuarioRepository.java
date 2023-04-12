package com.BikeLab.repository;

import com.BikeLab.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    //Custom query
 @Query(value = "select u.*,r.rol from bikelab.usuario as u inner join bikelab.rolusuario ru on u.id =  ru.usuario_id inner join bikelab.rol r on ru.rol_id = r.id ", nativeQuery = true)
 List<Usuario> findAllUser();

}
