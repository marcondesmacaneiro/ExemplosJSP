/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.viniciussebold.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius
 */
@WebServlet(name = "AlterarExcluir", urlPatterns = {"/AlterarExcluir"})
public class AlterarExcluir extends HttpServlet {

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
        String req     = request.getParameter("req");
          String cliente = request.getParameter("cliente");
          int id         = Integer.parseInt(cliente);
          String nome    = request.getParameter("nome");
          String tel     = request.getParameter("tel");
          String email   = request.getParameter("email");
          String bairro  = request.getParameter("bairro");
          String rua     = request.getParameter("rua");
          String numero  = request.getParameter("numero");
          String cep     = request.getParameter("cep");
          String cidade  = request.getParameter("cidade");
          String estado  = request.getParameter("estado");  
          response.setContentType("text/plain");
          PrintWriter out = response.getWriter();
          Connection con = null;
          try
          {
             Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
             con.setAutoCommit(false);
             Statement state = con.createStatement();
             if(req.equals("1")) {
                  state.executeUpdate("UPDATE clientes SET nome = '"+nome+"', email = '"+email+"', telefone = '"+tel+"', endereco_numero = '"+numero+"', endereco_rua = '"+rua+"', endereco_bairro = '"+bairro+"', endereco_cidade = '"+cidade+"', endereco_estado = '"+estado+"', endereco_cep = '"+cep+"' where id ="+id);
              }
             else if(req.equals("2")) {
                  state.executeUpdate("DELETE FROM clientes WHERE id ="+id);
              }  
             con.commit();              
          }
          catch(Exception e)
          {    
             try
             {
                con.rollback();
             }
             catch(SQLException ignored)
             {
                  
             }
          }
          finally
          {
             try
             {
                if(con != null) {
                     con.close();
                 }
             }
             catch(SQLException ignored)
             { 
              
             }
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
