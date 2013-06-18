<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro Cliente</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/leonardo/tabelas.css.css'>
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
        
            <form action='<%=request.getContextPath()%>/CadastroClienteLeonardoFinaliza' method='post'>
                <fieldset>
                    <legend>Endere&ccedil;o</legend>
                    <table>
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
                    <input type='image' src='<%=request.getContextPath()%>/leonardo/salvar.gif'>
                </fieldset>
            </form>
        </div>                        
    </body>
</html>
