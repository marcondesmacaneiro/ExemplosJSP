<%-- 
    Document   : listarclientes
    Created on : 15/06/2013, 14:34:09
    Author     : Vinicius
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%
try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    Statement state = conn.createStatement();
    ResultSet clientes = state.executeQuery("Select * from clientes");
    
   

%>
<script>
    function bloqcampos(param){
        for(var i=0;i<param;i++){
            document.getElementById("nome"+i).disabled = true;
            document.getElementById("tel"+i).disabled = true;
            document.getElementById("email"+i).disabled = true;
            document.getElementById("rua"+i).disabled = true;
            document.getElementById("bairro"+i).disabled = true;
            document.getElementById("cep"+i).disabled = true;
            document.getElementById("num"+i).disabled = true;
            document.getElementById("estado"+i).disabled = true;
            document.getElementById("cidade"+i).disabled = true;
        }
    }
    function desbloqcampos(i){
            document.getElementById("nome"+i).disabled = false;
            document.getElementById("tel"+i).disabled = false;
            document.getElementById("email"+i).disabled = false;
            document.getElementById("rua"+i).disabled = false;
            document.getElementById("bairro"+i).disabled = false;
            document.getElementById("cep"+i).disabled = false;
            document.getElementById("num"+i).disabled = false;
            document.getElementById("estado"+i).disabled = false;
            document.getElementById("cidade"+i).disabled = false;
            document.getElementById(i).style.display = "none";
            document.getElementById("salvar"+i).style.display = "";
    }
    function reblock(i){
            document.getElementById("nome"+i).disabled = true;
            document.getElementById("tel"+i).disabled = true;
            document.getElementById("email"+i).disabled = true;
            document.getElementById("rua"+i).disabled = true;
            document.getElementById("bairro"+i).disabled = true;
            document.getElementById("cep"+i).disabled = true;
            document.getElementById("num"+i).disabled = true;
            document.getElementById("estado"+i).disabled = true;
            document.getElementById("cidade"+i).disabled = true;
            document.getElementById(i).style.display = "";
            document.getElementById("salvar"+i).style.display = "none";
    }
    function salvaralt(id_cliente, id_campos)
    { 
       var nome   = document.getElementById("nome"+id_campos).value; 
       var tel    = document.getElementById("tel"+id_campos).value; 
       var email  = document.getElementById("email"+id_campos).value; 
       var rua    = document.getElementById("rua"+id_campos).value; 
       var bairro = document.getElementById("bairro"+id_campos).value; 
       var cep    = document.getElementById("cep"+id_campos).value; 
       var numero = document.getElementById("num"+id_campos).value; 
       var estado = document.getElementById("estado"+id_campos).value; 
       var cidade = document.getElementById("cidade"+id_campos).value;
       $.ajax({
         url : "<%=request.getContextPath()%>/AlterarExcluir",
         type : 'GET',
         dataType: "json",
         data : { req:"1",
                  cliente:id_cliente,
                  nome:nome,
                  tel:tel,
                  email:email,
                  rua:rua,
                  bairro:bairro,
                  cep:cep,
                  numero:numero,
                  estado:estado,
                  cidade:cidade
                },
         success: function(oRetorno){
           //window.location.reload();
         }
       });
    }
    function excluir(id_cliente, id_campos)
    {
       var nome   = document.getElementById("nome"+id_campos).value; 
       var tel    = document.getElementById("tel"+id_campos).value; 
       var email  = document.getElementById("email"+id_campos).value; 
       var rua    = document.getElementById("rua"+id_campos).value; 
       var bairro = document.getElementById("bairro"+id_campos).value; 
       var cep    = document.getElementById("cep"+id_campos).value; 
       var numero = document.getElementById("num"+id_campos).value; 
       var estado = document.getElementById("estado"+id_campos).value; 
       var cidade = document.getElementById("cidade"+id_campos).value;
       $.ajax({
         url : "<%=request.getContextPath()%>/AlterarExcluir",
         type : 'GET',
         dataType: "json",
         data : { req:"2",
                  cliente:id_cliente,
                  nome:nome,
                  tel:tel,
                  email:email,
                  rua:rua,
                  bairro:bairro,
                  cep:cep,
                  numero:numero,
                  estado:estado,
                  cidade:cidade
                },                                                                                                                                                   
         success: function(oRetorno){
           window.location.reload();
         }
       }); 
    }
