package br.edu.unidavi.bsi.leonardo.locator;

import java.sql.*;

import br.edu.unidavi.bsi.leonardo.exception.UnidaviBsiException;


public class ServiceLocator {
    
    private String databaseURL = "jdbc:mysql://localhost:3306/test";
    
    private String databasePassword = "";
    
    private String databaseUser = "root";
    
    private boolean useDatasource = false;
    
    private static ServiceLocator instance = new ServiceLocator();
    
    private ServiceLocator() {
    }
    
    public static ServiceLocator getInstance() {
        return instance;
    }
    
    public Connection getConnection() throws UnidaviBsiException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(databaseURL, databaseUser,databasePassword);
        } catch (Exception e) {
            System.out.println("Erro fatal ao obter conexao com DriverManager: "+ e.getMessage());
            throw new UnidaviBsiException("Erro ao obter conexao via DriverManager: "+ e.getMessage(),e);
        }
        return conn;
    }
}