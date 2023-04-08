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
        return "adm_VerRoles";
    }

    @GetMapping("/admin/datos_login")
    public String indexDatosLogin(Model model) {
        List<DatosLogin> lista = datosLoginService.getAllDatosLogin();
        model.addAttribute("titulo", "Datos Login");
        model.addAttribute("datosLogin", lista);
        return "adm_VerDatosLogin";
    }

    @GetMapping("/admin/usuario")
    public String indexUsuario(Model model) {
        List<Usuario> lista = usuarioService.getAllUsuario();
        model.addAttribute("titulo", "USUARIOS");
        model.addAttribute("usuarios", lista);
        return "adm_VerUsuario";
    }
    //-------------------------- New --------------------------

    @GetMapping("/admin/rol/nuevo")
    public String crearRol(Model model) {
        Rol rol = new Rol();
        model.addAttribute("titulo", "Nuevo Rol");
        model.addAttribute("rol", rol);
        return "adm_crearRole";
    }

    @GetMapping("/admin/datos_login/nuevo")
    public String crearDatosLogin(Model model) {
        List<Rol> rol = rolesService.getAllRole();
        DatosLogin datosLogin = new DatosLogin();
        model.addAttribute("titulo", "Nuevo Rol");
        model.addAttribute("datosLogin", datosLogin);
        model.addAttribute("rol", rol);
        return "adm_crearDatosLogin";
    }

    //-------------------------- Save --------------------------
    @PostMapping("/save/rol")
    public String guardarRole(@ModelAttribute("rol") Rol rol) {
        rolesService.saveRole(rol);
        return "redirect:/admin/roles";
    }

    @PostMapping("/save/datosLogin")
    public String guardarDatosLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin) {
        datosLoginService.saveDatosLogin(datosLogin);
        return "redirect:/admin/datos_login";
    }

    //-------------------------- Delete --------------------------
    @GetMapping("/eliminar/rol/{id}")
    public String eliminarRole(@PathVariable Long id) {
        rolesService.deleteRole(id);
        return "redirect:/admin/roles";
    }

    @GetMapping("/eliminar/datosLogin/{id}")
    public String eliminarDatosLogin(@PathVariable Long id) {
        datosLoginService.deleteDatosLogin(id);
        return "redirect:/admin/datos_login";
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
    
        //*DatosLogin
    @GetMapping("/editar/datosLogin/{id}")
    public String editarDatosLogin(@PathVariable("id") Long id, Model model) {
        DatosLogin a = datosLoginService.getDatosLoginById(id);
        List<Rol> lista = rolesService.getAllRole();
        model.addAttribute("titulo", "Editar Rol");
        model.addAttribute("datosLogin", a);
        model.addAttribute("rol", lista);
        return "adm_editarDatosLogin";
    }

    @PostMapping("/editar/datosLogin/{id}")
    public String actualizarDatosLogin(@PathVariable Long id, @ModelAttribute("datosLogin") DatosLogin datosLogin) {
        DatosLogin editar = datosLoginService.getDatosLoginById(id);
        editar.setId(id);
        editar.setCorreo(datosLogin.getCorreo());
        editar.setContrasenia(datosLogin.getContrasenia());
        editar.setRol(datosLogin.getRol());
        datosLoginService.saveDatosLogin(editar);
        return "redirect:/admin/datos_login";
    }
}
