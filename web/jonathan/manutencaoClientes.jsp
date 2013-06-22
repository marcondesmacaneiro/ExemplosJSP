<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.unidavi.bsi.jonathan.model.Cliente" %>

<%
    ArrayList lista = (ArrayList) session.getAttribute("listaClientes");
%>

<%
    String mensagem = (String) request.getAttribute("mensagem");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cliente Completo</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath() + "/jonathan/css/tabelas.css"%>'>
    </head>
    <style>
        td {
            padding: 2px;
        }
    </style>
    <body>
        <div class='tabelaGC'>

            <table border="1">
                <%
                    //Cliente cliente;
                    for (int i = 0; i < lista.size(); i++) {
                        Cliente cliente = (Cliente) lista.get(i);%>
                <tr>
                    <td><%= cliente.getNome()%></td>
                    <td><a href='<%=request.getContextPath()%>/CarregaCliente?id=<%= cliente.getId()%>'> Alterar </a></td>
                    <td><a href='<%=request.getContextPath()%>/ExcluirCliente?id=<%= cliente.getId()%>'> Excluir </a></td>
                </tr>
                <%}
                %>
            </table>
        </fieldset>
        <a href='<%=request.getContextPath()%>/jonathan/index.jsp'> Voltar ao Inicio </a>
    </div>  
</body>
</html>