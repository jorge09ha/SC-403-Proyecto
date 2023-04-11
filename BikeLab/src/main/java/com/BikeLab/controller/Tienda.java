package com.BikeLab.controller;

import com.BikeLab.entity.Evento;
import com.BikeLab.entity.Producto;
import com.BikeLab.service.IEventoService;
import com.BikeLab.service.IProductoService;
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
public class Tienda {

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IProductoService productoService;

    //-------------------------- List --------------------------
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("titulo", "HOME");
        return "tienda_home";
    }

    @GetMapping("/bicicletas")
    public String bicicletas(Model model) {
        List<Producto> lista = productoService.getAllProducto();
        model.addAttribute("titulo", "BICICLETAS");
        model.addAttribute("productos", lista);
        return "tienda_bicicletas";
    }

    @GetMapping("/componentes")
    public String componentes(Model model) {
        model.addAttribute("titulo", "COMPONENTES");
        return "tienda_componentes";
    }

    @GetMapping("/vestimenta")
    public String vestimenta(Model model) {
        model.addAttribute("titulo", "VESTIMENTA");
        return "tienda_vestimenta";
    }

    @GetMapping("/accesorios")
    public String accesorios(Model model) {
        model.addAttribute("titulo", "ACCESORIOS");
        return "tienda_accesorios";
    }

    @GetMapping("/eventos")
    public String indexEvento(Model model) {
        List<Evento> lista = eventoService.getAllEvento();
        model.addAttribute("titulo", "EVENTOS");
        model.addAttribute("eventos", lista);
        return "tienda_eventos";
    }

}
