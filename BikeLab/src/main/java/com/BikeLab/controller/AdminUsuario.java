package com.BikeLab.controller;

import com.BikeLab.entity.Canton;
import com.BikeLab.entity.Distrito;
import com.BikeLab.entity.Provincia;
import com.BikeLab.entity.Rol;
import com.BikeLab.entity.Usuario;
import com.BikeLab.service.ICantonService;
import com.BikeLab.service.IDistritoService;
import com.BikeLab.service.IProvinciaService;
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
    private IUsuarioService usuarioService;

    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private ICantonService cantonService;

    @Autowired
    private IDistritoService distritoService;

    //-------------------------- List --------------------------
    @GetMapping("/admin/roles")
    public String indexRoles(Model model) {
        List<Rol> lista = rolesService.getAllRole();
        model.addAttribute("titulo", "Roles de Usuario");
        model.addAttribute("roles", lista);
        return "adm_VerRoles";
    }

    @GetMapping("/admin/usuario")
    public String indexUsuario(Model model) {
        List<Usuario> rolUsuario = usuarioService.getAllUser();   
       model.addAttribute("titulo", "USUARIOS");
       model.addAttribute("usuarios", rolUsuario);
        return "adm_VerUsuario";
    }

    //-------------------------- New --------------------------
    
    @GetMapping("/admin/usuario/nuevo")
    public String crearUsuario(Model model) {
        List<Distrito> listaD = distritoService.getAllDistrito();
        List<Canton> listaC = cantonService.getAllCanton();
        List<Provincia> listaP = provinciaService.getAllProvincia();
        List<Rol> rol = rolesService.getAllRole();
        model.addAttribute("titulo", "Nuevo Usuario");
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("distrito", listaD);
        model.addAttribute("canton", listaC);
        model.addAttribute("provincia", listaP);
        model.addAttribute("rol", rol);
        return "adm_crearUsuario";
    }

    //-------------------------- Save --------------------------
   
    @PostMapping("/save/usuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {      
        usuarioService.saveUsuario(usuario);
        return "redirect:/admin/usuario";
    }

    //-------------------------- Delete --------------------------    
    @GetMapping("/eliminar/usuario/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/admin/usuario";
    }

    //-------------------------- UpDate --------------------------
    //*Usuario
    @GetMapping("/editar/usuario/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        List<Rol> listRol = rolesService.getAllRole();
        List<Distrito> listaD = distritoService.getAllDistrito();
        List<Canton> listaC = cantonService.getAllCanton();
        List<Provincia> listaP = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "Editar Usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("rol", listRol);
        model.addAttribute("distrito", listaD);
        model.addAttribute("canton", listaC);
        model.addAttribute("provincia", listaP);
        return "adm_editarUsuario";
    }

    @PostMapping("/editar/usuario/{id}")
    public String actualizarUsuario(@PathVariable Long id, @ModelAttribute("Usuario") Usuario usuario) {
        Usuario editarUsuario = usuarioService.getUsuarioById(id);
        editarUsuario.setId(id);
        editarUsuario.setNombre(usuario.getNombre());
        editarUsuario.setApellido1(usuario.getApellido1());
        editarUsuario.setApellido2(usuario.getApellido2());
        editarUsuario.setTelefono(usuario.getTelefono());
        editarUsuario.setCedula(usuario.getCedula());
        editarUsuario.setDireccion(usuario.getDireccion());
        editarUsuario.setCorreo(usuario.getCorreo());
        editarUsuario.setPassword(usuario.getPassword());
        editarUsuario.setRoles(usuario.getRoles());
        editarUsuario.setProvincia(usuario.getProvincia());
        editarUsuario.setCanton(usuario.getCanton());
        editarUsuario.setDistrito(usuario.getDistrito());
        usuarioService.saveUsuario(editarUsuario);
        return "redirect:/admin/usuario";
    }

}
