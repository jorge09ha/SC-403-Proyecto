package com.BikeLab.controller;

import com.BikeLab.entity.Canton;
import com.BikeLab.entity.Distrito;
import com.BikeLab.entity.Provincia;
import com.BikeLab.entity.Rol;
import com.BikeLab.service.ICantonService;
import com.BikeLab.service.IDistritoService;
import com.BikeLab.service.IProvinciaService;
import com.BikeLab.service.IRolService;
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
public class AdminDireccion {

    @Autowired
    private IProvinciaService provinciaService;

    @Autowired
    private ICantonService cantonService;

    @Autowired
    private IDistritoService distritoService;

    //-------------------------- List --------------------------
    @GetMapping("/admin/direccion_distrito")
    public String indexDistrito(Model model) {
        List<Distrito> lista = distritoService.getAllDistrito();
        model.addAttribute("titulo", "DISTRITOS");
        model.addAttribute("distritos", lista);
        return "adm_distrito";
    }

    @GetMapping("/admin/direccion_canton")
    public String indexCanton(Model model) {
        List<Canton> lista = cantonService.getAllCanton();
        model.addAttribute("titulo", "CANTONES");
        model.addAttribute("cantones", lista);
        return "adm_canton";
    }

    @GetMapping("/admin/direccion_provincia")
    public String indexProvincia(Model model) {
        List<Provincia> lista = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "PROVINCIAS");
        model.addAttribute("provincias", lista);
        return "adm_provincia";
    }

    //-------------------------- New --------------------------
    @GetMapping("/admin/direccion_distrito/nuevo")
    public String crearDistrito(Model model) {
        List<Canton> listaCanton = cantonService.getAllCanton();
        model.addAttribute("titulo", "Distrito Nuevo");
        model.addAttribute("distrito", new Distrito());
        model.addAttribute("canton", listaCanton);
        return "adm_crearDistrito";
    }

    @GetMapping("/admin/direccion_canton/nuevo")
    public String crearCanton(Model model) {
        List<Provincia> listaProvincias = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "Canton Nuevo");
        model.addAttribute("canton", new Canton());
        model.addAttribute("provincia", listaProvincias);
        return "adm_crearCanton";
    }

    @GetMapping("/admin/direccion_provincia/nuevo")
    public String crearProvincia(Model model) {
        Provincia provincia = new Provincia();
        model.addAttribute("titulo", "Provincia Nueva");
        model.addAttribute("provincia", provincia);
        return "adm_crearProvincia";
    }

    //-------------------------- Save --------------------------
    @PostMapping("/save/distrito")
    public String guardarDistrito(@ModelAttribute Distrito distrito) {
        distritoService.saveDistrito(distrito);
        return "redirect:/admin/direccion_distrito";
    }

    @PostMapping("/save/canton")
    public String guardarCanton(@ModelAttribute Canton canton) {
        cantonService.saveCanton(canton);
        return "redirect:/admin/direccion_canton";
    }

    @PostMapping("/save/provincia")
    public String guardarProvincia(@ModelAttribute Provincia provincia) {
        provinciaService.saveProvincia(provincia);
        return "redirect:/admin/direccion_provincia";
    }

    //-------------------------- Delete --------------------------
    @GetMapping("/eliminar/distrito/{id}")
    public String eliminarDistrito(@PathVariable Long id) {
        distritoService.deleteDistrito(id);
        return "redirect:/admin/direccion_distrito";
    }

    @GetMapping("/eliminar/canton/{id}")
    public String eliminarCanton(@PathVariable Long id) {
        cantonService.deleteCanton(id);
        return "redirect:/admin/direccion_canton";
    }

    @GetMapping("/eliminar/provincia/{id}")
    public String eliminarProvincia(@PathVariable Long id) {
        provinciaService.deleteProvincia(id);
        return "redirect:/admin/direccion_provincia";
    }

    //-------------------------- UpDate --------------------------
    //* Distrito
    @GetMapping("/editar/distrito/{id}")
    public String editarFuncion(@PathVariable("id") Long id, Model model) {
        Distrito distrito = distritoService.getDistritoById(id);
        List<Canton> listaCanton = cantonService.getAllCanton();
        model.addAttribute("titulo", "Editar Distrito");
        model.addAttribute("distrito", distrito);
        model.addAttribute("canton", listaCanton);
        return "adm_editarDistrito";
    }

    @PostMapping("/editar/distrito/{id}")
    public String actualizarFuncion(@PathVariable Long id, @ModelAttribute("Distrito") Distrito distrito) {
        Distrito distritoEditar = distritoService.getDistritoById(id);
        distritoEditar.setId(id);
        distritoEditar.setNombre(distrito.getNombre());
        distritoEditar.setCanton(distrito.getCanton());
        distritoService.saveDistrito(distritoEditar);
        return "redirect:/admin/direccion_distrito";
    }

//* Canton
    @GetMapping("/editar/canton/{id}")
    public String editarCanton(@PathVariable("id") Long id, Model model) {
        Canton canton = cantonService.getCantonById(id);
        List<Provincia> listaProvincia = provinciaService.getAllProvincia();
        model.addAttribute("titulo", "Editar Canton");
        model.addAttribute("canton", canton);
        model.addAttribute("provincia", listaProvincia);
        return "adm_editarCanton";
    }

    @PostMapping("/editar/canton/{id}")
    public String actualizarCanton(@PathVariable Long id, @ModelAttribute("Canton") Canton canton) {
        Canton cantonEditar = cantonService.getCantonById(id);
        cantonEditar.setId(id);
        cantonEditar.setNombre(canton.getNombre());
        cantonEditar.setProvincia(canton.getProvincia());
        cantonService.saveCanton(cantonEditar);
        return "redirect:/admin/direccion_distrito";
    }

    //*Provincia
    @GetMapping("/editar/provincia/{id}")
    public String editarProvincia(@PathVariable("id") Long id, Model model) {
        Provincia a = provinciaService.getProvinciaById(id);
        model.addAttribute("titulo", "Editar provincia");
        model.addAttribute("provincia", a);
        return "adm_editarProvincia";
    }

    @PostMapping("/editar/provincia/{id}")
    public String actualizarProvincia(@PathVariable Long id, @ModelAttribute("Provincia") Provincia a) {
        Provincia editar = provinciaService.getProvinciaById(id);
        editar.setId(id);
        editar.setNombre(a.getNombre());
        provinciaService.saveProvincia(editar);
        return "redirect:/admin/direccion_provincia";
    }

}
