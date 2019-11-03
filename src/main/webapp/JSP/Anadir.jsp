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
            <h1>Añadir nuevo pajaro</h1>
            <form action="ControladorDirecciones" method="post">
                <p>
                    Anilla <input type="text" name="Anilla" maxlength="6"><br>
                    Especie <input type="text" name="Especie" maxlength="20"><br>
                    Lugar <input type="text" name="Lugar" maxlength="30"><br>
                    Fecha <input type="date" name="Fecha"><br>
                </p>
                <input type="submit" name="Boton" value="Cancelar">&emsp;&emsp;
                <input type="submit" name="Boton" value="Añadir">
            </form>
        </div>
        
    </body>
</html>
