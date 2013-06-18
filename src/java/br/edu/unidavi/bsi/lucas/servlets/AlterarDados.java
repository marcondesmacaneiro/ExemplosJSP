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

@WebServlet(name = "AlterarDados", urlPatterns = {"/AlterarDados"})
public class AlterarDados extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, UnidaviBsiException {
        
        int iId = Integer.parseInt(request.getParameter("id_chave"));
        String sAcao = request.getParameter("id_acao");
                
        if("alterar".equals(sAcao))
        {
          //aLista = ClienteDAO.getInstance().getByNome("lucas");
          Cliente oCliente = (Cliente) ClienteDAO.getInstance().getByPrimaryKey(iId);
          String tabela;
          tabela = "<form action='"+request.getContextPath()+"/CadastrarAlterar' method='post'>";
          tabela +=  "<input type='hidden' name='id' value='"+oCliente.getId()+"'>";
          tabela +=  "<table border='1' align='center'>";        
          tabela +=   "<tr>";
          tabela +=     "<td>Nome</td>";
          tabela +=     "<td>Telefone</td>";
          tabela +=     "<td>E-mail</td>";
          tabela +=     "<td>Rua/Av</td>";
          tabela +=     "<td>Bairro</td>";
          tabela +=     "<td>Cidade</td>";
          tabela +=     "<td>Número</td>";
          tabela +=     "<td>CEP</td>";
          tabela +=     "<td>Estado</td>";
          tabela +=     "<td colspan='2'>Ações</td>";
          tabela +=   "</tr>";
          tabela +=   "<tr>";
          tabela +=     "<td><input name='nome' style='width: 100px;' type='text' value='"+oCliente.getNome()+"'></td>";
          tabela +=     "<td><input name='telefone' style='width: 100px;' type='text' value='"+oCliente.getTelefone()+"'></td>";
          tabela +=     "<td><input name='email' style='width: 100px;' type='text' value='"+oCliente.getEmail()+"'></td>";
          tabela +=     "<td><input name='rua' style='width: 100px;' type='text' value='"+oCliente.getEnderecoRua()+"'></td>";
          tabela +=     "<td><input name='bairro' style='width: 100px;' type='text' value='"+oCliente.getEnderecoBairro()+"'></td>";
          tabela +=     "<td><input name='cidade' style='width: 100px;' type='text' value='"+oCliente.getEnderecoCidade()+"'></td>";
          tabela +=     "<td><input name='numero' style='width: 100px;' type='text' value='"+oCliente.getEnderecoNumero()+"'></td>";
          tabela +=     "<td><input name='cep' style='width: 100px;' type='text' value='"+oCliente.getEnderecoCep()+"'></td>";
          tabela +=     "<td><input name='estado' style='width: 100px;' type='text' value='"+oCliente.getEnderecoEstado()+"'></td>";
          tabela +=     "<td>";
          tabela +=       "<input type='submit' value='Alterar'>";
          tabela +=     "</td>";
          tabela +=     "<td>";
          tabela +=       "<input type='button' value='Cancelar' onclick='novo_cadastro(1)'>";
          tabela +=     "</td>";
          tabela +=   "</tr>";
          tabela +=  "</table>";
          tabela +="</form>";
          
          request.setAttribute("dadosCliente", tabela);
        
          RequestDispatcher dispatcher = request.getRequestDispatcher("/lucas/visualizarCliente.jsp");
          dispatcher.forward(request, response);
        }
        else if("excluir".equals(sAcao))
        {
          Cliente cliente = new Cliente(iId);
          ClienteDAO.getInstance().delete(cliente);
        
          RequestDispatcher dispatcher = request.getRequestDispatcher("/BuscaDadosLucas");
          dispatcher.forward(request, response);
          //getServletContext().getRequestDispatcher("/BuscaDadosLucas").forward(request,response);
        }
        else if("visualizar".equals(sAcao))
        {
          //aLista = ClienteDAO.getInstance().getByNome("lucas");
          Cliente oCliente = (Cliente) ClienteDAO.getInstance().getByPrimaryKey(iId);
          String tabela;
          tabela =  "<table border='1' align='center'>";        
          tabela +=   "<tr>";
          tabela +=     "<td>Nome</td>";
          tabela +=     "<td>Telefone</td>";
          tabela +=     "<td>E-mail</td>";
          tabela +=     "<td>Rua/Av</td>";
          tabela +=     "<td>Bairro</td>";
          tabela +=     "<td>Cidade</td>";
          tabela +=     "<td>Número</td>";
          tabela +=     "<td>CEP</td>";
          tabela +=     "<td>Estado</td>";
          tabela +=   "</tr>";
          tabela +=   "<tr>";
          tabela +=     "<td>"+oCliente.getNome()+"</td>";
          tabela +=     "<td>"+oCliente.getTelefone()+"</td>";
          tabela +=     "<td>"+oCliente.getEmail()+"</td>";
          tabela +=     "<td>"+oCliente.getEnderecoRua()+"</td>";
          tabela +=     "<td>"+oCliente.getEnderecoBairro()+"</td>";
          tabela +=     "<td>"+oCliente.getEnderecoCidade()+"</td>";
          tabela +=     "<td>"+oCliente.getEnderecoNumero()+"</td>";
          tabela +=     "<td>"+oCliente.getEnderecoCep()+"</td>";
          tabela +=     "<td>"+oCliente.getEnderecoEstado()+"</td>";
          tabela +=   "</tr>";
          tabela += "</table>";
          tabela += "<hr>";
          tabela += "<table border='1' align='center'>";        
          tabela +=   "<tr>";
          tabela +=     "<td colspan='2'>Ações</td>";
          tabela +=     "<td>";
          tabela +=       "<input type='button' value='Consulta Clientes' onclick='novo_cadastro(1)'>";
          tabela +=     "</td>";
          tabela +=     "<td>";
          tabela +=       "<input type='button' value='Novo Cadastro' onclick='novo_cadastro(2)'>";
          tabela +=     "</td>";
          tabela +=   "</tr>";
          tabela += "</table>";
          
          request.setAttribute("dadosCliente", tabela);
        
          RequestDispatcher dispatcher = request.getRequestDispatcher("/lucas/visualizarCliente.jsp");
          dispatcher.forward(request, response);
        }
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