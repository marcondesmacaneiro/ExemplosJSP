/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.gustavo.servlets;

import br.edu.unidavi.bsi.gustavo.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.gustavo.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.gustavo.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Gustavo
 */
@WebServlet(name = "ExcluirCliente", urlPatterns = {"/AcaoCliente"})
public class AcaoCliente extends HttpServlet {

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
            throws ServletException, IOException, UnidaviBsiException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String acao = request.getParameter("acao");
        
        Cliente c = null;
        ClienteDAO cliDAO = null;
        if(!acao.equalsIgnoreCase("incluir")){
            cliDAO = ClienteDAO.getInstance();
            c = cliDAO.getByPrimaryKey(Integer.parseInt(request.getParameter("id")));
            request.getSession().setAttribute("cliente", c);
        }else{
            request.getSession().setAttribute("cliente", null);
        }
        
        String pagina = "";
        if(acao.equalsIgnoreCase("excluir")){
            cliDAO.delete(c);
            pagina = "/gustavo/listagemClientes.jsp";
        }else{
            request.getSession().setAttribute("acao", acao);
            pagina = "/gustavo/cadastroCliente.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
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
        try {
            processRequest(request, response);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(AcaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(AcaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
