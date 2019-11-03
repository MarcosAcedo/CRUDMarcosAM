<%-- 
    Document   : Anadir
    Created on : 02-nov-2019, 20:29:28
    Author     : Portatil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="es.albarregas.beans.Ave"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/style.css" rel="stylesheet" type="text/css">
        <title>CRUD</title>
        <%
            ArrayList<Ave> aves = session.getAttribute("aves") != null ? (ArrayList<Ave>) session.getAttribute("aves") : null;
            StringBuilder tabla = null;
            if (aves != null) {
                tabla = new StringBuilder("<table><tr><th>Anilla</th><th>Especie</th><th>Lugar</th><th>Fecha</th></tr>");
                for (Ave ave : aves) {
                    tabla.append("<tr><td>").append(ave.getAnilla()).append("</td><td>").append(ave.getEspecie()).append("</td><td>").append(ave.getLugar()).append("</td><td>").append(ave.getFecha()).append("</td></tr>");
                }
                tabla.append("</table>");
            }
        %>
    </head>
    <body>
        <div>
            <h1>Listado de todas las aves</h1>
            <form action="<%=request.getContextPath()%>/ControladorDirecciones2" method="post">
                <p>
                    <%=tabla != null ? tabla.toString() : ""%>
                </p>
                <input type="submit" name="Boton" value="Inicio">&emsp;&emsp;
            </form>
        </div>
        
    </body>
</html>
