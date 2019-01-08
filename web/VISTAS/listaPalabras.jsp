<%-- 
    Document   : newjsp
    Created on : Jan 8, 2019, 8:56:02 AM
    Author     : rafaelm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Modismos!</title>
    </head>
    <body>
        <h1>Modismos de Cohort 12 xdxd</h1>
        <table border=3>
            <thead>
                <tr>
                    <th>Palabra ID</th>
                    <th>Palabra</th>
                    <th>Definición</th>
                    <th>Región</th>
                    <th>Acciones</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${palabras}" var="palabra">
                    <tr>
                        <td> <c:out value="${palabra.idPalabra}"/> </td>
                        <td> <c:out value="${palabra.palabra}"/> </td>
                            <td> <c:out value="${palabra.definicion}"/> </td>
                        <td> <c:out value="${palabra.region}"/> </td>
                        <td><a href="ModismoController?accion=editar&palabraId=<c:out value="${palabra.idPalabra}"/>">Editar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <p><a href="ModismoController?accion=agregar">Agregar Palabra</a></p>
        
    </body>
</html>
