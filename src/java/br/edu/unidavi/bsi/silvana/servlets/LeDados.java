/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.silvana.servlets;

import br.edu.unidavi.bsi.silvana.model.Cliente;
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
@WebServlet(name = "LeDados", urlPatterns = {"/CadastroClientesilvana"})
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
         * 1. Encaminhe a requisição para a página JSP indicada no diagrama.
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/silvana/enderecoCliente.jsp");
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