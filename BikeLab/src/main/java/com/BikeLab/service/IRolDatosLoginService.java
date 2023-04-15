/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BikeLab.service;

import com.BikeLab.entity.RolDatosLogin;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bperez
 */
@Service
public interface IRolDatosLoginService {
    
     public RolDatosLogin saveRol(RolDatosLogin rolUsuario);
     
     public RolDatosLogin getCantonById(long id);
    
    public List<RolDatosLogin> getAllUserRole();
    
}
