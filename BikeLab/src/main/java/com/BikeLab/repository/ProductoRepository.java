package com.BikeLab.repository;

import com.BikeLab.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.tipoProducto.familiaproducto.familia = :familia")
    List<Producto> findByFamilia(@Param("familia") String familia);

    @Query("SELECT p FROM Producto p WHERE "
            + "LOWER(p.nombre) LIKE LOWER(CONCAT('%', :search, '%')) OR "
            + "LOWER(p.modelo) LIKE LOWER(CONCAT('%', :search, '%')) OR "
            + "LOWER(p.tipoProducto.tipo) LIKE LOWER(CONCAT('%', :search, '%')) OR "
            + "LOWER(p.marca.nombre) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Producto> findBySearch(@Param("search") String search);

}
