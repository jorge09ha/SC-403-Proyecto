/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.service;

import com.BikeLab.entity.RolDatosLogin;
import com.BikeLab.repository.RolDatosLoginRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bperez
 */
@Service
public class RolDatosLoginService  implements IRolDatosLoginService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private RolDatosLoginRepository rolDatosLoginRepository;

    @Override
    public RolDatosLogin saveRol(RolDatosLogin rolUsuario) {
        return rolDatosLoginRepository.save(rolUsuario);
    }

    @Override
    public List<RolDatosLogin> getAllUserRole() {
      return (List<RolDatosLogin>)rolDatosLoginRepository.findAll();
    }

    @Override
    public RolDatosLogin getCantonById(long id) {
       return rolDatosLoginRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUsuario(long id, long rolId) {
         // Llamada al SP para eliminar registros sin rol asociado para el usuario con el email proporcionado    
      rolDatosLoginRepository.eliminarRegistrosTablaIntermedia(id, rolId);       
    }
    
    
}
