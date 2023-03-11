package com.BikeLab.repository;

import com.BikeLab.entity.Canton;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantonRepository extends CrudRepository<Canton, Long> {
    
}
