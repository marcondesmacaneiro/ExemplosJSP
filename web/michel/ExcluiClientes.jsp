<%@page import="br.edu.unidavi.bsi.michel.model.Cliente"%>
<%@page import="br.edu.unidavi.bsi.michel.jdbc.ClienteDAO"%>
<%
    ClienteDAO cli = ClienteDAO.getInstance();
    Cliente c = (Cliente)cli.getByPrimaryKey(Integer.parseInt(request.getParameter("id")));
    cli.delete(c);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("/michel/ListaClientes.jsp");
        dispatcher.forward(request,response);
%>