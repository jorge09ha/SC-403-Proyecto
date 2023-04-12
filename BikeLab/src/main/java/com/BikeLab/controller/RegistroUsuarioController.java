
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
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistroUsuarioController {
    
@Autowired
private IUsuarioService usuarioService;

 @Autowired
    private IRolService rolesService;
    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private ICantonService cantonService;

    @Autowired
    private IDistritoService distritoService;
      
@GetMapping("/registro/usuario/nuevo")
    public String crearUsuario(Model model) {
        List<Distrito> listaD = distritoService.getAllDistrito();
        List<Canton> listaC = cantonService.getAllCanton();
        List<Provincia> listaP = provinciaService.getAllProvincia();
        List<Rol> rol = rolesService.getAllRole();
        model.addAttribute("titulo", "Registro de usuario");
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("distrito", listaD);
        model.addAttribute("canton", listaC);
        model.addAttribute("provincia", listaP);        
        model.addAttribute("rol", rol);
        return "registroUsuario";
    }

    
    @PostMapping("/guardar/usuario")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/tienda_home";
    }
    
    
}
