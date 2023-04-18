package com.BikeLab.entity;

import com.BikeLab.entity.FamiliaProducto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipoproducto")
public class TipoProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "familia_id")
    private FamiliaProducto familiaproducto;

    @OneToMany(mappedBy = "tipoProducto")
    private List<Producto> productos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public FamiliaProducto getFamiliaproducto() {
        return familiaproducto;
    }

    public void setFamiliaproducto(FamiliaProducto familiaproducto) {
        this.familiaproducto = familiaproducto;
    }

    @Override
    public String toString() {
        return "TipoProducto{" + "id=" + id + ", tipo=" + tipo + ", detalle=" + detalle + ", familiaproducto=" + familiaproducto + '}';
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    

}
