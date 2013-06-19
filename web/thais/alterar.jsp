<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="br.edu.unidavi.bsi.thais.model.Cliente"%>


<%
    Cliente cliente = (Cliente) session.getAttribute("cliente");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/css/tabelas.css'>
        <title>AlteraPagina</title>
    </head>
    <body>
        <div class='tabelaGC'>
            <form action='<%=request.getContextPath()%>/digitarEnderecoCliente' method="post">
                <fieldset>
                  <table>
                      <input name="id" type="hidden" id="id" value="<%= cliente.getId() %>">     
                        <tr>
                            <td><label for='nome'>Nome:</label></td>
                            <td><input name='nome' id='nome' type='text' size='75' maxlength='255' value="<%= cliente.getNome()%>"></td>
                            <td><label for='telefone'>Telefone:&nbsp;(0000-0000):</label></td>
                            <td><input name='telefone' id='telefone' type='text' size='16' value="<%= cliente.getTelefone()%>"></td>>
                            <td><label for='email'>e-mail:</label></td>
                            <td><input name='email' id='email' type='text' size='35'valu="<%= cliente.getEmail()%>"></td>
                        </tr>
                  </table>
                </fieldset>
            </form>
                        <form action='<%=request.getContextPath()%>/CadastroClienteThais' method='post'>
                            <table>
                            <tr>
                            <td><label for='endereco'>Rua/Av:</label></td>
                            <td><input name='rua' id='rua' type='text' size='40' maxlength='255'vslue="<%= cliente.getEnderecoRua()%>"></td>
                            <td><label for='numero'>N&uacute;mero:</label></td>
                            <td><input name='numero' id='numero' type='text' size='8' maxlength='5'value="<%= cliente.getEnderecoNumero()%>"></td>
                        </tr>
                        <tr>
                            <td><label for='bairro'>Bairro:</label></td>
                            <td><input name='bairro' id='bairro' type='text'value="<%= cliente.getEnderecoBairro()%>"></td>
                            <td><label for='cep'>CEP&nbsp;(00000-000):</label></td>
                            <td><input name='cep' id='cep' type='text' size='8'value="<%= cliente.getEnderecoCep()%>"></td>
                        </tr>
                        <tr>
                            <td><label for='cidade'>Cidade:</label></td>
                            <td><input name='cidade' id='cidade' type='text' value="<%= cliente.getEnderecoCidade()%>"></td>
                            <td><label for='estado'>Estado&nbsp;(XX):</label></td>
                            <td><input name='estado' id='estado' type='text' size='2' value="<%= cliente.getEnderecoEstado()%>"></td>
                        </tr>
                        <br>
                        <tr>
                            <td><input type='image' src='<%=request.getContextPath()%>/images/salvar.gif'>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>  
    </body>
</html>
