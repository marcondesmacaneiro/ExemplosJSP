/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.daniel.servlets;

import br.edu.unidavi.bsi.daniel.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.daniel.servlets.*;
import br.edu.unidavi.bsi.daniel.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.daniel.model.Cliente;
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
 * @author marcondes
 */
@WebServlet(name = "CadastroCliente", urlPatterns = {"/CadastroClienteDanielFinaliza"})
public class CadastroCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        // Leitura do cliente na session
        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        
        /* Leitura dos parametros da Request */
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
        
        String mensagem = "Cadastro efetuado com sucesso!";
        try{
            ClienteDAO.getInstance().save(cliente);
        } catch(Exception e){
            e.getCause().printStackTrace();
            mensagem = "N�o foi poss�vel cadastrar o cliente no banco de dados";
        }
        
        request.setAttribute("mensagem", mensagem);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/daniel/clienteCompleto.jsp");
        dispatcher.forward(request, response);
        
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
