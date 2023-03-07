
package com.BikeLab.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TipoProducto implements Serializable {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long idTipo;  
 private String tipoProducto;
 private String detalle;
 
 @ManyToOne
 @JoinColumn(name="idFamilia")
 private FamiliaProducto idFamilia;

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public FamiliaProducto getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(FamiliaProducto idFamilia) {
        this.idFamilia = idFamilia;
    }
 
  
}
