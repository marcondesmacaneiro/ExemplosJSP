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
@WebServlet(name = "CadastroCliente", urlPatterns = {"/CadastroClienteJonathanFinaliza"})
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
        } catch(UnidaviBsiException e){
            e.getCause().printStackTrace();
            mensagem = "Não foi possível cadastrar o cliente no banco de dados";
        }
        
        request.setAttribute("mensagem", mensagem);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jonathan/clienteCompleto.jsp");
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
