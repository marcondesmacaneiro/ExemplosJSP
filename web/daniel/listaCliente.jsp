<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="br.edu.unidavi.bsi.daniel.model.Cliente"%>
<%@page import="br.edu.unidavi.bsi.daniel.jdbc.ClienteDAO"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Cliente</title>
   <style>
        table.linhasAlternadas {
    border-collapse: collapse; /* CSS2 */
    background: #FFFFF0;
    border: solid green 1px;
}
 
table.linhasAlternadas tr:nth-child(even) /* CSS3 */ {
    background: #F0FFFF;
}
     </style>
    </head>

    <body>
        
        <h1>Listagem de Clientes</h1>
        <%
           ClienteDAO cDao = ClienteDAO.getInstance();
           List<Cliente> lista = cDao.getAll();
           
        %>
        <table border="1" class="linhasAlternadas">
            <tr class="even">
                <td><b>Nome</b></td>
                <td><b>Cidade</b></td>
                <td><b>UF</b></td>
                <td><b>Rua</b></td> 
                <td><b>CEP</b></td> 
                <td><b>Telefone</b></td>
               <!-- <td><b>Excluir</b></td>-->
            </tr>
            <%
                Iterator<Cliente> iterator = lista.iterator();
                while (iterator.hasNext()) {
                    Cliente c = iterator.next();
            %>
            <tr class="even">
                <td><%=c.getNome()%></td>
                <td><%=c.getEnderecoCidade()%></td>
                <td><%=c.getEnderecoEstado()%></td>
                <td><%=c.getEnderecoRua()%></td>
                <td><%=c.getEnderecoCep()%></td>                
                <td><%=c.getTelefone()%></td>  
           <!--<td><img src=<%=request.getContextPath()%>"/daniel/images/excluir.gif" alt="Excluir" onclick="excluir()"/></td>-->
                <!--<td><input type='image' src='<%=request.getContextPath()%>/daniel/images/excluir.gif'> </td>-->            
                <!--<td><img src=<%=request.getContextPath()%>"/daniel/images/excluir.gif" alt="Excluir" onclick="excluir()"/></td> -->
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>