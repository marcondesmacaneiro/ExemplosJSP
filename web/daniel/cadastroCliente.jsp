<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro do Cliente</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/daniel/css/tabelas.css'>
    </head>
    <title>Menu Horizontal</title>
    <body>
        
        <div class='tabelaGC'>
        
            <table>
                <tr>
                    <td class='coluna1'></td>
                    <td class='coluna2'>Cadastro do Cliente</td>
                    <td class='coluna3'></td>
                </tr>
            </table>

            <!-- 1. Configure o valor da action utilizando o método getContextPath() da Request -->
            <!-- Este formulario deve chamar o servlet LeDados -->
            <!-- Verifique a URL no web.xml -->

            <form action='<%=request.getContextPath()%>/CadastroClienteDaniel' method='post'>

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
                    </table>
                    <input type='image' src='<%=request.getContextPath()%>/daniel/images/salvar.gif'>
                </fieldset>
            </form>
        </div>    
    </body>
</html>
