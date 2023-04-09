package com.BikeLab.controller;

import com.BikeLab.entity.Proveedor;
import com.BikeLab.entity.Rol;
import com.BikeLab.service.IProveedorService;
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
public class AdminProveedor {

    @Autowired
    private IProveedorService proveedorService;
    //-------------------------- List --------------------------

    @GetMapping("/admin/proveedor")
    public String indexProveedor(Model model) {
        List<Proveedor> lista = proveedorService.getAllProveedor();
        model.addAttribute("titulo", "PROVEEDORES");
        model.addAttribute("proveedores", lista);
        return "adm_VerProveedor";
    }
    //-------------------------- New --------------------------
        @GetMapping("/admin/proveedor/nuevo")
    public String crearProveedor(Model model) {
        Proveedor proveedor = new Proveedor();
        model.addAttribute("titulo", "Proveedor Nuevo");
        model.addAttribute("proveedor", proveedor);
        return "adm_crearProveedor";
    }
    //-------------------------- Save --------------------------
        @PostMapping("/save/proveedor")
    public String guardarRole(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorService.saveProveedor(proveedor);
        return "redirect:/admin/proveedor";
    }
    //-------------------------- Delete --------------------------
        @GetMapping("/eliminar/proveedor/{id}")
    public String eliminarRole(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
        return "redirect:/admin/proveedor";
    }
    //-------------------------- UpDate --------------------------
        //*Proveedores
    @GetMapping("/editar/proveedor/{id}")
    public String editarRol(@PathVariable("id") Long id, Model model) {
        Proveedor a = proveedorService.getProveedorById(id);
        model.addAttribute("titulo", "Editar Proveedor");
        model.addAttribute("proveedor", a);
        return "adm_editarProveedor";
    }

    @PostMapping("/editar/proveedor/{id}")
    public String actualizarRol(@PathVariable Long id, @ModelAttribute("Rol") Proveedor proveedor) {
        Proveedor editar = proveedorService.getProveedorById(id);
        editar.setId(id);
        editar.setNombre(proveedor.getNombre());
        editar.setCorreo(proveedor.getCorreo());
        editar.setTelefono(proveedor.getTelefono());
        proveedorService.saveProveedor(editar);
        return "redirect:/admin/proveedor";
    }

}
