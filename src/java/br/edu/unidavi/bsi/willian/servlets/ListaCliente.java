/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.willian.servlets;

import br.edu.unidavi.bsi.willian.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.willian.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.willian.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
 * @author Willian
 */
@WebServlet(name = "ListaCliente", urlPatterns = {"/ListaCliente"})
public class ListaCliente extends HttpServlet {

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
            throws ServletException, IOException, SQLException, UnidaviBsiException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            if (request.getParameter("excluir") != null) {
                Cliente c = ClienteDAO.getInstance().getByPrimaryKey(new Integer(request.getParameter("id")));
                ClienteDAO.getInstance().delete(c);
                //System.out.println("FOIIIIIII");
            }

            List<Cliente> clientes = ClienteDAO.getInstance().getList();

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaCliente</title>");
            out.println("</head>");
            out.println("<body>");

            int i = 0;

            for (Cliente client : clientes) {
                out.print("<table border=0>");
                out.print("<tr>");


                out.print("<td width='30'>");
                out.println(client.getId());
                out.print("</td>");

                out.print("<td width='200'>");
                out.println(client.getNome());
                out.print("</td>");


                out.print("<td>");
                out.print("<form action='" + request.getContextPath() + "/ListaCliente' method='post'>");
                out.println("<input type='hidden' name ='idEditar' value=\'" + client.getId() + "\' >");
                out.println("<input type='submit' name ='editar' id='editar' value='Editar'>");
                out.print("</td>");


                out.print("<td>");
                out.print("<form action='" + request.getContextPath() + "/ListaCliente' method='post'>");
                out.println("<input type='hidden' name ='id' value=\'" + client.getId() + "\' >");
                out.println("<input type='submit' name ='excluir' id='excluir' value='Excluir'>");
                out.print("</form>");

                out.print("</td>");

                out.print("</table>");

                i++;
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
        } catch (SQLException ex) {
            Logger.getLogger(ListaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(ListaCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ListaCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(ListaCliente.class.getName()).log(Level.SEVERE, null, ex);
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
