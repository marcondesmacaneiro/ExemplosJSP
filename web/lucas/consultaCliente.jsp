<%    
    String aLista = (String) request.getAttribute("alist");
%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Consulta Cliente</title>
    </head>
    <script>
        function serv_alterar(iId, sAca)
        {
            iId = iId.split('_');
            iId = iId[1];
            //$('#'+iId).val(iId);
            document.getElementById('id_chave').value = iId;
            document.getElementById('id_acao').value = sAca;
            //document.location.href = "</%=request.getContextPath()%>/AlterarDados";
        }
        
        function novo_cadastro()
        {
          document.location.href = "<%=request.getContextPath()%>/lucas/cadastroCliente.jsp";
        }
    </script>
    <body>
        <table width="100%">
            <tr>
                <td>
                    <%= aLista%>
                </td>
            </tr>
        </table>
    </body>
</html>