</script>

<!DOCTYPE html>
<html>
    <head>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/viniciussebold/css/tabelas.css'>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script type="text/javascript" src="jquery.js" ></script>
        <title>JSP Page</title>
    </head>
    <body>
        <table width ="100%">
            <tr>
                <td>
                     <div class='tabelaGC'>
                    <%
                        int i = 0;
                        while (clientes.next()) {
                            String nome = "nome" + i;
                            String tel = "tel" + i;
                            String email = "email" + i;
                            String rua = "rua" + i;
                            String bairro = "bairro" + i;
                            String cep = "cep" + i;
                            String num = "num" + i;
                            String estado = "estado" + i;
                            String cidade = "cidade" + i;
                            String salvar = "salvar" + i;
                            int value = i;

                    %>
                   

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
                                    <td width="15%">Nome:</td>
                                    <td>
                                        <!-- 4. Imprima o atributo nome do bean cliente-->
                                        <input type="text" id="<%=nome%>" value="<%=clientes.getString("nome")%>">
                                    </td>
                                    <td align="right">
                                        <input type="button" value="Alterar" id="<%=value%>" onclick="desbloqcampos(this.id);">
                                        <input style="display: none" id="<%=salvar%>" type="button" value="Salvar" onclick="reblock(<%=i%>); salvaralt(<%=clientes.getString("id")%>,<%=i%>)">     
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td>Telefone:&nbsp;(0000-0000)</td>
                                    <td>
                                        <!-- 5. Imprima o atributo telefone do bean cliente-->
                                        <input type="text" id="<%=tel%>" value="<%=clientes.getString("telefone")%>">
                                    </td>
                                    <td align="right">
                                        <input type="button" value="Excluir" onclick="excluir(<%=clientes.getString("id")%>,<%=i%>)">
                                             
                                    </td>
                                </tr>
                                <tr>
                                    <td width="15%">e-mail:</td>
                                    <td>
                                        <!-- 6. Imprima o atributo email do bean cliente-->
                                        <input type="text" id="<%=email%>" value="<%=clientes.getString("email")%>">
                                    </td>
                                    <td>
                                               
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                        <fieldset>
                            <legend>Endere&ccedil;o</legend>
                            <table>
                                <tr>
                                    <td width="15%">Rua/Av:</td>
                                    <td>
                                        <!-- 7. Imprima o atributo enderecoRua do bean cliente-->
                                        <input type="text" id="<%=rua%>" value="<%=clientes.getString("endereco_rua")%>">
                                    </td>
                                    <td>N&uacute;mero:</td>
                                    <td>
                                        <!-- 8. Imprima o atributo enderecoNumero do bean cliente-->
                                        <input type="text" id="<%=num%>" value="<%=clientes.getString("endereco_numero")%>">
                                    </td>   
                                </tr>
                                <tr>
                                    <td>Bairro:</td>
                                    <td>
                                        <!-- 9. Imprima o atributo enderecoBairro do bean cliente-->
                                        <input type="text" id="<%=bairro%>" value="<%=clientes.getString("endereco_bairro")%>">
                                    </td>
                                    <td>CEP:</td>
                                    <td>
                                        <!-- 10. Imprima o atributo enderecoCep do bean cliente-->
                                        <input type="text" id="<%=cep%>" value="<%=clientes.getString("endereco_cep")%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>Cidade:</td>
                                    <td>
                                        <!-- 11. Imprima o atributo enderecoCidade do bean cliente-->
                                        <input type="text" id="<%=cidade%>" value="<%=clientes.getString("endereco_cidade")%>">
                                    </td>
                                    <td>Estado:</td>
                                    <td>
                                        <!-- 12. Imprima o atributo enderecoEstado do bean cliente-->
                                        <input type="text" id="<%=estado%>" value="<%=clientes.getString("endereco_estado")%>">
                                    </td>
                                </tr>
                            </table>
                        </fieldset>

                        <%
                                i++;
                            }
                        %>
                    </div> 
                </td>
            </tr>
        </table>
    </body>
</html>
<script>
    bloqcampos(<%=i%>)
</script>
<%
 clientes.close();
 state.close();
 conn.close();
}
catch(Exception e){
    System.out.println("Erro");
}
%>