package com.BikeLab.controller;

import com.BikeLab.WebSecurityConfig;
import com.BikeLab.entity.Canton;
import com.BikeLab.entity.DatosLogin;
import com.BikeLab.entity.Distrito;
import com.BikeLab.entity.Evento;
import com.BikeLab.entity.Marca;
import com.BikeLab.entity.Producto;
import com.BikeLab.entity.Provincia;
import com.BikeLab.entity.Rol;
import com.BikeLab.entity.TipoProducto;
import com.BikeLab.entity.Usuario;
import com.BikeLab.service.ICantonService;
import com.BikeLab.service.IDatosLoginService;
import com.BikeLab.service.IDistritoService;
import com.BikeLab.service.IEventoService;
import com.BikeLab.service.IMarcaService;
import com.BikeLab.service.IProductoService;
import com.BikeLab.service.IProvinciaService;
import com.BikeLab.service.IRolService;
import com.BikeLab.service.ITipoProductoService;
import com.BikeLab.service.IUsuarioService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.hibernate.bytecode.BytecodeLogging.LOGGER;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Tienda {

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ITipoProductoService tipoProductoService;

    @Autowired
    private IMarcaService marcaService;

    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private ICantonService cantonService;

    @Autowired
    private IDistritoService distritoService;

    @Autowired
    private IRolService rolesService;

    @Autowired
    private IUsuarioService usuarioService;
 @Autowired
    private IDatosLoginService datosLoginService;
 
 @Autowired
private HttpServletRequest request;
 
 @Autowired
private WebSecurityConfig webSecurityConfig;

    //-------------------------- List --------------------------
    @GetMapping("/")
    public String index(Model model, HttpSession session) {        

     Long userId = (Long) session.getAttribute("userId"); 
        model.addAttribute("titulo", "HOME");
        List<Evento> lista = eventoService.getAllEvento();
        List<Producto> lista1 = productoService.findByFamilia("Bicicletas");
        model.addAttribute("titulo", "EVENTOS");
        model.addAttribute("eventos", lista);
        model.addAttribute("productos", lista1);
        model.addAttribute("userId", userId);
        return "tienda_home";
    }

    @GetMapping("/bicicletas")
    public String bicicletas(Model model) {
        List<Producto> lista = productoService.findByFamilia("Bicicletas");
        model.addAttribute("titulo", "BICICLETAS");
        model.addAttribute("productos", lista);
        return "tienda_bicicletas";
    }

    @GetMapping("/componentes")
    public String componentes(Model model) {
        List<Producto> lista = productoService.findByFamilia("Componentes");
        model.addAttribute("titulo", "COMPONENTES");
        model.addAttribute("productos", lista);
        return "tienda_componentes";
    }

    @GetMapping("/vestimenta")
    public String vestimenta(Model model) {
        List<Producto> lista = productoService.findByFamilia("Vestimenta");
        model.addAttribute("titulo", "VESTIMENTA");
        model.addAttribute("productos", lista);
        return "tienda_vestimenta";
    }

    @GetMapping("/accesorios")
    public String accesorios(Model model) {
        List<Producto> lista = productoService.findByFamilia("Accesorios");
        model.addAttribute("titulo", "ACCESORIOS");
        model.addAttribute("productos", lista);
        return "tienda_accesorios";
    }

    @GetMapping("/eventos")
    public String indexEvento(Model model) {
        List<Evento> lista = eventoService.getAllEvento();
        model.addAttribute("titulo", "EVENTOS");
        model.addAttribute("eventos", lista);
        return "tienda_eventos";
    }

    @GetMapping("/evento/{id}")
    public String editarEvento(@PathVariable("id") Long id, Model model) {
        Evento evento = eventoService.getEventoById(id);
        List<TipoProducto> listaTipo = tipoProductoService.getAllTipoProducto();
        List<Distrito> listaD = distritoService.getAllDistrito();
        List<Canton> listaC = cantonService.getAllCanton();
        List<Provincia> listaP = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "Evento");
        model.addAttribute("evento", evento);
        model.addAttribute("tipoProducto", listaTipo);
        model.addAttribute("distrito", listaD);
        model.addAttribute("canton", listaC);
        model.addAttribute("provincia", listaP);
        return "tienda_verEvento";
    }

    @GetMapping("/producto/{id}")
    public String verProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.getProductoById(id);
        List<TipoProducto> listaTipo = tipoProductoService.getAllTipoProducto();
        List<Marca> listaMarca = marcaService.getAllMarca();
        model.addAttribute("titulo", "Producto");
        model.addAttribute("producto", producto);
        model.addAttribute("tipoProducto", listaTipo);
        model.addAttribute("marca", listaMarca);
        return "tienda_verProducto";
    }

    @GetMapping("/buscar_en_tienda")
    public String buscar(@RequestParam("search") String search, Model model) {
        List<Producto> productos = productoService.findBySearch(search);
        model.addAttribute("productos", productos);
        return "tienda_buscar";
    }

    @GetMapping("/perfil/usuario/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        List<Distrito> listaD = distritoService.getAllDistrito();
        List<Canton> listaC = cantonService.getAllCanton();
        List<Provincia> listaP = provinciaService.getAllProvincia();
        model.addAttribute("usuario", usuario);
        model.addAttribute("distrito", listaD);
        model.addAttribute("canton", listaC);
        model.addAttribute("provincia", listaP);
        return "tienda_perfil";
    }

    @PostMapping("/perfil/usuario/{id}")
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
        return "redirect:/perfil/usuario/" + editarUsuario.getId();
    }

}


