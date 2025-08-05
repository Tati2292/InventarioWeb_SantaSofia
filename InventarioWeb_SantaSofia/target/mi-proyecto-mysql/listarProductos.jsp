<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.santasofia.modelo.Producto" %>
<html>
<head>
    <title>Lista de Productos</title>
</head>
<body>
    <h1>Productos en Inventario</h1>
    <table border="1">
        <tr>
            <th>ID</th><th>Nombre</th><th>Cantidad</th><th>Precio</th>
        </tr>
        <%
            List<Producto> productos = (List<Producto>) request.getAttribute("productos");
            if (productos != null) {
                for (Producto p : productos) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getCantidad() %></td>
            <td><%= p.getPrecio() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <a href="index.jsp">Volver</a>
</body>
</html>

