<%@page import="java.util.List"%>
<%@page import="br.edu.unidavi.bsi.gustavo.model.Cliente"%>
<%@page import="br.edu.unidavi.bsi.gustavo.jdbc.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%
ClienteDAO cliDAO = ClienteDAO.getInstance();
List<Cliente> clientes = cliDAO.getAll();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/gustavo/css/tabelas.css'>
    </head>
    <body>
        <div class='tabelaGC'>
        
            <table>
                <tr>
                    <td class='coluna1'></td>
                    <td class='coluna2'>Listagem dos Clientes</td>
                    <td class='coluna3'></td>
                </tr>
            </table>
        </div>
            
        <form action='<%=request.getContextPath()%>/AcaoCliente' method='post'>
            <input type="hidden" name="acao" id="acao">
            <input type="hidden" name="id" id="id">
        </form>
            <table border="0" style="width: 100%">
            <tr style="background-color: black">
                <td colspan="999">
                    <input type='image' src='<%=request.getContextPath()%>/gustavo/images/incluir.png' 
                           onclick="document.getElementById('acao').value = 'incluir'
                                    document.forms[0].submit();">
                </td>
            </tr>
            
            <tr style="background-color: activecaption">
                <td colspan="3">
                    <b>Ações
                </td>
                <td>
                    <b>Id
                </td>
                <td>
                    <b>Nome
                </td>
            </tr>
        <%
        int i = 0;    
        for(Cliente c:clientes){
            %>
            <tr <%=i++%2==1?"style=\"background-color: lightblue\"":"style=\"background-color: lightgreen\""%>>
                <td>
                    <input type='image' src='<%=request.getContextPath()%>/gustavo/images/alterar.png' 
                           onclick="document.getElementById('id').value = <%=c.getId()%>;
                                    document.getElementById('acao').value = 'alterar'
                                    document.forms[0].submit();">
                </td>
                <td>
                    <input type='image' src='<%=request.getContextPath()%>/gustavo/images/visualizar.png' 
                           onclick="document.getElementById('id').value = <%=c.getId()%>;
                                    document.getElementById('acao').value = 'visualizar'
                                    document.forms[0].submit();">
                </td>
                <td>
                    <input type='image' src='<%=request.getContextPath()%>/gustavo/images/excluir.png' 
                           onclick="document.getElementById('id').value = <%=c.getId()%>;
                                    document.getElementById('acao').value = 'excluir'
                                    document.forms[0].submit();">
                </td>
                
                <td>
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
        
    </body>
</html>
