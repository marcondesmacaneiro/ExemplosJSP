<%@page import="br.edu.unidavi.bsi.daniel.model.Cliente"%>
<%@page import="br.edu.unidavi.bsi.daniel.jdbc.ClienteDAO"%>
<%
  ClienteDAO cliDao = ClienteDAO.getInstance();
  Cliente c =  cliDao.getByPrimaryKey(Integer.parseInt(request.getParameter("ID")));
  
  cliDao.delete(c);
  
  
  RequestDispatcher dispatcher = request.getRequestDispatcher("/daniel/ExcluirCliente.jsp");
  dispatcher.forward(request, response);
 







%>