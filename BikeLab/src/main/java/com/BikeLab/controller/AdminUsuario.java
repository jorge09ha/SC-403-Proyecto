package com.BikeLab.controller;

import com.BikeLab.entity.Canton;
import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Distrito;
import com.BikeLab.entity.Provincia;
import com.BikeLab.entity.Rol;
import com.BikeLab.entity.RolDatosLogin;
import com.BikeLab.entity.Usuario;
import com.BikeLab.service.ICantonService;
import com.BikeLab.service.IDatosLoginService;
import com.BikeLab.service.IDistritoService;
import com.BikeLab.service.IProvinciaService;
import com.BikeLab.service.IRolDatosLoginService;
import com.BikeLab.service.IRolService;
import com.BikeLab.service.IUsuarioService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @Autowired
    private IDatosLoginService datosLoginService; 
    
     @Autowired
    private IRolDatosLoginService rolDatosLoginService;

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
      
    @GetMapping("/admin/datosLogin")
    public String indexdatosLoginRol(Model model) {
        List<DatosLogin> rolUsuario = datosLoginService.getAllUser();
       model.addAttribute("titulo", "USUARIOS");
       model.addAttribute("rolUsuario", rolUsuario);
        return "adm_VerDatosLoginRol";
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
    
    @GetMapping("/admin/DatosLoginRol/add")
    public String agregarRol(Model model) { 
        List<Rol> rol = rolesService.getAllRole();
        List<DatosLogin> usuario =datosLoginService.getDistinctEmail();
        model.addAttribute("titulo", "Agregar Rol a usuario");
        model.addAttribute("rolUsuario", new RolDatosLogin());       
        model.addAttribute("rol", rol);
        model.addAttribute("email",usuario);
        return "adm_agregarRolUsuario";
    }

    //-------------------------- Save --------------------------
   
    @PostMapping("/save/usuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {      
        usuarioService.saveUsuario(usuario);
        return "redirect:/admin/usuario";
    }
    
    @PostMapping("/save/rol")
    public String guardarRol(@ModelAttribute("usuario") RolDatosLogin usuario) {      
        rolDatosLoginService.saveRol(usuario);
         return "redirect:/admin/datosLogin";    
}

    //-------------------------- Delete --------------------------    
    @GetMapping("/eliminar/usuario/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/admin/usuario";
    }
    
    @Transactional
    @GetMapping("/eliminar/datosLogin/{id}/{rol_id}")
    public String eliminarDatosLogin(@PathVariable Long id,@PathVariable Long rol_id) {
        rolDatosLoginService.deleteUsuario(id, rol_id);  
        return "redirect:/admin/datosLogin";
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
        editarUsuario.setProvincia(usuario.getProvincia());
        editarUsuario.setCanton(usuario.getCanton());
        editarUsuario.setDistrito(usuario.getDistrito());
        usuarioService.saveUsuario(editarUsuario);
        return "redirect:/admin/usuario";
    }
    
    @GetMapping("/editar/RoldatosLogin/{id}/{rol_id}")
    public String editarDatosLogin(@PathVariable("id") Long id, @PathVariable("rol_id") Long rol_id,Model model) {
        DatosLogin editarUsuario = datosLoginService.getUsuarioById(id,rol_id);
          List<Rol> rol = rolesService.getAllRole(); 
        model.addAttribute("titulo", "Editar Rol a usuario");
        model.addAttribute("rolUsuario", editarUsuario);
        model.addAttribute("rol", rol);
        return "adm_editarDatosLogin";
    }
    
    @PostMapping("/editar/RoldatosLogin/{id}/{rol_id}")
    public String actualizarDatosLogin(@PathVariable Long id,  @PathVariable("rol_id") Long rol_id,@ModelAttribute("DatosLogin") DatosLogin usuario) {
        DatosLogin editarUsuario = datosLoginService.getUsuarioById(id,rol_id);
        editarUsuario.setId(id);
        editarUsuario.setEmail(usuario.getEmail());
        editarUsuario.setPassword(usuario.getPassword());
        editarUsuario.setRoles(usuario.getRoles());
        datosLoginService.saveUsuario(editarUsuario);
        return "redirect:/admin/datosLogin";
    }
    
    

}
