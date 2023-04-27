package com.BikeLab.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int telefono;
    private String cedula;
    private String direccion;    

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @ManyToOne
    @JoinColumn(name = "canton_id")
    private Canton canton;

    @ManyToOne
    @JoinColumn(name = "distrito_id")
    private Distrito distrito;
    
    @OneToOne
    @JoinColumn(name = "iddatoslogin")
     private DatosLogin datoslogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

             
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public DatosLogin getDatoslogin() {
        return datoslogin;
    }

    public void setDatoslogin(DatosLogin datoslogin) {
        this.datoslogin = datoslogin;
    }

     
        
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", telefono=" + telefono + ", cedula=" + cedula + ", direccion=" + direccion + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + '}';
    }

}




