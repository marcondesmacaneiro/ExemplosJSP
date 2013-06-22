<%-- 
    Document   : ListaClientes
    Created on : 11/06/2013, 20:56:54
    Author     : Aluno
--%>
<%@page import="java.util.List"%>
<%@page import="br.edu.unidavi.bsi.michel.model.Cliente"%>
<%@page import="br.edu.unidavi.bsi.michel.jdbc.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%
    ClienteDAO cliDAO = ClienteDAO.getInstance();
    List<Cliente> clientes = cliDAO.getAll();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listagem de Clientes</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/michel/css/tabelas.css'>
    </head>
    <body>
         <div class='tabelaGC'>
            <table>
                <tr>
                    <td class='coluna1'></td>
                    <td class='coluna2'>Lista de Clientes</td>
                    <td class='coluna3'></td>
                </tr>
            </table>
             <table style="color: black">
             <%
             for(Cliente c:clientes){
             %>
             <tr>
                 <td>
                    <a href="<%=request.getContextPath()%>/michel/ExcluiClientes.jsp?id=<%=c.getId()%>" > 
                    <input type='image' src='<%=request.getContextPath()%>/michel/images/Excluir.gif'></a>
                 </td>
                 <td >
                     <%=c.getId()%>
                 </td>
                 <td>
                     <%=c.getNome()%>
                 </td>
             </tr>
             <%
                 }
             %>
             </table>
          
         </div>
    </body>
</html>
