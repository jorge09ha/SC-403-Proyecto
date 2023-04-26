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
import com.BikeLab.service.UploadFileService;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jorge Hernandez Araya | jorge09ha
 */
@Controller
public class AdminTienda {

    private final Logger LOGGER = LoggerFactory.getLogger(AdminTienda.class);

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

    @Autowired
    private UploadFileService upload;

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
    public String guardarProducto(@ModelAttribute Producto producto, @RequestParam("file") MultipartFile imagefile, HttpSession session) throws IOException {
        String nombreImagen = upload.saveImageProducto(imagefile);
        producto.setImagen(nombreImagen);
        productoService.saveProducto(producto);
        LOGGER.info("CREATE {}", producto.toString());
        return "redirect:/admin/producto";
    }

    @PostMapping("/save/evento")
    public String guardarEvento(@ModelAttribute Evento evento, @RequestParam("file") MultipartFile imagefile) throws IOException {
        String nombreImagen = upload.saveImageEvento(imagefile);
        evento.setImagen(nombreImagen);
        eventoService.saveEvento(evento);
        LOGGER.info("CREATE {}", evento.toString());
        return "redirect:/admin/evento";
    }

    //-------------------------- Delete ---------------------------
    @GetMapping("/eliminar/producto/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        Producto productoEliminar = productoService.getProductoById(id);
        upload.deleteImage(productoEliminar.getImagen());
        productoService.deleteProducto(id);
        LOGGER.info("DELETE producto {}", id.toString());
        return "redirect:/admin/producto";
    }

    @GetMapping("/eliminar/evento/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        Evento eventoEliminar = eventoService.getEventoById(id);
        upload.deleteImage(eventoEliminar.getImagen());
        eventoService.deleteEvento(id);
        LOGGER.info("DELETE evento {}", id.toString());
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
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("Producto") Producto producto, @RequestParam("file") MultipartFile imagefile) throws IOException {
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
        productoEditar.setMarca(producto.getMarca());
        productoEditar.setTipoProducto(producto.getTipoProducto());

        if (imagefile.isEmpty()) {
            LOGGER.info("UPDATE - No se modifica la imagen. Imagen actual: " + productoEditar.getImagen());
            productoEditar.setImagen(productoEditar.getImagen());
        } else {
            upload.deleteImage(productoEditar.getImagen());
            productoEditar.setImagen(producto.getImagen());
            String nombreImagen = upload.saveImageProducto(imagefile);
            productoEditar.setImagen(nombreImagen);
            LOGGER.info("UPDATE -  Se modifica la imagen. Imagen nueva: " + nombreImagen);
        }

        productoService.saveProducto(productoEditar);
        LOGGER.info("UPDATE {}", productoEditar.toString());
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
    public String actualizarEvento(@PathVariable Long id, @ModelAttribute("Evento") Evento evento, @RequestParam("file") MultipartFile imagefile) throws IOException {
        Evento eventoEditar = eventoService.getEventoById(id);
        eventoEditar.setId(id);
        eventoEditar.setFecha(evento.getFecha());
        eventoEditar.setNombre(evento.getNombre());
        eventoEditar.setPrecio(evento.getPrecio());
        eventoEditar.setDetalle(evento.getDetalle());
        eventoEditar.setDireccion(evento.getDireccion());
        eventoEditar.setStock(evento.getStock());
        eventoEditar.setTipoProducto(evento.getTipoProducto());
        eventoEditar.setProvincia(evento.getProvincia());
        eventoEditar.setCanton(evento.getCanton());
        eventoEditar.setDistrito(evento.getDistrito());

        if (imagefile.isEmpty()) {
            System.out.println("No se modifica Imagen");
            eventoEditar.setImagen(eventoEditar.getImagen());
        } else {
            System.out.println("Imagen nueva");
            upload.deleteImage(eventoEditar.getImagen());
            String nombreImagen = upload.saveImageEvento(imagefile);
            eventoEditar.setImagen(nombreImagen);
        }
        eventoService.saveEvento(eventoEditar);
        LOGGER.info("UPDATE {}", evento.toString());
        return "redirect:/admin/evento";
    }

    //-------------------------- Buscador --------------------------
    @GetMapping("/buscar")
    public String buscar(@RequestParam("search") String search, Model model) {
        List<Producto> productos = productoService.findBySearch(search);
        model.addAttribute("productos", productos);
        return "adm_VerProducto";
    }
  

}
