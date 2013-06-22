<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/aw", "root", "");
        Statement state = connect.createStatement();
        ResultSet resultado = state.executeQuery("Select * from clientes");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cliente Completo</title>
        <link type='text/css' rel='stylesheet' href='<%=request.getContextPath()+"/ruan/css/tabelas.css"%>'>
        <script type="text/javascript" src="jquery.js" ></script>
    </head> 
<script>
    function bloq(param)
    {   
        for(var i=0;i<param;i++)
        {
            document.getElementById("nome"+i).disabled = true;
            document.getElementById("tel"+i).disabled = true;
            document.getElementById("email"+i).disabled = true;
            document.getElementById("rua"+i).disabled = true;
            document.getElementById("bairro"+i).disabled = true;
            document.getElementById("cidade"+i).disabled = true;
            document.getElementById("num"+i).disabled = true;
            document.getElementById("cep"+i).disabled = true;
            document.getElementById("uf"+i).disabled = true;
        }
    }
    function unbloq(i)
    {
            document.getElementById("nome"+i).disabled = false;
            document.getElementById("tel"+i).disabled = false;
            document.getElementById("email"+i).disabled = false;
            document.getElementById("rua"+i).disabled = false;
            document.getElementById("bairro"+i).disabled = false;
            document.getElementById("cidade"+i).disabled = false;
            document.getElementById("num"+i).disabled = false;
            document.getElementById("cep"+i).disabled = false;
            document.getElementById("uf"+i).disabled = false;
            document.getElementById(i).style.display = "none";
            document.getElementById("salvar_"+i).style.display = "";
    }
    function bloq2(i)
    {
            document.getElementById("nome"+i).disabled = true;
            document.getElementById("tel"+i).disabled = true;
            document.getElementById("email"+i).disabled = true;
            document.getElementById("rua"+i).disabled = true;
            document.getElementById("bairro"+i).disabled = true;
            document.getElementById("cidade"+i).disabled = true;
            document.getElementById("num"+i).disabled = true;
            document.getElementById("cep"+i).disabled = true;
            document.getElementById("uf"+i).disabled = true;
            document.getElementById(i).style.display = "";
            document.getElementById("salvar_"+i).style.display = "none";
    }
    function salva_alterecao(id_cliente, id_campos)
    { 
       var nome   = document.getElementById("nome"+id_campos).value; 
       var tel    = document.getElementById("tel"+id_campos).value; 
       var email  = document.getElementById("email"+id_campos).value; 
       var rua    = document.getElementById("rua"+id_campos).value; 
       var bairro = document.getElementById("bairro"+id_campos).value; 
       var cep    = document.getElementById("cep"+id_campos).value; 
       var numero = document.getElementById("num"+id_campos).value; 
       var estado = document.getElementById("uf"+id_campos).value; 
       var cidade = document.getElementById("cidade"+id_campos).value;
       $.ajax({
         url : "<%=request.getContextPath()%>/Clientes",
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
         }
       });
    }
    function exclui_clientes(id_cliente, id_campos)
    {
       var nome   = document.getElementById("nome"+id_campos).value; 
       var tel    = document.getElementById("tel"+id_campos).value; 
       var email  = document.getElementById("email"+id_campos).value; 
       var rua    = document.getElementById("rua"+id_campos).value; 
       var bairro = document.getElementById("bairro"+id_campos).value; 
       var cep    = document.getElementById("cep"+id_campos).value; 
       var numero = document.getElementById("num"+id_campos).value; 
       var estado = document.getElementById("uf"+id_campos).value; 
       var cidade = document.getElementById("cidade"+id_campos).value;
       $.ajax({
         url : "<%=request.getContextPath()%>/Clientes",
         type : 'GET',
         dataType: "json",
         data : { req:"2",
                  cliente:id_cliente,
                  noem:nome,
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
    <body>
         <div class='tabelaGC'>       
            <table>
                <tr>
                    <td class='coluna1'></td>
                    <td class='coluna2'>Clientes Cadastrados</td>
                    <td class='coluna3'></td>
                </tr>
            </table>
            <%
                int i=0;
                while(resultado.next()){
                    int id = i;
                    String nome = "nome"+i;
                    String tel = "tel"+i;
                    String email = "email"+i;
                    String rua = "rua"+i;
                    String bairro = "bairro"+i;
                    String cidade = "cidade"+i;
                    String num = "num"+i;
                    String cep = "cep"+i;
                    String uf = "uf"+i;
                    String salvar = "salvar_"+i;
            %>
            <fieldset>
                    <legend>Dados do cliente</legend>
                    <table>
                        <tr>
                            <td width="15%">Nome:</td>
                            <td>
                                <input type="text" id="<%=nome%>" value="<%=resultado.getString("nome")%>">
                            </td>
                            <td>
                                <input type="button" value="Alterar" id="<%=id%>" onclick="unbloq(this.id);"> 
                                <input type="button" value="Salvar" id="<%=salvar%>" style="display: none;" onclick="bloq2(<%=i%>); salva_alterecao(<%=resultado.getString("id")%>,<%=i%>)"> 
                            </td>         
                        </tr>
                        <tr>
                            <td>Telefone:&nbsp;(0000-0000)</td>
                            <td>
                                <input type="text" id="<%=tel%>" value="<%=resultado.getString("telefone")%>">
                            </td>
                            <td>
                                <input type="button" value="Remover" onclick="exclui_clientes(<%=resultado.getString("id")%>,<%=i%>)">
                            </td>
                        </tr>
                        <tr>
                            <td>e-mail:</td>
                            <td>
                                <input type="text" id="<%=email%>" value="<%=resultado.getString("email")%>">
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
                            <input type="text" id="<%=rua%>" value="<%=resultado.getString("endereco_rua")%>">
                        </td>
                        <td>N&uacute;mero:</td>
                        <td>
                            <input type="text" id="<%=num%>" value="<%=resultado.getString("endereco_numero")%>">
                        </td>
                    </tr>
                    <tr>
                        <td>Bairro:</td>
                        <td>
                            <input type="text" id="<%=bairro%>" value="<%=resultado.getString("endereco_bairro")%>">
                        </td>
                        <td>CEP:</td>
                        <td>
                            <input type="text" id="<%=cep%>" value="<%=resultado.getString("endereco_cep")%>">
                        </td>
                    </tr>
                    <tr>
                        <td>Cidade:</td>
                        <td>
                            <input type="text" id="<%=cidade%>" value="<%=resultado.getString("endereco_cidade")%>">
                        </td>
                        <td>Estado:</td>
                        <td>
                            <input type="text" id="<%=uf%>" value="<%=resultado.getString("endereco_estado")%>">
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td>
                            ______________________________________________________________________________________________________________________________________________________________________________
                        </td>
                    </tr>
                </table>
            </fieldset>
            <%
               i++;
               }
            %>
        </div>  
    </body>
</html>
<script>
    bloq(<%=i%>)
</script>
<% 
resultado.close();
state.close();
connect.close();
}
catch(Exception e)
{
   System.out.println("erro");     
}
%>
