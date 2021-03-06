<%-- 
    Document   : formPeriodo
    Created on : 23-jun-2015, 10:23:00
    Author     : SistemasUpeu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>        
    </head>
    <body>
        <div>
            <c:url var="saveproductsx"  value="actualizarFacturas" />
            <fm:form modelAttribute="modeloProducto" method="post" action="${saveproductox}">
                <table>
                    <a href="../../../../java/pe/edu/upeu/control/ProductsController.java"></a>

                    <tr>
                        <td><fm:label path="codigoProducto">Codigo</fm:label> </td>
                        <td><fm:input path="codigoProducto" size="60" /></td>
                    </tr>

                    <tr>
                        <td><fm:label path="nombreProducto">Nombre</fm:label> </td>                        
                        <td><fm:input path="nombreProducto" size="60" /></td>
                    </tr>

                    <tr>
                        <td><fm:label path="statusProducto">Estado</fm:label> </td>                        
                        <td><fm:input path="statusProducto" size="60" /></td>
                    </tr>

                    <tr>
                        <td><fm:label path="dateAdded">Fecha</fm:label> </td>                        
                        <td><fm:input path="dateAdded" size="60" /></td>
                    </tr>      

                    <tr>
                        <td><fm:label path="precioProducto">Precio</fm:label> </td>                        
                        <td><fm:input path="precioProducto" size="60" /></td>
                    </tr>      


                    <tr>      
                        <fm:hidden path="idProducto" />
                        <td colspan="2"><input type="submit" value="Enviar" > </td>
                    </tr>
                </table>                
            </fm:form>         
        </div>
    </body>
</html>
