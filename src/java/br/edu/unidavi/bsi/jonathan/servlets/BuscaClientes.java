/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.jonathan.servlets;


import br.edu.unidavi.bsi.jonathan.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.jonathan.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.jonathan.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeferson Duwe
 */
@WebServlet(name = "BuscaClientes", urlPatterns = {"/BuscaClientes"})
public class BuscaClientes extends HttpServlet {

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
        
        // Leitura do cliente na session
        /*Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        
        // Leitura dos parametros da Request
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        
        // coloca endereco no cliente
        cliente.setEnderecoRua(rua);
        cliente.setEnderecoNumero(numero);
        cliente.setEnderecoBairro(bairro);
        cliente.setEnderecoCep(cep);
        cliente.setEnderecoCidade(cidade);
        cliente.setEnderecoEstado(estado);
        */
        String mensagem = "";
        
        /*try{
            ClienteDAO.getInstance().save(cliente);
        } catch(UnidaviBsiException e){
            e.getCause().printStackTrace();
            mensagem = "Não foi possível cadastrar o cliente no banco de dados";
        }*/
        List lista = null;
        try{
            lista = ClienteDAO.getInstance().getAll();
            request.getSession().setAttribute("listaClientes",lista);
        } catch(UnidaviBsiException e){
            e.getCause().printStackTrace();
            mensagem = "Não foi possível recuperar os clientes cadastrados";
        }
        
        request.setAttribute("mensagem", mensagem);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jonathan/manutencaoClientes.jsp");
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
