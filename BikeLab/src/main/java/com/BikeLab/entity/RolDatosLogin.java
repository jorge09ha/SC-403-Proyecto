package com.BikeLab.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roldatoslogin")
public class RolDatosLogin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id")
    private DatosLogin datosLoginID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private Rol roleId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DatosLogin getDatosLoginID() {
        return datosLoginID;
    }

    public void setDatosLoginID(DatosLogin datosLoginID) {
        this.datosLoginID = datosLoginID;
    }

    public Rol getRoleId() {
        return roleId;
    }

    public void setRoleId(Rol roleId) {
        this.roleId = roleId;
    }
    
        
  

}
