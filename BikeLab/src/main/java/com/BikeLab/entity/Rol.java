package com.BikeLab.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    @Column(name="rol")
    private String rolName;
    
        
    @ManyToMany(mappedBy = "roles")
    private Set<DatosLogin> roles = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }


    public Set<DatosLogin> getRoles() {
        return roles;
    }

    public void setRoles(Set<DatosLogin> roles) {
        this.roles = roles;
    }

  
    
}
