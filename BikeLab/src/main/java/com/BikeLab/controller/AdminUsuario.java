package com.BikeLab.controller;

import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Rol;
import com.BikeLab.entity.Usuario;
import com.BikeLab.service.IDatosLoginService;
import com.BikeLab.service.IRolService;
import com.BikeLab.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Jorge Hernandez Araya | jorge09ha
 */
@Controller
public class AdminUsuario {

    @Autowired
    private IRolService rolesService;

    @Autowired
    private IDatosLoginService datosLoginService;

    @Autowired
    private IUsuarioService usuarioService;

    //-------------------------- List --------------------------
    @GetMapping("/admin/roles")
    public String indexRoles(Model model) {
        List<Rol> lista = rolesService.getAllRole();
        model.addAttribute("titulo", "Roles de Usuario");
        model.addAttribute("roles", lista);
        return "adm_roles";
    }

    @GetMapping("/admin/datos_login")
    public String indexDatosLogin(Model model) {
        List<DatosLogin> lista = datosLoginService.getAllDatosLogin();
        model.addAttribute("titulo", "Datos Login");
        model.addAttribute("datosLogin", lista);
        return "adm_datosLogin";
    }

    @GetMapping("/admin/usuario")
    public String indexUsuario(Model model) {
        List<Usuario> lista = usuarioService.getAllUsuario();
        model.addAttribute("titulo", "USUARIOS");
        model.addAttribute("usuarios", lista);
        return "adm_usuario";
    }
    //-------------------------- New --------------------------

    @GetMapping("/admin/roles/nuevo")
    public String crearRole(Model model) {
        Rol rol = new Rol();
        model.addAttribute("titulo", "Rol Nuevo");
        model.addAttribute("rol", rol);
        return "adm_crearRole";
    }

    //-------------------------- Save --------------------------
    @PostMapping("/save/rol")
    public String guardarRole(@ModelAttribute("rol") Rol rol) {
        rolesService.saveRole(rol);
        return "redirect:/admin/roles";
    }

    //-------------------------- Delete --------------------------
    @GetMapping("/eliminar/rol/{id}")
    public String eliminarRole(@PathVariable Long id) {
        rolesService.deleteRole(id);
        return "redirect:/admin/roles";
    }

    //-------------------------- UpDate --------------------------
    //*Roles
    @GetMapping("/editar/rol/{id}")
    public String editarRol(@PathVariable("id") Long id, Model model) {
        Rol a = rolesService.getRoleById(id);
        model.addAttribute("titulo", "Editar Rol");
        model.addAttribute("rol", a);
        return "adm_editarRol";
    }

    @PostMapping("/editar/rol/{id}")
    public String actualizarRol(@PathVariable Long id, @ModelAttribute("Rol") Rol rol) {
        Rol editar = rolesService.getRoleById(id);
        editar.setId(id);
        editar.setRol(rol.getRol());
        rolesService.saveRole(editar);
        return "redirect:/admin/roles";
    }
}
