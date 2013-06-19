<%@page import="br.edu.unidavi.bsi.thais.model.Cliente"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%
    Cliente cliente = (Cliente) session.getAttribute("cliente");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <input name="id" type="hidden" id="id"> <%= cliente.getId() %> 
       
        
               
    
        
    </body>
</html>
