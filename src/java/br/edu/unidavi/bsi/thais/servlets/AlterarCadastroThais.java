/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.thais.servlets;

import br.edu.unidavi.bsi.thais.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.thais.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.thais.model.Cliente;
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
 * @author Thais
 */
@WebServlet(name = "AlterarCadastro", urlPatterns = {"/alterarCadastroThais"})
public class AlterarCadastroThais extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
        
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
       
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setEnderecoRua(rua);
        cliente.setEnderecoNumero(numero);
        cliente.setEnderecoBairro(bairro);
        cliente.setEnderecoCep(cep);
        cliente.setEnderecoCidade(cidade);
        cliente.setEnderecoEstado(estado);
    */
                
        Integer id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente();
        try {
            cliente = (Cliente)ClienteDAO.getInstance().getByPrimaryKey(id);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(AlterarCadastroThais.class.getName()).log(Level.SEVERE, null, ex);
        }
        String mensagem = "Alteração efetuada com sucesso!";
        try {
            ClienteDAO.getInstance().save(cliente);
        } catch (UnidaviBsiException e) {
           
            mensagem = "Foi possível alterar cadastro de cliente no banco de dados";
        }
        request.setAttribute("cliente", cliente);
        request.setAttribute("mensagem", mensagem);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/thais/alterar.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
