package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Disciplina;
import model.Usuario;

public class DisciplinaDAO {
    
    private DataSource dataSource;
    
    public DisciplinaDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public ArrayList<Disciplina> readAllDiscDB(){
        try{
            String SQL = "SELECT id, nome, codigo, creditos, categoria FROM disciplinas";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ArrayList<Disciplina> lst = new ArrayList<>();
            
            while(rs.next()){
                Disciplina dsc = new Disciplina(rs.getInt("id"),rs.getString("nome"),rs.getString("codigo"),rs.getInt("creditos"),rs.getString("categoria"));
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
    
    public ArrayList<Disciplina> readAllByUser(Usuario usr){
        try{
            String SQL = "SELECT id, nome, codigo, creditos, categoria FROM " + usr.getListagem();
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ArrayList<Disciplina> lst = new ArrayList<>();
            
            while(rs.next()){
                Disciplina dsc = new Disciplina(rs.getInt("id"),rs.getString("nome"),rs.getString("codigo"),rs.getInt("creditos"),rs.getString("categoria"));
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
            String SQL = "SELECT id, nome, codigo, creditos, categoria FROM disciplinas WHERE UPPER(nome) LIKE '%" + frag + "%'"
                    + "OR UPPER(codigo) LIKE '%" + frag + "%'";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            ArrayList<Disciplina> lst = new ArrayList<>();
            
            while(rs.next()){
                Disciplina dsc = new Disciplina(rs.getInt("id"),rs.getString("nome"),rs.getString("codigo"),rs.getInt("creditos"),rs.getString("categoria"));
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
    
    public void insertDiscToUser(Usuario usr, Disciplina dsc){
        try{
            String SQL = "INSERT INTO " + usr.getListagem() + "(id, nome, codigo, creditos, categoria) VALUES (?,?,?,?,?)";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ps.setInt(1, dsc.getId());
            ps.setString(2, dsc.getNome());
            ps.setString(3, dsc.getCodigo());
            ps.setInt(4, dsc.getCreditos());
            ps.setString(5, dsc.getCategoria());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.err.println("ERRO NA CONEXÃO: " + ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("ERRO GENÉRICO: " + ex.getMessage());
        }
    }
    
    public void removeDiscFromUser(Usuario usr, Disciplina dsc){
        try{          
            String SQL = "DELETE FROM " + usr.getListagem() + " WHERE id = " + dsc.getId();
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.err.println("ERRO NA CONEXÃO: " + ex.getMessage());
        }
        catch(Exception ex){
            System.err.println("ERRO GENÉRICO: " + ex.getMessage());
        }
        
    }
    
}
