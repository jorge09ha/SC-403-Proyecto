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
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("titulo", "HOME");
        return "home";
    }
    
        @GetMapping("/bicicletas")
    public String bicicletas(Model model) {
        model.addAttribute("titulo", "BICICLETAS");
        return "bicicletas";
    }
    
        @GetMapping("/componentes")
    public String componentes(Model model) {
        model.addAttribute("titulo", "COMPONENTES");
        return "componentes";
    }
    
        @GetMapping("/vestimenta")
    public String vestimenta(Model model) {
        model.addAttribute("titulo", "VESTIMENTA");
        return "vestimenta";
    }
    
        @GetMapping("/accesorios")
    public String accesorios(Model model) {
        model.addAttribute("titulo", "ACCESORIOS");
        return "accesorios";
    }
    
        @GetMapping("/eventos")
    public String eventos(Model model) {
        model.addAttribute("titulo", "EVENTOS");
        return "eventos";
    }

}
