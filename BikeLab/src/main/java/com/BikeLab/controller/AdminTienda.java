package com.BikeLab.controller;

import com.BikeLab.entity.Canton;
import com.BikeLab.entity.Distrito;
import com.BikeLab.entity.Evento;
import com.BikeLab.entity.Marca;
import com.BikeLab.entity.Producto;
import com.BikeLab.entity.Provincia;
import com.BikeLab.entity.TipoProducto;
import com.BikeLab.service.ICantonService;
import com.BikeLab.service.IDistritoService;
import com.BikeLab.service.IEventoService;
import com.BikeLab.service.IMarcaService;
import com.BikeLab.service.IProductoService;
import com.BikeLab.service.IProvinciaService;
import com.BikeLab.service.ITipoProductoService;
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
public class AdminTienda {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IEventoService eventoService;

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

//-------------------------- List --------------------------
    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("titulo", "HOME ADMIN");
        return "adm_VerHome";
    }

    @GetMapping("/admin/producto")
    public String indexProducto(Model model) {
        List<Producto> lista = productoService.getAllProducto();
        model.addAttribute("titulo", "PRODUCTOS");
        model.addAttribute("productos", lista);
        return "adm_VerProducto";
    }

    @GetMapping("/admin/evento")
    public String indexEvento(Model model) {
        List<Evento> lista = eventoService.getAllEvento();
        model.addAttribute("titulo", "EVENTOS");
        model.addAttribute("eventos", lista);
        return "adm_VerEvento";
    }

    //-------------------------- New --------------------------
    @GetMapping("/admin/producto/nuevo")
    public String crearProducto(Model model) {
        List<TipoProducto> listaTipo = tipoProductoService.getAllTipoProducto();
        List<Marca> listaMarca = marcaService.getAllMarca();
        model.addAttribute("titulo", "Producto Nuevo");
        model.addAttribute("producto", new Producto());
        model.addAttribute("tipoProducto", listaTipo);
        model.addAttribute("marca", listaMarca);
        return "adm_crearProducto";
    }

    @GetMapping("/admin/evento/nuevo")
    public String crearEvento(Model model) {
        List<TipoProducto> listaTipo = tipoProductoService.getAllTipoProducto();
        List<Distrito> listaD = distritoService.getAllDistrito();
        List<Canton> listaC = cantonService.getAllCanton();
        List<Provincia> listaP = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "Evento Nuevo");
        model.addAttribute("evento", new Evento());
        model.addAttribute("tipoProducto", listaTipo);
        model.addAttribute("distrito", listaD);
        model.addAttribute("canton", listaC);
        model.addAttribute("provincia", listaP);
        return "adm_crearEvento";
    }

    //-------------------------- Save -----------------------------
    @PostMapping("/save/producto")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/admin/producto";
    }

    @PostMapping("/save/evento")
    public String guardarEvento(@ModelAttribute Evento evento) {
        eventoService.saveEvento(evento);
        return "redirect:/admin/evento";
    }

    //-------------------------- Delete ---------------------------
    @GetMapping("/eliminar/producto/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "redirect:/admin/producto";
    }

    @GetMapping("/eliminar/evento/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return "redirect:/admin/evento";
    }

    //-------------------------- UpDate --------------------------
    //* Producto
    @GetMapping("/editar/producto/{id}")
    public String editarProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoService.getProductoById(id);
        List<TipoProducto> listaTipo = tipoProductoService.getAllTipoProducto();
        List<Marca> listaMarca = marcaService.getAllMarca();
        model.addAttribute("titulo", "Editar Producto");
        model.addAttribute("producto", producto);
        model.addAttribute("tipoProducto", listaTipo);
        model.addAttribute("marca", listaMarca);
        return "adm_editarProducto";
    }

    @PostMapping("/editar/producto/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("Producto") Producto producto) {
        Producto productoEditar = productoService.getProductoById(id);
        productoEditar.setId(id);
        productoEditar.setNombre(producto.getNombre());
        productoEditar.setModelo(producto.getModelo());
        productoEditar.setTalla(producto.getTalla());
        productoEditar.setTamanio(producto.getTamanio());
        productoEditar.setDetalle(producto.getDetalle());
        productoEditar.setAnio(producto.getAnio());
        productoEditar.setPrecio(producto.getPrecio());
        productoEditar.setStock(producto.getStock());
        productoEditar.setImagen(producto.getImagen());
        productoEditar.setTipoProducto(producto.getTipoProducto());
        productoService.saveProducto(productoEditar);
        return "redirect:/admin/producto";
    }

    //* Evento
    @GetMapping("/editar/evento/{id}")
    public String editarEvento(@PathVariable("id") Long id, Model model) {
        Evento evento = eventoService.getEventoById(id);
        List<TipoProducto> listaTipo = tipoProductoService.getAllTipoProducto();
        List<Distrito> listaD = distritoService.getAllDistrito();
        List<Canton> listaC = cantonService.getAllCanton();
        List<Provincia> listaP = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "Editar Evento");
        model.addAttribute("evento", evento);
        model.addAttribute("tipoProducto", listaTipo);
        model.addAttribute("distrito", listaD);
        model.addAttribute("canton", listaC);
        model.addAttribute("provincia", listaP);
        return "adm_editarEvento";
    }

    @PostMapping("/editar/evento/{id}")
    public String actualizarEvento(@PathVariable Long id, @ModelAttribute("Evento") Evento evento) {
        Evento eventoEditar = eventoService.getEventoById(id);
        eventoEditar.setId(id);
        eventoEditar.setFecha(evento.getFecha());
        eventoEditar.setNombre(evento.getNombre());
        eventoEditar.setPrecio(evento.getPrecio());
        eventoEditar.setDetalle(evento.getDetalle());
        eventoEditar.setDireccion(evento.getDireccion());
        eventoEditar.setStock(evento.getStock());
        eventoEditar.setImagen(evento.getImagen());
        eventoEditar.setTipoProducto(evento.getTipoProducto());
        eventoEditar.setProvincia(evento.getProvincia());
        eventoEditar.setCanton(evento.getCanton());
        eventoEditar.setDistrito(evento.getDistrito());
        eventoService.saveEvento(eventoEditar);
        return "redirect:/admin/evento";
    }

}
