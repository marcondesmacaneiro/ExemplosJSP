<%@page import="br.edu.unidavi.bsi.gustavo.model.Cliente"%>
<%
    String acao = (String) request.getSession().getAttribute("acao");
    Cliente cliente = new Cliente();
    if(request.getSession().getAttribute("cliente") != null){
        cliente = (Cliente) request.getSession().getAttribute("cliente");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro do Cliente</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/gustavo/css/tabelas.css'>
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

            <!-- 1. Configure o valor da action utilizando o m�todo getContextPath() da Request -->
            <!-- Este formulario deve chamar o servlet LeDados -->
            <!-- Verifique a URL no web.xml -->

            <form action='<%=request.getContextPath()%>/digitarEnderecoClienteGustavo' method='post'>
                <input type="hidden" name="id" value="<%=cliente.getId()%>">
                <fieldset>
                    <legend>Dados do cliente</legend>
                    <table>
                        <tr>
                            <td><label for='nome'>Nome:</label></td>
                            <td colspan='3'><input name='nome' id='nome' type='text' size='75' maxlength='255' value='<%=cliente.getNome()%>' <%=acao.equals("visualizar")?"readonly":""%>></td>
                        </tr>
                        <tr>
                            <td><label for='telefone'>Telefone:&nbsp;(0000-0000)</label></td>
                            <td><input name='telefone' id='telefone' type='text' size='16' value='<%=cliente.getTelefone()%>' <%=acao.equals("visualizar")?"readonly":""%> ></td>
                            <td><label for='email'>e-mail:</label></td>
                            <td><input name='email' id='email' type='text' size='37' value='<%=cliente.getEmail()%>' <%=acao.equals("visualizar")?"readonly":""%>></td>
                        </tr>
                    </table>
                    <input type='image' src='<%=request.getContextPath()%>/gustavo/images/salvar.gif'>
                </fieldset>
            </form>
        </div>    
    </body>
</html>
