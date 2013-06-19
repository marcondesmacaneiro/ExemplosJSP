/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.leonardo.servlets;

import br.edu.unidavi.bsi.leonardo.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcondes
 */
@WebServlet(name = "LeDados", urlPatterns = {"/DigitarEnderecoClienteLeonardo"})
public class LeDados extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        /* Leitura dos parametros da Request*/
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        Cliente cliente = new Cliente(nome,email, "", telefone,true);
        
        // objeto cliente na session
        request.getSession().setAttribute("cliente",cliente);
        
        /*
         * 1. Encaminhe a requisi??o para a p?gina JSP indicada no diagrama.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/leonardo/enderecoCliente.jsp");
        dispatcher.forward(request,response);
        
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
