<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
       <input type="button" value="Novo Cadastro" onclick='document.location.href = "<%=request.getContextPath()%>/lucas/cadastroCliente.jsp"'>
       <br>
       <input type="button" value="Consulta Clientes" onclick='document.location.href = "<%=request.getContextPath()%>/BuscaDadosLucas"'>
    </body>
</html>