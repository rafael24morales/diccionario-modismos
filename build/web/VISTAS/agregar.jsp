<%-- 
    Document   : agregar
    Created on : Jan 8, 2019, 12:08:37 PM
    Author     : rafaelm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="ModismoController" >
            Id de Palabra: <input type="text" readonly name="palabraId" 
                            value="<c:out value="${palabra.idPalabra}"/>">
            <br/>
            Palabra:  <input type="text" name="palabra" 
                             value="<c:out value="${palabra.palabra}"/>">
            <br/>
            Definición:  <input type="text" name="definicion" 
                                value="<c:out value="${palabra.definicion}"/>">
            <br/>
            Zona:  <input type="text" name="region" 
                          value="<c:out value="${palabra.region}"/>">
            <br/>
            <input type="submit" value="Envia">                    
        </form>
    </body>
</html>
