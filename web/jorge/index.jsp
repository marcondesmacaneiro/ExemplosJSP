<%-- 
    Document   : index
    Created on : May 21, 2013, 9:48:33 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <a href='<%=request.getContextPath()%>/jorge/cadastroCliente.jsp'> Cadastro de Clientes </a> <br/>
        </br>
       <a href='<%=request.getContextPath()%>/BuscaClientes'> Alteração/Exclução de Clientes </a>
    </body>
</html>
