<%-- 
    Document   : Anadir
    Created on : 02-nov-2019, 20:29:28
    Author     : Portatil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/style.css" rel="stylesheet" type="text/css">
        <title>CRUD</title>
    </head>
    <body>
        <div>
            <h1>Elije una o más aves para eliminar</h1>
            <form action="ControladorDirecciones" method="post">
                <p>
                   <!--<input type="radio" name="borrar">-->
                </p>
                <input type="submit" name="Boton" value="Cancelar">&emsp;&emsp;
                <input type="submit" name="Boton" value="Eliminar">
            </form>
        </div>
        
    </body>
</html>
