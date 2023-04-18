package com.BikeLab.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "familiaproducto")
public class FamiliaProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String familia;
    private String detalle;

    @OneToMany(mappedBy = "familiaproducto")
    private List<TipoProducto> tipos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "FamiliaProducto{" + "id=" + id + ", familia=" + familia + ", detalle=" + detalle + '}';
    }

    public List<TipoProducto> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoProducto> tipos) {
        this.tipos = tipos;
    }

}
