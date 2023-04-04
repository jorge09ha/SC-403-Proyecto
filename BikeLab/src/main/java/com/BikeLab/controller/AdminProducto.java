package com.BikeLab.controller;

import com.BikeLab.entity.FamiliaProducto;
import com.BikeLab.entity.Marca;
import com.BikeLab.entity.TipoProducto;
import com.BikeLab.service.IFamiliaProductoService;
import com.BikeLab.service.IMarcaService;
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
public class AdminProducto {

    @Autowired
    private IMarcaService marcaService;

    @Autowired
    private IFamiliaProductoService familiaProductoService;

    @Autowired
    private ITipoProductoService tipoProductoService;

//-------------------------- List --------------------------
    @GetMapping("/admin/marca_producto")
    public String indexMarca(Model model) {
        List<Marca> lista = marcaService.getAllMarca();
        model.addAttribute("titulo", "MARCAS");
        model.addAttribute("marcas", lista);
        return "adm_marcaP";
    }

    @GetMapping("/admin/familia_producto")
    public String indexFamilia(Model model) {
        List<FamiliaProducto> lista = familiaProductoService.getAllFamiliaProducto();
        model.addAttribute("titulo", "FAMILIA PRODUCTO");
        model.addAttribute("familias", lista);
        return "adm_familiaP";
    }

    @GetMapping("/admin/tipo_producto")
    public String indexTipo(Model model) {
        List<TipoProducto> lista = tipoProductoService.getAllTipoProducto();
        model.addAttribute("titulo", "TIPO PRODUCTO");
        model.addAttribute("tipos", lista);
        return "adm_tipoP";
    }
    //-------------------------- New --------------------------
    //-------------------------- Save --------------------------
    //-------------------------- Delete --------------------------
    //-------------------------- UpDate --------------------------
    //*Marca
    //*Familia
    //*Tipo
}
