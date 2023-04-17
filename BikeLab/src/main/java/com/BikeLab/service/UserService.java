/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import java.util.logging.Logger;
import static org.hibernate.bytecode.BytecodeLogging.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bperez
 */
@Service
public class UserService implements UserDetailsService {
    
     @Autowired
 public IDatosLoginService datosLoginService;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//      DatosLogin datosLogin = this.datosLoginService.findByEmail(username);
//       Userprincipal userPrincipal =  new Userprincipal(datosLogin);
//        return userPrincipal;
//    }
    
    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  LOGGER.info("Buscando usuario con correo: " + username);
    System.out.println("username: " + username);
    DatosLogin datosLogin = this.datosLoginService.findByEmail(username);
    System.out.println("datosLogin: " + datosLogin);
    if (datosLogin == null) {
        throw new UsernameNotFoundException("Usuario no encontrado");
    }
    Userprincipal userPrincipal = new Userprincipal(datosLogin);
    return userPrincipal;
}
    
}
