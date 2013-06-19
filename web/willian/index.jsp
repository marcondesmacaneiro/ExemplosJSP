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
       <a href='<%=request.getContextPath()%>/willian/jsp/cadastroCliente.jsp'> Clique aqui para ir para o Cadastro do Cliente. </a>
       <br>
       <a href='<%=request.getContextPath()%>/ListaCliente'> Clique aqui para ir para listar os Clientes. </a>
    </body>
</html>
