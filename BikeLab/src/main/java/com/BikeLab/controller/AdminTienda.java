package com.BikeLab.controller;

import com.BikeLab.entity.Evento;
import com.BikeLab.entity.Marca;
import com.BikeLab.entity.Producto;
import com.BikeLab.entity.TipoProducto;
import com.BikeLab.service.IEventoService;
import com.BikeLab.service.IMarcaService;
import com.BikeLab.service.IProductoService;
import com.BikeLab.service.ITipoProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

//-------------------------- List --------------------------
    @GetMapping("/admin/producto")
    public String indexProducto(Model model) {
        List<Producto> lista = productoService.getAllProducto();
        model.addAttribute("titulo", "PRODUCTOS");
        model.addAttribute("productos", lista);
        return "adm_producto";
    }

    @GetMapping("/admin/evento")
    public String indexEvento(Model model) {
        List<Evento> lista = eventoService.getAllEvento();
        model.addAttribute("titulo", "EVENTOS");
        model.addAttribute("eventos", lista);
        return "adm_evento";
    }

    //-------------------------- New --------------------------
    @GetMapping("/admin/producto/nuevo")
    public String crearProducto(Model model) {
        List<TipoProducto> listaTipo = tipoProductoService.getAllTipoProducto();
        List<Marca> listaMarca = marcaService.getAllMarca();
        model.addAttribute("titulo", "Producto Nuevo");
        model.addAttribute("producto", new Producto());
        model.addAttribute("tipo", listaTipo);
        model.addAttribute("marca", listaMarca);
        return "adm_crearProducto";
    }
}
