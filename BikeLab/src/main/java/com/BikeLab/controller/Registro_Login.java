/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.controller;

import com.BikeLab.WebSecurityConfig;
import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Rol;
import com.BikeLab.entity.RolDatosLogin;
import com.BikeLab.service.IDatosLoginService;
import com.BikeLab.service.IRolDatosLoginService;
import com.BikeLab.service.IRolService;
import com.BikeLab.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.hibernate.bytecode.BytecodeLogging.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    

    @GetMapping("/login")
    public String index() {
        return "/login";
    }

 @PostMapping("/login")
public String login(HttpServletRequest request, @RequestParam String email, @RequestParam String password, Model model) {

    try {
        DatosLogin datosLogin = this.datosLoginService.findByEmail(email);
        if (datosLogin != null) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Obtener la sesión HTTP del usuario autenticado
            HttpSession session = request.getSession();

            // Almacenar información en la sesión
            session.setAttribute("userId", datosLogin.getId());

            return "redirect:/";
        } else {
            LOGGER.error("Entro al else " );
            model.addAttribute("error", "Correo electrónico o contraseña incorrectos.");
            return "/login";
        }
    } catch (AuthenticationException ex) {
        LOGGER.error("Error de autenticación: " + ex.getMessage());
        model.addAttribute("error", "Correo electrónico o contraseña incorrectos.");
        return "/login";
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
    public String guardarUsuario(@ModelAttribute("usuario") DatosLogin usuario, BindingResult result, RedirectAttributes attributes) {
        try {
            datosLoginService.saveUsuario(usuario);            
            return "redirect:/login/nuevo?exito";
        } catch (DataIntegrityViolationException e) {
            LOGGER.info("error de registro" +e);
            return "redirect:/login/nuevo?error";
        }
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





