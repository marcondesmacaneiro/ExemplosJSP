package br.edu.unidavi.bsi.lucas.servlets;

import br.edu.unidavi.bsi.lucas.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.lucas.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.lucas.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarAlterar", urlPatterns = {"/CadastrarAlterar"})
public class CadastrarAlterar extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, UnidaviBsiException {
        
        int iId = Integer.parseInt(request.getParameter("id"));
        String sNome = request.getParameter("nome");
        String sTelefone = request.getParameter("telefone");
        String sEmail = request.getParameter("email");
        String sRua = request.getParameter("rua");
        String sBairro = request.getParameter("bairro");
        String sCidade = request.getParameter("cidade");
        String sNumero = request.getParameter("numero");
        String sCep = request.getParameter("cep");
        String sEstado = request.getParameter("estado");
        
        Cliente oCliente = new Cliente(iId, sNome, sEmail, "", sTelefone, true, sRua, sNumero, sBairro, sCep, sCidade, sEstado);
        
        ClienteDAO.getInstance().save(oCliente);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/BuscaDadosLucas");
        dispatcher.forward(request, response);
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(AlterarDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(AlterarDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}