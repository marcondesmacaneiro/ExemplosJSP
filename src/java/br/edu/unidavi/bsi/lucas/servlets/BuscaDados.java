package br.edu.unidavi.bsi.lucas.servlets;

import br.edu.unidavi.bsi.lucas.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.lucas.jdbc.ClienteDAO;
import br.edu.unidavi.bsi.lucas.model.Cliente;
import java.io.IOException;
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

@WebServlet(name = "BuscaDados", urlPatterns = {"/BuscaDadosLucas"})
public class BuscaDados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, UnidaviBsiException {
        
        List aLista = new ArrayList();
        //aLista = ClienteDAO.getInstance().getByNome("lucas");
        aLista = ClienteDAO.getInstance().getAll();
        String tabela;
        
        tabela = "<form action='"+request.getContextPath()+"/AlterarDados' method='post'>";
        tabela +=   "<input type='hidden' name='id_chave' id='id_chave'>";
        tabela +=   "<input type='hidden' name='id_acao' id='id_acao'>";        
        tabela +=  "<table border='1' align='center'>";        
        tabela +=   "<tr>";
        tabela +=     "<td>Nome</td>";
        tabela +=     "<td>Email</td>";
        tabela +=     "<td>Telefone</td>";
        tabela +=     "<td colspan='3'>Ações&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type='button' value='Novo Cadastro' onclick='novo_cadastro()'></td>";
        tabela +=   "</tr>";
        for(int i=0;i<aLista.size();i++)
        {
          Cliente oCliente = (Cliente) aLista.get(i);
          tabela += "<tr>";
          tabela +=   "<td>"+oCliente.getNome()+"</td>";
          tabela +=   "<td>"+oCliente.getEmail()+"</td>";
          tabela +=   "<td>"+oCliente.getTelefone()+"</td>";
          tabela +=   "<td>";
          tabela +=     "<input type='submit' value='Alterar' name='alterar_"+oCliente.getId()+"' onclick='serv_alterar(this.name, \"alterar\")'>";
          tabela +=   "</td>";
          tabela +=   "<td>";
          tabela +=     "<input type='submit' value='Excluir' name='excluir_"+oCliente.getId()+"' onclick='serv_alterar(this.name,\"excluir\")'>";
          tabela +=   "</td>";
          tabela +=   "<td>";
          tabela +=     "<input type='submit' value='Visualizar' name='visualizar_"+oCliente.getId()+"' onclick='serv_alterar(this.name,\"visualizar\")'>";
          tabela +=   "</td>";
          tabela += "</tr>";
        }
        tabela += "</table>";
        tabela += "</form>";
        
        request.setAttribute("alist", tabela);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/lucas/consultaCliente.jsp");
        dispatcher.forward(request, response);
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(BuscaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (UnidaviBsiException ex) {
            Logger.getLogger(BuscaDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}