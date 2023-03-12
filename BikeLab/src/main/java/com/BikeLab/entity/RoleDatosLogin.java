package com.BikeLab.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roleDatosLogin")
public class RoleDatosLogin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinColumn(name = "idRole")
    private Role role;

    @ManyToMany
    @JoinColumn(name = "idLogin")
    private DatosLogin datosLogin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public DatosLogin getDatosLogin() {
        return datosLogin;
    }

    public void setDatosLogin(DatosLogin datosLogin) {
        this.datosLogin = datosLogin;
    }

}
