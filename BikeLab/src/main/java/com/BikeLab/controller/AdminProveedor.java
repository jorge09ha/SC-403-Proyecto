package com.BikeLab.controller;

import com.BikeLab.entity.Proveedor;
import com.BikeLab.service.IProveedorService;
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
public class AdminProveedor {

    @Autowired
    private IProveedorService proveedorService;
    //-------------------------- List --------------------------

    @GetMapping("/admin/proveedor")
    public String indexProveedor(Model model) {
        List<Proveedor> lista = proveedorService.getAllProveedor();
        model.addAttribute("titulo", "PROVEEDORES");
        model.addAttribute("proveedores", lista);
        return "adm_proveedor";
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
    //-------------------------- Delete --------------------------
    //-------------------------- UpDate --------------------------

}
