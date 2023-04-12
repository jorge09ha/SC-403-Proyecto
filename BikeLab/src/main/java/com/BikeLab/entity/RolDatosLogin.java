/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author bperez
 */
@Entity
@Table(name = "roldatoslogin")
public class RolDatosLogin {

    @EmbeddedId
    private RolDatosLoginID rolDatosLogin;

    public RolDatosLogin() {
    }

    public RolDatosLogin(RolDatosLoginID rolDatosLogin) {
        this.rolDatosLogin = rolDatosLogin;
    }

    public RolDatosLoginID getRolDatosLogin() {
        return rolDatosLogin;
    }

    public void setRolDatosLogin(RolDatosLoginID rolDatosLogin) {
        this.rolDatosLogin = rolDatosLogin;
    }

}
