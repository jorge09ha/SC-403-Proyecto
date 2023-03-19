package com.BikeLab.controller;

import com.BikeLab.entity.Canton;
import com.BikeLab.entity.Distrito;
import com.BikeLab.entity.Provincia;
import com.BikeLab.service.ICantonService;
import com.BikeLab.service.IDistritoService;
import com.BikeLab.service.IProvinciaService;
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
public class AdmController {

    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private ICantonService cantonService;

    @Autowired
    private IDistritoService distritoService;

    //-------------------------- List --------------------------
    @GetMapping("/admLugarD")
    public String indexDistrito(Model model) {
        List<Distrito> lista = distritoService.getAllDistrito();
        model.addAttribute("titulo", "DISTRITOS");
        model.addAttribute("distritos", lista);
        return "admLugarD";
    }

    @GetMapping("/admLugarC")
    public String indexCanton(Model model) {
        List<Canton> lista = cantonService.getAllCanton();
        model.addAttribute("titulo", "CANTONES");
        model.addAttribute("cantones", lista);
        return "admLugarC";
    }

    @GetMapping("/admLugarP")
    public String indexProvincia(Model model) {
        List<Provincia> lista = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "PROVINCIAS");
        model.addAttribute("provincias", lista);
        return "admLugarP";
    }

}
