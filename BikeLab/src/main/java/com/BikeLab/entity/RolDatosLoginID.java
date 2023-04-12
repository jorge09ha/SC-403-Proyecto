/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.entity;

import java.io.Serializable;

/**
 *
 * @author bperez
 */
public class RolDatosLoginID implements Serializable {
    
    private Long usuario_id;
    private Long rol_id;
    
    public RolDatosLoginID() {
    }

    public RolDatosLoginID(Long usuario_id, Long rol_id) {
        this.usuario_id = usuario_id;
        this.rol_id = rol_id;
    }
    

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Long getRol_id() {
        return rol_id;
    }

    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }
    
    
    
}
