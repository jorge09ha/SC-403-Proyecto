/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author bperez
 */
@Service
public interface IDatosLoginService {
    
      public List<DatosLogin> getAllUsuario();

    public DatosLogin getUsuarioById(long id,long rol_Id);

    public DatosLogin saveUsuario(DatosLogin usuario);
    
    public DatosLogin addRol(DatosLogin usuario);

    public void deleteUsuario(long id);

    public List<DatosLogin> getAllUser();

    public DatosLogin findAllUser(String username);
    
  public List<DatosLogin> getAllUserRole();
  
   public List<DatosLogin> getDistinctEmail();
   
  public DatosLogin findByEmail(String username);
  
  public DatosLogin getDTById(long id);
  
 
    
}
