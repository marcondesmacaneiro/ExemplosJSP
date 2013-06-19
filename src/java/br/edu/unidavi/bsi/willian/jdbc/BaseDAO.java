package br.edu.unidavi.bsi.willian.jdbc;

import java.sql.*;
import java.util.List;

import br.edu.unidavi.bsi.willian.exception.UnidaviBsiException;
import br.edu.unidavi.bsi.willian.locator.ServiceLocator;

public abstract class BaseDAO {
    
    protected BaseDAO() {
    }
    
    public Connection getConnection() throws UnidaviBsiException {
        return ServiceLocator.getInstance().getConnection();
    }
    
    public void closeResources(Connection conn, Statement st) {
        closeResources(conn, st, null);
    }
    
    public void closeResources(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar ResultSet. " + e.getMessage());
        }
        try {
            if (st != null)
                st.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar Statement. " + e.getMessage());
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar Connection. " + e.getMessage());
        }
    }
    
    // captura o código(PK) do registro recém-incluído na tabela
    public long getUltimoCodigo(PreparedStatement pst) throws UnidaviBsiException {
        ResultSet rs = null;
        try {
            rs = pst.getGeneratedKeys();
            long codigo = 0;
            while (rs.next()) {
                codigo = rs.getLong(1);
            }
            return codigo;
        } catch (Exception e) {
            throw new UnidaviBsiException("[BaseDAO - getUltimoCodigo] : Handled Exception  ", e);
        }
    }
    
    protected abstract List getManyByCriteria(String sql) throws UnidaviBsiException;
    
    public abstract List getAll() throws UnidaviBsiException;
    
    public abstract Object getByPrimaryKey(Integer id) throws UnidaviBsiException;
    
    public abstract void delete(Object instancia) throws UnidaviBsiException;
    
    public abstract void save(Object instancia) throws UnidaviBsiException;
    
}
