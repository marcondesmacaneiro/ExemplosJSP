<%@page import="br.edu.unidavi.bsi.michel.model.Cliente" %>

<!-- 
1. Obtenha o atributo do escopo de sessão com o nome "cliente", 
   utilizando a tag jsp useBean.
   Para isso, verifique o nome deste atributo e a sua classe no servlet LeDados.
-->
<%
    Cliente cliente = (Cliente) session.getAttribute("cliente");
%>

<!-- 
2. Leia o atributo do escopo de request do tipo String com o nome "mensagem",
   que contem a mensagem a ser impressa na tela, utilizando scriptlet.
-->

<%
    String mensagem = (String) request.getAttribute("mensagem");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cliente Completo</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()+"/michel/css/tabelas.css"%>'>
    </head>
    <body>
        <h1>
            <!-- 3. Imprima aqui a mensagem recuperada no passo 2, utilizando uma expressão. -->
            <%= mensagem %>
        </h1>
      
        <div class='tabelaGC'>
        
            <table>
                <tr>
                    <td class='coluna1'></td>
                    <td class='coluna2'>Cadastro do Cliente</td>
                    <td class='coluna3'></td>
                </tr>
            </table>          
            <fieldset>
                    <legend>Dados do cliente</legend>
                    <table>
                        <tr>
                            <td>Nome:</td>
                            <td>
                                <!-- 4. Imprima o atributo nome do bean cliente-->
                                <%= cliente.getNome() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Telefone:&nbsp;(0000-0000)</td>
                            <td>
                                <!-- 5. Imprima o atributo telefone do bean cliente-->
                                <%= cliente.getTelefone() %>
                            </td>
                        </tr>
                        <tr>
                            <td>e-mail:</td>
                            <td>
                                <!-- 6. Imprima o atributo email do bean cliente-->
                                <%= cliente.getNome() %>
                            </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>Endere&ccedil;o</legend>
                <table>
                    <tr>
                        <td>Rua/Av:</td>
                        <td>
                            <!-- 7. Imprima o atributo enderecoRua do bean cliente-->
                            <%= cliente.getEnderecoRua() %>
                        </td>
                        <td>N&uacute;mero:</td>
                        <td>
                            <!-- 8. Imprima o atributo enderecoNumero do bean cliente-->
                            <%= cliente.getEnderecoNumero() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Bairro:</td>
                        <td>
                            <!-- 9. Imprima o atributo enderecoBairro do bean cliente-->
                            <%= cliente.getEnderecoBairro() %>
                        </td>
                        <td>CEP:</td>
                        <td>
                            <!-- 10. Imprima o atributo enderecoCep do bean cliente-->
                            <%= cliente.getEnderecoCep() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Cidade:</td>
                        <td>
                            <!-- 11. Imprima o atributo enderecoCidade do bean cliente-->
                            <%= cliente.getEnderecoCidade() %>
                        </td>
                        <td>Estado:</td>
                        <td>
                            <!-- 12. Imprima o atributo enderecoEstado do bean cliente-->
                            <%= cliente.getEnderecoEstado() %>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </div>  
    </body>
</html>