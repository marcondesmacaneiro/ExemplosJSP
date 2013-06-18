<%-- 
    Document   : index
    Created on : May 21, 2013, 9:48:33 PM
    Author     : marcondes
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
       <a href='<%=request.getContextPath()%>/leonardo/cadastroCliente.jsp'> Cadastrar Clientes </a> <br>
       <a href='<%=request.getContextPath()%>/leonardo/all_Clientes.jsp'> Alterar ou Excluir Clientes </a>
    </body>
</html>
