package dao;

import java.sql.*;
/**
 *
 * @author pauloaraujo
 */
public class DataSource {
    
    private String database;
    private Connection connection;
    
    
    public DataSource(){
        // tentando conectar com o banco
        try{
            database = "poo_2016_2.db";
            String url = "jdbc:sqlite:" + database;
            
            DriverManager.registerDriver(new org.sqlite.JDBC());
            connection = DriverManager.getConnection(url);
            
            System.out.println("CONEXÃO REALIZADA COM SUCESSO!");
        }
        catch(SQLException ex){
            System.err.println("ERRO NA CONEXÃO: " + ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("ERRO GENÉRICO: " + ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeDataSource(){
        try{
            connection.close();
        }
        catch(Exception ex){
            System.err.println("ERRO AO DESCONECTAR: " + ex.getMessage());
        }
    }
}
