/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.service;

import com.BikeLab.entity.RolDatosLogin;
import com.BikeLab.repository.RolDatosLoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bperez
 */
@Service
public class RolDatosLoginService  implements IRolDatosLoginService {
    
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
      rolDatosLoginRepository.eliminarRegistrosTablaIntermedia(id, rolId);
    }
    
    
}
