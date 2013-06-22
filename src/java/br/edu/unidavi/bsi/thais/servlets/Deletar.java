/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.thais.servlets;

import br.edu.unidavi.bsi.thais.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.thais.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.thais.model.Cliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thais
 */
@WebServlet(name = "Deletar", urlPatterns = {"/deletar"})
public class Deletar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente();
        cliente.setId(id);
        
           
            try {
                ClienteDAO.getInstance().delete(cliente);
            } catch (UnidaviBsiException ex) {
                Logger.getLogger(Deletar.class.getName()).log(Level.SEVERE, null, ex);
            }
        
         
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/thais/deletar.jsp");
        dispatcher.forward(request, response);
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
        
        