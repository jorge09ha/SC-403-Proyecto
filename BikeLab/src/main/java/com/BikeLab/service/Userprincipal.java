/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.service;

import com.BikeLab.entity.DatosLogin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bperez
 */
public class Userprincipal implements UserDetails {
    
    private DatosLogin datosLogin;

    public Userprincipal(DatosLogin datosLogin) {
        if (datosLogin == null || datosLogin.getPassword() == null) {
        throw new IllegalArgumentException("DatosLogin o password es nulo");
    }
    this.datosLogin = datosLogin;
    }
           

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         List<GrantedAuthority> authorities = new ArrayList<>();      
        this.datosLogin.getRoles().forEach(r -> {
       GrantedAuthority authority = new SimpleGrantedAuthority(r.getRol());
       authorities.add(authority);
      });
       return authorities;
    }

    @Override
    public String getPassword() {    
       return this.datosLogin.getPassword();
    }

    @Override
    public String getUsername() {
       return this.datosLogin.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
         return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
         return true;
    }
    
}


