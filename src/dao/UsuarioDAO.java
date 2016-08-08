/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author pauloaraujo
 */
public class UsuarioDAO {
    
    private DataSource dataSource;
    
    public UsuarioDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public Usuario buscaUsuario(String usuario){
        try{
            String SQL = "SELECT login, senha, listaD FROM usuarios WHERE login = '" + usuario + "'";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            
            Usuario usr = new Usuario();
            usr.setLogin(rs.getString("login"));
            usr.setSenha(rs.getString("senha"));
            usr.setListagem(rs.getString("listaD"));
                    
            ps.close();
            return usr;
        }
        catch(SQLException ex){
            System.err.println("ERRO NA CONEXÃO: " + ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("ERRO GENÉRICO: " + ex.getMessage());
        }
        return null;
    }
    
}
