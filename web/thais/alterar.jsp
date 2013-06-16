<%-- 
    Document   : alterar
    Created on : 15/06/2013, 21:43:56
    Author     : Thais
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/css/tabelas.css'>
        <title>AlteraPagina</title>
    </head>
    <body>
        <div class='tabelaGC'>

            <table>
                <tr>
                    <td class='coluna1'></td>
                    <td class='coluna2'>Cadastro do Cliente</td>
                    <td class='coluna3'></td>
                </tr>

            </table>
        </div>
        <!-- 1. Configure o valor da action utilizando o método getContextPath() da Request -->
        <!-- Este formulario deve chamar o servlet LeDados -->
        <!-- Verifique a URL no web.xml -->

        <form action='<%=request.getContextPath()%>/CadastroClienteThais' method='post'>

            <fieldset>
                <legend>Dados do cliente</legend>
                <table>
                    <tr>
                        <td><label for='nome'>Nome:</label></td>
                        <td colspan='3'><input name='nome' id='nome' type='text' size='75' maxlength='255'></td>
                    </tr>
                    <tr>
                        <td><label for='telefone'>Telefone:&nbsp;(0000-0000)</label></td>
                        <td><input name='telefone' id='telefone' type='text' size='16'></td>
                        <td><label for='email'>e-mail:</label></td>
                        <td><input name='email' id='email' type='text' size='37'></td>
                    </tr>
                    <tr>
                        <td><label for='endereco'>Rua/Av:</label></td>
                        <td><input name='rua' id='rua' type='text' size='40' maxlength='255'></td>
                        <td><label for='numero'>N&uacute;mero:</label></td>
                        <td><input name='numero' id='numero' type='text' size='8' maxlength='5'></td>
                    </tr>
                    <tr>
                        <td><label for='bairro'>Bairro:</label></td>
                        <td><input name='bairro' id='bairro' type='text'></td>
                        <td><label for='cep'>CEP&nbsp;(00000-000):</label></td>
                        <td><input name='cep' id='cep' type='text' size='8'></td>
                    </tr>
                    <tr>
                        <td><label for='cidade'>Cidade:</label></td>
                        <td><input name='cidade' id='cidade' type='text'></td>
                        <td><label for='estado'>Estado&nbsp;(XX):</label></td>
                        <td><input name='estado' id='estado' type='text' size='2'></td>
                    </tr>
                </table>
                <input type='image' src='<%=request.getContextPath()%>/images/salvar.gif'>
            </fieldset>
        </form>
    </body>
</html>
