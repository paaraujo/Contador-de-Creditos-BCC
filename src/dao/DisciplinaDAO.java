/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Disciplina;

/**
 *
 * @author pauloaraujo
 */
public class DisciplinaDAO {
    
    private DataSource dataSource;
    
    public DisciplinaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public ArrayList<Disciplina> readAll(){
        try{
            String SQL = "SELECT nome, codigo, creditos, categoria FROM disciplinas";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ArrayList<Disciplina> lst = new ArrayList<>();
            
            while(rs.next()){
                Disciplina dsc = new Disciplina();
                dsc.setNome(rs.getString("nome"));
                dsc.setCodigo(rs.getString("codigo"));
                dsc.setCreditos(rs.getInt("creditos"));
                dsc.setCategoria(rs.getString("categoria"));
                lst.add(dsc);
            }
            
            ps.close();
            return lst;
        }
        catch(SQLException ex){
            System.err.println("ERRO NA CONEXÃO: " + ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("ERRO GENÉRICO: " + ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Disciplina> findSpecific(String frag){
        try{
            String SQL = "SELECT nome, codigo, creditos, categoria FROM disciplinas WHERE UPPER(nome) LIKE '%" + frag + "%'"
                    + "OR UPPER(codigo) LIKE '%" + frag + "%'";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ArrayList<Disciplina> lst = new ArrayList<>();
            
            while(rs.next()){
                Disciplina dsc = new Disciplina();
                dsc.setNome(rs.getString("nome"));
                dsc.setCodigo(rs.getString("codigo"));
                dsc.setCreditos(rs.getInt("creditos"));
                dsc.setCategoria(rs.getString("categoria"));
                lst.add(dsc);
            }
            
            ps.close();
            return lst;
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
