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
            <c:url var="saveproductsx"  value="guardarFacturas" />
            <fm:form modelAttribute="modeloFacturas" method="post" action="${saveproductsx}">
                <table>
                    <a href="../../../../java/pe/edu/upeu/control/FacturasController.java"></a>

                    <tr>
                        <td><fm:label path="numeroFactura">Numero</fm:label> </td>
                        <td><fm:input path="numeroFactura" size="60" /></td>
                    </tr>

                    <tr>
                        <td><fm:label path="fechaFactura">Fecha</fm:label> </td>                        
                        <td><fm:input path="fechaFactura" size="60" /></td>
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
                        <td colspan="2"><input type="submit" value="Enviar" > </td>
                    </tr>
                </table>                
            </fm:form>         
        </div>
    </body>
</html>
