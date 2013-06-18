<%    
    String sDadosCliente = (String) request.getAttribute("dadosCliente");
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Visualizar Cliente</title>
        <script>
            function novo_cadastro(iParam)
            {
              if(iParam == 1)
                document.location.href = "<%=request.getContextPath()%>/BuscaDadosLucas";
              else
                document.location.href = "<%=request.getContextPath()%>/lucas/cadastroCliente.jsp";
            }
        </script>
    </head>
    <body>
        <table width="100%">
            <tr>
                <td>
                    <%= sDadosCliente %>
                </td>
            </tr>
        </table>
    </body>
</html>
