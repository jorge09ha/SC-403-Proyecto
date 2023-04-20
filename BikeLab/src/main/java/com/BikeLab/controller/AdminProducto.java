package com.BikeLab.controller;

import com.BikeLab.entity.FamiliaProducto;
import com.BikeLab.entity.Marca;
import com.BikeLab.entity.TipoProducto;
import com.BikeLab.service.IFamiliaProductoService;
import com.BikeLab.service.IMarcaService;
import com.BikeLab.service.ITipoProductoService;
import com.BikeLab.service.UploadFileService;
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
        return "adm_VerMarcaP";
    }

    @GetMapping("/admin/familia_producto")
    public String indexFamilia(Model model) {
        List<FamiliaProducto> lista = familiaProductoService.getAllFamiliaProducto();
        model.addAttribute("titulo", "FAMILIA PRODUCTO");
        model.addAttribute("familias", lista);
        return "adm_VerFamiliaP";
    }

    @GetMapping("/admin/tipo_producto")
    public String indexTipo(Model model) {
        List<TipoProducto> lista = tipoProductoService.getAllTipoProducto();
        model.addAttribute("titulo", "TIPO PRODUCTO");
        model.addAttribute("tipos", lista);
        return "adm_VerTipoP";
    }

    //-------------------------- New --------------------------
    @GetMapping("/admin/marca/nuevo")
    public String crearMarca(Model model) {
        Marca marca = new Marca();
        model.addAttribute("titulo", "Marca Nueva");
        model.addAttribute("marca", marca);
        return "adm_crearMarcaP";
    }

    @GetMapping("/admin/familia/nuevo")
    public String crearFamiliaP(Model model) {
        FamiliaProducto familiaProducto = new FamiliaProducto();
        model.addAttribute("titulo", "Nueva Familia Producto");
        model.addAttribute("familia", familiaProducto);
        return "adm_crearFamiliaP";
    }

    @GetMapping("/admin/tipo/nuevo")
    public String crearTipoP(Model model) {
        List<FamiliaProducto> lista = familiaProductoService.getAllFamiliaProducto();
        TipoProducto tipoProducto = new TipoProducto();
        model.addAttribute("titulo", "Nueva Tipo Producto");
        model.addAttribute("tipo", tipoProducto);
        model.addAttribute("familiaproducto", lista);
        return "adm_crearTipoP";
    }

    //-------------------------- Save --------------------------
    @PostMapping("/save/marca")
    public String guardarMarca(@ModelAttribute("Marca") Marca marca) {
        marcaService.saveMarca(marca);
        return "redirect:/admin/marca_producto";
    }

    @PostMapping("/save/familia")
    public String guardarFamiliaP(@ModelAttribute("Familia") FamiliaProducto familiaProducto) {
        familiaProductoService.saveFamiliaProducto(familiaProducto);
        return "redirect:/admin/familia_producto";
    }

    @PostMapping("/save/tipo")
    public String guardarTipoP(@ModelAttribute("Tipo") TipoProducto tipoProducto) {
        tipoProductoService.saveTipoProducto(tipoProducto);
        return "redirect:/admin/tipo_producto";
    }

    //-------------------------- Delete --------------------------
    @GetMapping("/eliminar/marca/{id}")
    public String eliminarMarcaP(@PathVariable Long id) {
        marcaService.deleteMarca(id);
        return "redirect:/admin/marca_producto";
    }

    @GetMapping("/eliminar/familia/{id}")
    public String eliminarFamiliaP(@PathVariable Long id) {
        familiaProductoService.deleteFamiliaProducto(id);
        return "redirect:/admin/familia_producto";
    }

    @GetMapping("/eliminar/tipo/{id}")
    public String eliminarTipoP(@PathVariable Long id) {
        tipoProductoService.deleteTipoProducto(id);
        return "redirect:/admin/tipo_producto";
    }

    //-------------------------- UpDate --------------------------
    //*Marca
    @GetMapping("/editar/marca/{id}")
    public String editarMarcaP(@PathVariable("id") Long id, Model model) {
        Marca a = marcaService.getMarcaById(id);
        model.addAttribute("titulo", "Editar Marca");
        model.addAttribute("marca", a);
        return "adm_editarMarcaP";
    }

    @PostMapping("/editar/marca/{id}")
    public String actualizarMarcaP(@PathVariable Long id, @ModelAttribute("Marca") Marca marca) {
        Marca editar = marcaService.getMarcaById(id);
        editar.setId(id);
        editar.setNombre(marca.getNombre());
        marcaService.saveMarca(editar);
        return "redirect:/admin/marca_producto";
    }

    //*Familia
    @GetMapping("/editar/familia/{id}")
    public String editarFamiliaP(@PathVariable("id") Long id, Model model) {
        FamiliaProducto a = familiaProductoService.getFamiliaProductoById(id);
        model.addAttribute("titulo", "Editar Familia Producto");
        model.addAttribute("familia", a);
        return "adm_editarFamiliaP";
    }

    @PostMapping("/editar/familia/{id}")
    public String actualizarFamiliaP(@PathVariable Long id, @ModelAttribute("Familia") FamiliaProducto familiaP) {
        FamiliaProducto editar = familiaProductoService.getFamiliaProductoById(id);
        editar.setId(id);
        editar.setFamilia(familiaP.getFamilia());
        editar.setDetalle(familiaP.getDetalle());
        familiaProductoService.saveFamiliaProducto(editar);
        return "redirect:/admin/familia_producto";
    }

    //*Tipo
    @GetMapping("/editar/tipo/{id}")
    public String editarTipoP(@PathVariable("id") Long id, Model model) {
        TipoProducto a = tipoProductoService.getTipoProductoById(id);
        List<FamiliaProducto> lista = familiaProductoService.getAllFamiliaProducto();
        model.addAttribute("titulo", "Editar Tipo Producto");
        model.addAttribute("tipo", a);
        model.addAttribute("familiaproducto", lista);
        return "adm_editarTipoP";
    }

    @PostMapping("/editar/tipo/{id}")
    public String actualizarTipoP(@PathVariable Long id, @ModelAttribute("Tipo") TipoProducto tipoProducto) {
        TipoProducto editar = tipoProductoService.getTipoProductoById(id);
        editar.setId(id);
        editar.setTipo(tipoProducto.getTipo());
        editar.setDetalle(tipoProducto.getDetalle());
        editar.setFamiliaproducto(tipoProducto.getFamiliaproducto());
        tipoProductoService.saveTipoProducto(editar);
        return "redirect:/admin/tipo_producto";
    }
}
