package com.santasofia.controlador;

import com.santasofia.modelo.Producto;
import com.santasofia.modelo.ProductoDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
    private ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        double precio = Double.parseDouble(request.getParameter("precio"));

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);

        productoDAO.agregarProducto(producto);
        request.setAttribute("mensaje", "Producto agregado con éxito");
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Producto> lista = productoDAO.obtenerTodosLosProductos();
        request.setAttribute("productos", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarProducto.jsp");
        dispatcher.forward(request, response);
    }
}
