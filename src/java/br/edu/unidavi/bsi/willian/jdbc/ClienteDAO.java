package br.edu.unidavi.bsi.willian.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unidavi.bsi.willian.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.willian.model.Cliente;
import java.sql.SQLException;

public class ClienteDAO extends BaseDAO {

    private static String SQL_INSERT_CLIENTE =
            "insert into clientes ( nome, email, senha, telefone, endereco_rua, endereco_numero, endereco_bairro, endereco_cep, "
            + "endereco_cidade, endereco_estado, ativo ) "
            + "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
    private static String SQL_UPDATE_CLIENTE =
            "update clientes set nome = ?, email = ?, senha = ?, telefone = ?, endereco_rua = ?, endereco_numero = ?, "
            + "endereco_bairro = ?, endereco_cep = ?, endereco_cidade = ?, endereco_estado = ?, ativo = ? "
            + "where id = ?";
    private static String SQL_DELETE_CLIENTE = "delete from clientes where id = ? ";
    private static String SQL_SELECT_DELETE = "select id,nome from clientes";
    private static String SQL_SELECT_EDITAR = "select * from clientes";
    private static ClienteDAO instance = new ClienteDAO();

    /*protected*/public ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        return instance;
    }

    protected List getManyByCriteria(String sql) throws UnidaviBsiException {

        Connection conn = getConnection();
        Statement st = null;
        ResultSet rs = null;
        List alista = new ArrayList();

        try {

            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                boolean ativo = rs.getInt("ativo") == 1;
                Cliente cliente = new Cliente(
                        new Integer(rs.getInt("id")),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("telefone"),
                        ativo,
                        rs.getString("endereco_rua"),
                        rs.getString("endereco_numero"),
                        rs.getString("endereco_bairro"),
                        rs.getString("endereco_cep"),
                        rs.getString("endereco_cidade"),
                        rs.getString("endereco_estado"));
                alista.add(cliente);

            }

            return alista;

        } catch (Exception e) {
            throw new UnidaviBsiException("[ClienteDAO - getManyByCriteria] : Handled Exception  ", e);

        } finally {
            closeResources(conn, st, rs);
        }

    }

    public List getAll() throws UnidaviBsiException {
        String sql = "select * from clientes ";
        return this.getManyByCriteria(sql);
    }

    public Cliente getByPrimaryKey(Integer id) throws UnidaviBsiException {
        String sql = "select * from clientes where id = " + id;
        List lista = this.getManyByCriteria(sql);
        if (lista != null && lista.size() > 0) {
            return (Cliente) lista.get(0);
        } else {
            return null;
        }
    }

    public List getByNome(String nome) throws UnidaviBsiException {
        String sql = "select * from clientes where nome like '" + nome + "%'";
        return this.getManyByCriteria(sql);
    }

    public List getByEmail(String email) throws UnidaviBsiException {
        String sql = "select * from clientes where email = " + email;
        return this.getManyByCriteria(sql);
    }

    public List getList() throws UnidaviBsiException {
        Connection conn = getConnection();
        PreparedStatement pst = null;
        try {
            List<Cliente> contatos = new ArrayList<Cliente>();
            //PreparedStatement stmt = this.connection.
            pst = conn.prepareStatement("select * from clientes");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Cliente client = new Cliente();
                client.setId(rs.getInt("id"));
                client.setNome(rs.getString("nome"));
                client.setEmail(rs.getString("email"));
                //client.setEndereco(rs.getString("endereco"));

                // montando a data através do Calendar
                //Calendar data = Calendar.getInstance();
                //data.setTime(rs.getDate("dataNascimento"));
                //contato.setDataNascimento(data);

                // adicionando o objeto à lista
                contatos.add(client);
            }
            rs.close();
            pst.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Object instancia) throws UnidaviBsiException {

        Cliente cliente = (Cliente) instancia;

        Connection conn = getConnection();
        PreparedStatement pst = null;

        try {

            pst = conn.prepareStatement(SQL_DELETE_CLIENTE);

            pst.setInt(1, cliente.getId().intValue());

            pst.executeUpdate();

        } catch (Exception e) {
            throw new UnidaviBsiException("[ClienteDAO - delete] : Handled Exception  ", e);

        } finally {
            closeResources(conn, pst);
        }
    }

    public void save(Object instancia) throws UnidaviBsiException {

        Cliente cliente = (Cliente) instancia;

        Connection conn = getConnection();
        PreparedStatement pst = null;

        try {

            if (cliente.getId() == null || cliente.getId().intValue() == 0) {
                pst = conn.prepareStatement(SQL_INSERT_CLIENTE);
            } else {
                pst = conn.prepareStatement(SQL_UPDATE_CLIENTE);
                pst.setInt(12, cliente.getId().intValue());
            }

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getSenha());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getEnderecoRua());
            pst.setString(6, cliente.getEnderecoNumero());
            pst.setString(7, cliente.getEnderecoBairro());
            pst.setString(8, cliente.getEnderecoCep());
            pst.setString(9, cliente.getEnderecoCidade());
            pst.setString(10, cliente.getEnderecoEstado());
            pst.setInt(11, cliente.isAtivo() ? 1 : 0);

            pst.execute();

        } catch (Exception e) {
            throw new UnidaviBsiException("[ClienteDAO - save] : Handled Exception  ", e);

        } finally {
            closeResources(conn, pst);
        }

    }
}
