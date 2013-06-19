/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.leonardo.servlets;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.edu.unidavi.bsi.leonardo.locator.ServiceLocator;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Leo
 */
@WebServlet(name = "Altera_exclui", urlPatterns = {"/Altera_exclui"})
public class Altera_exclui extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
    }

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
        throws ServletException, IOException
        {
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
             if(req.equals("1"))
               state.executeUpdate("UPDATE clientes SET nome = '"+nome+"', email = '"+email+"', telefone = '"+tel+"', endereco_numero = '"+numero+"', endereco_rua = '"+rua+"', endereco_bairro = '"+bairro+"', endereco_cidade = '"+cidade+"', endereco_estado = '"+estado+"', endereco_cep = '"+cep+"' where id ="+id);
             else if(req.equals("2"))
               state.executeUpdate("DELETE FROM clientes WHERE id ="+id);  
             con.commit();
            /* if(req.equals("1"))
               out.println("Atualiza��o realizada com Sucesso para o Cliente de ID: "+id);
             else if(req.equals("2"))
               out.println("Exclus�o realizada com Sucesso para o Cliente de ID: "+id);   */
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
            /* if(req.equals("1"))
               out.println("Atualiza��o N�o Realizada");
             else if(req.equals("2"))
               out.println("Exclus�o N�o Realizada");*/
          }
          finally
          {
             try
             {
                if(con != null) 
                   con.close();
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
 
}
