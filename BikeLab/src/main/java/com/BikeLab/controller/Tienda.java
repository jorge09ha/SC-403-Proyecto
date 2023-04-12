package com.BikeLab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jorge Hernandez Araya | jorge09ha
 */
@Controller
public class Tienda {

    //-------------------------- List --------------------------
    @GetMapping("tienda_home")
    public String index(Model model) {
        model.addAttribute("titulo", "HOME");
        return "tienda_home";
    }
    
        @GetMapping("/bicicletas")
    public String bicicletas(Model model) {
        model.addAttribute("titulo", "BICICLETAS");
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
    public String eventos(Model model) {
        model.addAttribute("titulo", "EVENTOS");
        return "tienda_eventos";
    }

}
