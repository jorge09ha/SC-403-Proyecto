
package com.BikeLab.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Canton implements Serializable {
    
 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)   
 private Long idCanton;
 private String nombre;
 
 @ManyToOne
 @JoinColumn(name="idProvincia")
    private String idProvincia;

    public Long getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(Long idCanton) {
        this.idCanton = idCanton;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }
 
 }
