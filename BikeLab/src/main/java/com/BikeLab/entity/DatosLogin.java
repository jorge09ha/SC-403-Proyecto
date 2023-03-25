package com.BikeLab.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "datoslogin")
public class DatosLogin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private long Id;
    
    private String correo;
    private String contrasenia;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "roldatoslogin",
               joinColumns = @JoinColumn(name = "login_id"),
               inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
    @OneToOne
    @JoinColumn(name = "id")   
    private Usuario usuarioId;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

      
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
        
    
}
