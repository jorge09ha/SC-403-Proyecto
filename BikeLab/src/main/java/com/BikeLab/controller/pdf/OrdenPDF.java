/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BikeLab.controller.pdf;

import com.BikeLab.controller.CartItem;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/**
 *
 * @author bperez
 */
@Component("tienda_carrito")
public class OrdenPDF extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CartItem> carrito = (List<CartItem>) model.get("carrito");
        
         double total = carrito.stream().mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad()).sum();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CR"));
        String formattedTotal = NumberFormat.getCurrencyInstance(new Locale("es", "CR")).format(total);

        PdfPTable carritoLista = new PdfPTable(5);     

        carrito.forEach(carritolist -> {
             int cantidad = carritolist.getCantidad();
            String cantidadStr = Integer.toString(cantidad);
             float precio = carritolist.getCantidad();
            String precioStr = Float.toString(precio);
            carritoLista.addCell(carritolist.getProducto().getNombre());
            carritoLista.addCell(carritolist.getProducto().getModelo());
             carritoLista.addCell(precioStr);
            carritoLista.addCell(cantidadStr);
            carritoLista.addCell(formattedTotal);
            
        });

        document.add(carritoLista);
    }

}
