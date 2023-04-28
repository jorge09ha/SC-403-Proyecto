package com.BikeLab.controller;

import com.BikeLab.entity.Producto;
import com.BikeLab.service.IMetodoPagoService;
import com.BikeLab.service.IProductoService;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarritoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IMetodoPagoService metodoPagoService;

    @GetMapping("/carrito")
    public String carrito(Model model, HttpSession session) {
        List<CartItem> carrito = (List<CartItem>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        model.addAttribute("carrito", carrito);

        // Calcular el total en el controlador y formatearlo con separadores de miles y decimales
        double total = carrito.stream().mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad()).sum();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CR"));
        String formattedTotal = NumberFormat.getCurrencyInstance(new Locale("es", "CR")).format(total);
        model.addAttribute("total", formattedTotal);
        return "tienda_carrito";
    }

    @PostMapping("/carrito/agregar")
    public String agregarProductoCarrito(@RequestParam("productoId") int productoId, @RequestParam("cantidad") int cantidad, HttpSession session) {
        Producto producto = productoService.getProductoById(productoId);
        if (producto != null) {
            List<CartItem> carrito = (List<CartItem>) session.getAttribute("carrito");
            if (carrito == null) {
                carrito = new ArrayList<>();
            }

            // Busca si el producto ya está en el carrito
            CartItem itemExistente = null;
            for (CartItem item : carrito) {
                if (item.getProducto().getId() == productoId) {
                    itemExistente = item;
                    break;
                }
            }

            if (itemExistente == null) {
                // Si el producto no está en el carrito, crea un nuevo CartItem y lo añade a la lista
                int stockDisponible = producto.getStock();
                int cantidadAgregada = Math.min(cantidad, stockDisponible);
                carrito.add(new CartItem(producto, cantidadAgregada));
            } else {
                // Si el producto ya está en el carrito, incrementa la cantidad
                int stockDisponible = producto.getStock() - itemExistente.getCantidad();
                int cantidadAgregada = Math.min(cantidad, stockDisponible);
                itemExistente.setCantidad(itemExistente.getCantidad() + cantidadAgregada);
            }

            session.setAttribute("carrito", carrito);
        }
        return "redirect:/carrito";
    }

    @GetMapping("/carrito/eliminar")
    public String eliminarDelCarrito(@RequestParam("index") int index, HttpSession session) {
        List<CartItem> carrito = (List<CartItem>) session.getAttribute("carrito");
        if (carrito != null && index >= 0 && index < carrito.size()) {
            carrito.remove(index);
            session.setAttribute("carrito", carrito);
        }
        return "redirect:/carrito";
    }

    @GetMapping("/carrito/checkout")
    public String checkout(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        List<CartItem> carrito = (List<CartItem>) session.getAttribute("carrito");
        if (userId == null) {

            return "redirect:/login?iniciosesion";
        } else {

            model.addAttribute("carrito", carrito);
            // Calcular el total en el controlador y formatearlo con separadores de miles y decimales
            double total = carrito.stream().mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad()).sum();
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "CR"));
            String formattedTotal = NumberFormat.getCurrencyInstance(new Locale("es", "CR")).format(total);
            model.addAttribute("total", formattedTotal);
            return "tienda_checkout";
        }
    }

    @PostMapping("/carrito/checkout/procesar")
    public String checkoutProcesar(Model model, HttpSession session) {
        List<CartItem> carrito = (List<CartItem>) session.getAttribute("carrito");
        session.removeAttribute("carrito");
        return "tienda_pagado";
    }

    @GetMapping("/carrito/checkout/procesar")
    public String debugGetMethod(Model model, HttpSession session) {
        System.out.println("GET request to /carrito/checkout/procesar");
        return "tienda_pagado";
    }

}
