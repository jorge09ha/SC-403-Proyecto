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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Direccion {

    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private ICantonService cantonService;

    @Autowired
    private IDistritoService distritoService;

//-------------------------- List --------------------------
    @GetMapping("/dashboard")
    public String indexDistrito(Model model) {
        List<Distrito> lista = distritoService.getAllDistrito();
        model.addAttribute("titulo", "Tabla distritos");
        model.addAttribute("distritos", lista);
        return "dashboard";
    }

    @GetMapping("/canton")
    public String indexCanton(Model model) {
        List<Canton> lista = cantonService.getAllCanton();
        model.addAttribute("titulo", "Tabla cantones");
        model.addAttribute("cantones", lista);
        return "canton";
    }

    @GetMapping("/provincia")
    public String indexProvincia(Model model) {
        List<Provincia> lista = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "Tabla provincias");
        model.addAttribute("provincias", lista);
        return "provincia";
    }

    //-------------------------- New --------------------------
    @GetMapping("/distrito/nuevo")
    public String crearDistrito(Model model) {
        Distrito distrito = new Distrito();
        model.addAttribute("titulo", "Distrito Nuevo");
        model.addAttribute("distrito", distrito);
        return "crearDistrito";
    }

    @GetMapping("/canton/nuevo")
    public String crearCanton(Model model) {
        Canton canton = new Canton();
        model.addAttribute("titulo", "Canton Nuevo");
        model.addAttribute("canton", canton);
        return "crearCanton";
    }

    @GetMapping("/provincia/nuevo")
    public String crearProvincia(Model model) {
        Provincia provincia = new Provincia();
        model.addAttribute("titulo", "Provincia Nueva");
        model.addAttribute("provincia", provincia);
        return "crearProvincia";
    }

    //-------------------------- Save --------------------------
    @PostMapping("/save/distrito")
    public String guardarDistrito(@ModelAttribute Distrito distrito) {
        distritoService.saveDistrito(distrito);
        return "redirect:/distrito";
    }

    @PostMapping("/save/canton")
    public String guardarCanton(@ModelAttribute Canton canton) {
        cantonService.saveCanton(canton);
        return "redirect:/canton";
    }

    @PostMapping("/save/provincia")
    public String guardarProvincia(@ModelAttribute Provincia provincia) {
        provinciaService.saveProvincia(provincia);
        return "redirect:/provincia";
    }

    //-------------------------- Delete --------------------------
    @GetMapping("/eliminar/distrito/{id}")
    public String eliminarDistrito(@PathVariable Long id) {
        distritoService.deleteDistrito(id);
        return "redirect:/distrito";
    }

    @GetMapping("/eliminar/canton/{id}")
    public String eliminarCanton(@PathVariable Long id) {
        cantonService.deleteCanton(id);
        return "redirect:/canton";
    }

    @GetMapping("/eliminar/provincia/{id}")
    public String eliminarProvincia(@PathVariable Long id) {
        provinciaService.deleteProvincia(id);
        return "redirect:/provincia";
    }

    //-------------------------- UpDate --------------------------
    @GetMapping("/editar/distrito/{id}")
    public String editarDistrito(@PathVariable("id") Long id, Model model) {
        Distrito a = distritoService.getDistritoById(id);
        model.addAttribute("titulo", "Editar distrito");
        model.addAttribute("distrito", a);
        return "editarDistrito";
    }

    @PostMapping("/editar/distrito/{id}")
    public String actualizarDistrito(@PathVariable Long id, @ModelAttribute("Distrito") Distrito distrito) {
        Distrito distritoEditar = distritoService.getDistritoById(id);
        distritoEditar.setId(id);
        distritoEditar.setNombre(distrito.getNombre());
        distritoService.saveDistrito(distritoEditar);
        return "redirect:/distrito";
    }

    //*END Distrito
    @GetMapping("/editar/canton/{id}")
    public String editarCanton(@PathVariable("id") Long id, Model model) {
        Canton a = cantonService.getCantonById(id);
        model.addAttribute("titulo", "Editar canton");
        model.addAttribute("canton", a);
        return "editarCanton";
    }

    @PostMapping("/editar/canton/{id}")
    public String actualizarCanton(@PathVariable Long id, @ModelAttribute("Canton") Canton a) {
        Canton editar = cantonService.getCantonById(id);
        editar.setId(id);
        editar.setNombre(a.getNombre());
        cantonService.saveCanton(editar);
        return "redirect:/canton";
    }

    //*END Canton
    @GetMapping("/editar/provincia/{id}")
    public String editarProvincia(@PathVariable("id") Long id, Model model) {
        Provincia a = provinciaService.getProvinciaById(id);
        model.addAttribute("titulo", "Editar provincia");
        model.addAttribute("provincia", a);
        return "editarProvincia";
    }

    @PostMapping("/editar/provincia/{id}")
    public String actualizarProvincia(@PathVariable Long id, @ModelAttribute("Provincia") Provincia a) {
        Provincia editar = provinciaService.getProvinciaById(id);
        editar.setId(id);
        editar.setNombre(a.getNombre());
        provinciaService.saveProvincia(editar);
        return "redirect:/provincia";
    }
    //*END Provincia
}
