/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.controller;

import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Rol;
import com.BikeLab.entity.RolDatosLogin;
import com.BikeLab.service.IDatosLoginService;
import com.BikeLab.service.IRolDatosLoginService;
import com.BikeLab.service.IRolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bperez
 */
@Controller
public class Registro_Login {
    
    @Autowired
    private IRolService roleService;
    
    @Autowired
    private IDatosLoginService datosLoginService;    
    
    @Autowired
    private IRolDatosLoginService rolDatosLoginService;
    
    
    //-------------------------- New --------------------------
    
    //------------------- Login----------------------------------
     @GetMapping("/ingreso/login")
    public String login(Model model) {
        model.addAttribute("usuario", new DatosLogin());
        return "login";
    }
    
    @PostMapping("/login/validacion")
    public String processLogin(@ModelAttribute("usuario") DatosLogin usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }        
        DatosLogin usuarioEncontrado = datosLoginService.findAllUser(usuario.getEmail());
        if (usuarioEncontrado != null && usuarioEncontrado.getEmail().equals(usuario.getEmail())) {
            return "redirect:/tienda_home";
        } else {
            bindingResult.rejectValue("username", "error.usuario", "Nombre de usuario o contraseña incorrecta");
            return "login";
        }
    }
     
    
    @GetMapping("/login/nuevo")
    public String crearUsuario(Model model) {
        List<Rol> rol = roleService.getAllRole();
        model.addAttribute("titulo", "Nuevo Usuario");
        model.addAttribute("usuario", new DatosLogin());       
        model.addAttribute("rol", rol);
        return "registroDatosLogin";
    }
    
   //------------------- Login---------------------------------- 
        
    @GetMapping("/admin/rol/nuevo")
    public String crearRol(Model model) {
        Rol rol = new Rol();
        model.addAttribute("titulo", "Nuevo Rol");
        model.addAttribute("rol", rol);
        return "adm_crearRole";
    }
    
    
    //-------------------------- Save --------------------------
    @PostMapping("/save/login")
    public String guardarUsuario(@ModelAttribute("usuario") DatosLogin usuario) {      
        datosLoginService.saveUsuario(usuario);
         return "redirect:/tienda_home";    
}
    
    
    
    //-------------------------- UpDate --------------------------
    //*Roles
    @GetMapping("/editar/rol/{id}")
    public String editarRol(@PathVariable("id") Long id, Model model) {
        Rol a = roleService.getRoleById(id);
        model.addAttribute("titulo", "Editar Rol");
        model.addAttribute("rol", a);
        return "adm_editarRol";
    }
    
    @PostMapping("/editar/rol/{id}")
    public String actualizarRol(@PathVariable Long id, @ModelAttribute("Rol") Rol rol) {
        Rol editar = roleService.getRoleById(id);
        editar.setId(id);
        editar.setRol(rol.getRol());
        roleService.saveRole(editar);
        return "redirect:/admin/roles";
    }

    
    //-------------------------- Delete --------------------------
    @GetMapping("/eliminar/rol/{id}")
    public String eliminarRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "redirect:/admin/roles";
    }
    
}
