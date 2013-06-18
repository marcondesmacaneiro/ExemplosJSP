<%-- 
    Document   : all_Clientes
    Created on : Jun 15, 2013, 2:29:31 PM
    Author     : Leo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%
  try
  {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
    Statement state = conect.createStatement();
    ResultSet resultado = state.executeQuery("Select * from clientes order by id asc");
%>
<script>
    function bloqueia_campos(param)
    {
       for(var i=0; i<param; i++)
       {
          document.getElementById("nome_"+i).disabled = true; 
          document.getElementById("tel_"+i).disabled = true; 
          document.getElementById("email_"+i).disabled = true; 
          document.getElementById("rua_"+i).disabled = true; 
          document.getElementById("bairro_"+i).disabled = true; 
          document.getElementById("cep_"+i).disabled = true; 
          document.getElementById("num_"+i).disabled = true; 
          document.getElementById("estado_"+i).disabled = true; 
          document.getElementById("cidade_"+i).disabled = true; 
       }
    }
    function desbloqueia_campos(i)
    {
       document.getElementById("nome_"+i).disabled = false; 
       document.getElementById("tel_"+i).disabled = false; 
       document.getElementById("email_"+i).disabled = false; 
       document.getElementById("rua_"+i).disabled = false; 
       document.getElementById("bairro_"+i).disabled = false; 
       document.getElementById("cep_"+i).disabled = false; 
       document.getElementById("num_"+i).disabled = false; 
       document.getElementById("estado_"+i).disabled = false; 
       document.getElementById("cidade_"+i).disabled = false;
       document.getElementById(i).style.display = "none";      
       document.getElementById("salvar_"+i).style.display = "";      
    }
    function bloqueia_campo_esp(i)
    {
       document.getElementById("nome_"+i).disabled = true; 
       document.getElementById("tel_"+i).disabled = true; 
       document.getElementById("email_"+i).disabled = true; 
       document.getElementById("rua_"+i).disabled = true; 
       document.getElementById("bairro_"+i).disabled = true; 
       document.getElementById("cep_"+i).disabled = true; 
       document.getElementById("num_"+i).disabled = true; 
       document.getElementById("estado_"+i).disabled = true; 
       document.getElementById("cidade_"+i).disabled = true;
       document.getElementById(i).style.display = "";      
       document.getElementById("salvar_"+i).style.display = "none";      
    }
    function salva_alterecao(id_cliente, id_campos)
    { 
       var nome   = document.getElementById("nome_"+id_campos).value; 
       var tel    = document.getElementById("tel_"+id_campos).value; 
       var email  = document.getElementById("email_"+id_campos).value; 
       var rua    = document.getElementById("rua_"+id_campos).value; 
       var bairro = document.getElementById("bairro_"+id_campos).value; 
       var cep    = document.getElementById("cep_"+id_campos).value; 
       var numero = document.getElementById("num_"+id_campos).value; 
       var estado = document.getElementById("estado_"+id_campos).value; 
       var cidade = document.getElementById("cidade_"+id_campos).value;
       $.ajax({
         url : "<%=request.getContextPath()%>/Altera_exclui",
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
    function exclui_clientes(id_cliente, id_campos)
    {
       if(confirm("Confirma Excluir o Cliente de ID: "+id_cliente))
       {
         var nome   = document.getElementById("nome_"+id_campos).value; 
         var tel    = document.getElementById("tel_"+id_campos).value; 
         var email  = document.getElementById("email_"+id_campos).value; 
         var rua    = document.getElementById("rua_"+id_campos).value; 
         var bairro = document.getElementById("bairro_"+id_campos).value; 
         var cep    = document.getElementById("cep_"+id_campos).value; 
         var numero = document.getElementById("num_"+id_campos).value; 
         var estado = document.getElementById("estado_"+id_campos).value; 
         var cidade = document.getElementById("cidade_"+id_campos).value;
         $.ajax({
           url : "<%=request.getContextPath()%>/Altera_exclui",
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
    }
    function Busca_cliente(cliente)
    {
      var oTables = new Array();
      oTables = document.getElementsByTagName('table');
      alert(oTables.id);
    }
    
    function limpa_busca()
    {
        
    }
</script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()%>/leonardo/tabelas.css.css'>
        <script type="text/javascript" src="jquery.js" ></script>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <input type="text" style="width: 300px;" id="busca"> 
                </td>
                <td>
                    <input type="button" value="Procurar" onclick="Busca_cliente(document.getElementById('busca').value);">
                </td>
                <td>
                    <input type="button" value="Limpar" onclick="limpa_busca();">
                </td>
            </tr> 
        </table>
        <table border="0" width="100%">
            <tr>
                <td>
                   <div class='tabelaGC'> 
                    <%
                      int i =0;  
                      while(resultado.next())
                      { 
                         String nome   = "nome_"+i; 
                         String tel    = "tel_"+i; 
                         String email  = "email_"+i; 
                         String rua    = "rua_"+i; 
                         String bairro = "bairro_"+i; 
                         String num    = "num_"+i; 
                         String cep    = "cep_"+i; 
                         String estado = "estado_"+i; 
                         String cidade = "cidade_"+i;
                         String salvar = "salvar_"+i;
                         int valor = i;
                    %>
                   <table id="<%=resultado.getString("id")%>">
                   <tr>
                      <td class='coluna1'></td>
                      <td class='coluna2'>Cadastro do Cliente</td>
                      <td class='coluna3'></td>
                   </tr>
                   </table>          
                   <fieldset>
                      <legend>Dados do cliente - ID: <%=resultado.getString("id")%></legend>
                      <table border='0'>
                         <tr>
                            <td style="width:15%">Nome:</td>
                            <td>
                                <!-- 4. Imprima o atributo nome do bean cliente-->
                                <input type='text'  id="<%=nome%>" value='<%=resultado.getString("nome")%>' style="width:300px;">
                            </td>
                            <td align='right'>
                                <input type="button" value='Alterar' id="<%=valor%>" onclick='desbloqueia_campos(this.id);'> 
                                <input type="button" value='Salvar' id='<%=salvar%>' style='display: none;' onclick='bloqueia_campo_esp(<%=i%>); salva_alterecao(<%=resultado.getString("id")%>,<%=i%>)'> 
                            </td>                        
                         </tr>
                         <tr>
                            <td>Telefone:&nbsp;(0000-0000)</td>
                            <td>
                                <!-- 5. Imprima o atributo telefone do bean cliente-->
                                <input type='text' id="<%=tel%>" value='<%=resultado.getString("telefone")%>' style="width:100px;">
                            </td>
                            <td align='right'>
                                <input type="button" value="Excluir" onclick="exclui_clientes(<%=resultado.getString("id")%>,<%=i%>);">  
                            </td>
                         </tr>
                         <tr>
                            <td>e-mail:</td>
                            <td>
                                <!-- 6. Imprima o atributo email do bean cliente-->
                                <input type='text' id="<%=email%>" value='<%=resultado.getString("email")%>' style="width:300px;">
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
                        <td style="width:15%">Rua/Av:</td>
                        <td>
                            <!-- 7. Imprima o atributo enderecoRua do bean cliente-->
                            <input type='text' id="<%=rua%>" value='<%=resultado.getString("endereco_rua")%>' style="width:300px;">
                        </td>
                        <td style="width:15%">N&uacute;mero:</td>
                        <td>
                            <!-- 8. Imprima o atributo enderecoNumero do bean cliente-->
                            <input type='text' id="<%=num%>" value='<%=resultado.getString("endereco_numero")%>' style="width:100px;">
                        </td>
                    </tr>
                    <tr>
                        <td>Bairro:</td>
                        <td>
                            <!-- 9. Imprima o atributo enderecoBairro do bean cliente-->
                            <input type='text' id="<%=bairro%>" value='<%=resultado.getString("endereco_bairro")%>' style="width:300px;">
                        </td>
                        <td>CEP:</td>
                        <td>
                            <!-- 10. Imprima o atributo enderecoCep do bean cliente-->
                            <input type='text' id="<%=cep%>" value='<%=resultado.getString("endereco_cep")%>' style="width:100px;">
                        </td>
                    </tr>
                    <tr>
                        <td>Cidade:</td>
                        <td>
                            <!-- 11. Imprima o atributo enderecoCidade do bean cliente-->
                            <input type='text' id="<%=cidade%>" value='<%=resultado.getString("endereco_cidade")%>' style="width:300px;">
                        </td>
                        <td>Estado:</td>
                        <td>
                            <!-- 12. Imprima o atributo enderecoEstado do bean cliente-->
                            <input type='text' maxlength="2" id="<%=estado%>" value='<%=resultado.getString("endereco_estado")%>' style="width:30px;">
                        </td>
                     </tr>
                   </table>
                   </fieldset>         
                    <% 
                     i++; }                   
                    %>
                     </div>
                </td>
            </tr>
        </table>
    </body>
</html>
<script>
    bloqueia_campos(<%=i%>);
</script>

<%
  resultado.close();
  state.close();
  conect.close();
}
catch(Exception e)
{
   System.out.println("erro");     
}
%>
