package com.BikeLab.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String cedula;
    private String direccion;

    @OneToOne
    @JoinColumn(name = "idLogin")
    private Datos_Login idLogin;

    @ManyToOne
    @JoinColumn(name = "IdProvincia")
    private Provincia IdProvincia;

    @ManyToOne
    @JoinColumn(name = "idCanton")
    private Canton idCanton;

    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito idDistrito;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Datos_Login getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Datos_Login idLogin) {
        this.idLogin = idLogin;
    }

    public Provincia getIdProvincia() {
        return IdProvincia;
    }

    public void setIdProvincia(Provincia IdProvincia) {
        this.IdProvincia = IdProvincia;
    }

    public Canton getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Canton idCanton) {
        this.idCanton = idCanton;
    }

    public Distrito getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Distrito idDistrito) {
        this.idDistrito = idDistrito;
    }
  
}
