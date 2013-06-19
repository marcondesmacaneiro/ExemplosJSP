<%@page import="br.edu.unidavi.bsi.jorge.model.Cliente" %>

<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

<%
    String mensagem = (String) request.getAttribute("mensagem");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <form action='<%=request.getContextPath()%>/AlterarCliente' method='post'>
        <fieldset>
            <legend>Dados do cliente</legend>
            <table>
                <tr>
                    <td colspan='4'><input name='id' id='id' type='hidden' size='75' maxlength='255' value="<%=cliente.getId()%>"></td>
                </tr>
                <tr>
                    <td><label for='nome'>Nome:</label></td>
                    <td colspan='3'><input name='nome' id='nome' type='text' size='75' maxlength='255' value="<%=cliente.getNome()%>"></td>
                </tr>
                <tr>
                    <td><label for='telefone'>Telefone:&nbsp;(0000-0000)</label></td>
                    <td><input name='telefone' id='telefone' type='text' size='16' value="<%=cliente.getTelefone()%>"></td>
                    <td><label for='email'>e-mail:</label></td>
                    <td><input name='email' id='email' type='text' size='37' value="<%=cliente.getEmail()%>"></td>
                </tr>
                <tr>
                    <td><label for='endereco'>Rua/Av:</label></td>
                    <td><input name='rua' id='rua' type='text' size='40' maxlength='255' value="<%=cliente.getEnderecoRua()%>"></td>
                    <td><label for='numero'>N&uacute;mero:</label></td>
                    <td><input name='numero' id='numero' type='text' size='8' maxlength='5' value="<%=cliente.getEnderecoNumero()%>"></td>
                </tr>
                <tr>
                    <td><label for='bairro'>Bairro:</label></td>
                    <td><input name='bairro' id='bairro' type='text' value="<%=cliente.getEnderecoBairro()%>"></td>
                    <td><label for='cep'>CEP&nbsp;(00000-000):</label></td>
                    <td><input name='cep' id='cep' type='text' size='8' value="<%=cliente.getEnderecoCep()%>"></td>
                </tr>
                <tr>
                    <td><label for='cidade'>Cidade:</label></td>
                    <td><input name='cidade' id='cidade' type='text' value="<%=cliente.getEnderecoCidade()%>"></td>
                    <td><label for='estado'>Estado&nbsp;(XX):</label></td>
                    <td><input name='estado' id='estado' type='text' size='2' value="<%=cliente.getEnderecoEstado()%>"></td>
                </tr>
            </table>
            <input type='image' src='<%=request.getContextPath()%>/jorge/images/salvar.gif'>
            </br>
            <a href='<%=request.getContextPath()%>/jorge/index.jsp'> Voltar </a>
        </fieldset>
        </form>
    </body>
</html>
