/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import com.BikeLab.repository.DatosLoginRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**

 *
 * @author bperez
 */
@Service
public class DatosLoginService implements IDatosLoginService {
    
     @Autowired
    private DatosLoginRepository usuarioRepository;
    
    BCryptPasswordEncoder cryp = new BCryptPasswordEncoder();
       

    @Override
    public List<DatosLogin> getAllUsuario() {
        return (List<DatosLogin>) usuarioRepository.findAll();
    }

    @Override
    public DatosLogin getUsuarioById(long id,long rol_id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public DatosLogin saveUsuario(DatosLogin usuario) {
        DatosLogin newUsuario = new DatosLogin(usuario.getEmail(), cryp.encode(usuario.getPassword()), usuario.getRoles());
        return usuarioRepository.save(newUsuario);
    }

    @Override
    public void deleteUsuario(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<DatosLogin> getAllUser() {
        return (List<DatosLogin>) usuarioRepository.findAllUser();
    }



    @Override
    public List<DatosLogin> getAllUserRole() {
        return (List<DatosLogin>) usuarioRepository.findByRol();
    }

    @Override
    public DatosLogin addRol(DatosLogin usuario) {
        DatosLogin newUsuario = new DatosLogin(usuario.getEmail(), usuario.getRoles());
        return usuarioRepository.save(newUsuario);
        
    }
    
 @Override
    public List<DatosLogin> getDistinctEmail() {
        return (List<DatosLogin>) usuarioRepository.findByDistinctEmail();
    }

    @Override
    public DatosLogin findAllUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DatosLogin findByEmail(String username) {
       return usuarioRepository.findByEmail(username);
    }
}


  


