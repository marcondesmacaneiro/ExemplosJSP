/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.jorge.servlets;

import br.edu.unidavi.bsi.jorge.exeption.UnidaviBsiException;
import br.edu.unidavi.bsi.jorge.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.jorge.model.Cliente;
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
 * @author Jorge
 */
@WebServlet(name = "CarregaCliente", urlPatterns = {"/CarregaCliente"})
public class CarregaCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Nesse parametro conforme o usuario selecionado ele pega o ID do usuarios cadastrado e puxa somente
         os dados do clientes selecionado*/
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(request.getParameter("id")));
        String mensagem = "Cliente Carregado com sucesso.";
        try{
            cliente = (Cliente) ClienteDAO.getInstance().getByPrimaryKey(Integer.parseInt(request.getParameter("id")));
        } catch(UnidaviBsiException e){
            e.getCause().printStackTrace();
            mensagem = "Não foi possível carregar o cliente selecionado";
        }
        request.setAttribute("cliente", cliente);
        request.setAttribute("mensagem", mensagem);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jorge/manutencaoCliente.jsp");
        dispatcher.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
