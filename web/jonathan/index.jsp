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
       <a href='<%=request.getContextPath()%>/jonathan/cadastroCliente.jsp'> CADASTRAR CLIENTE</a>
       </br>
       <a href='<%=request.getContextPath()%>/BuscaClientes'> ALTERAR DADOS E EXCLUIR </a>
    </body>
</html>
