/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pauloaraujo
 */
public class Disciplina {
    
    // propriedades para navegação no JavaFX
    private final StringProperty    nome;
    private final StringProperty    codigo;
    private final StringProperty    categoria;
    private final IntegerProperty   creditos;
    private final IntegerProperty   id;
    
    // construtor padrão
    public Disciplina(){
        this(0,null,null,0,null);
    }
    
    // contrutor especificado
    public Disciplina(int id,String nome, String codigo, int creditos, String categoria){
        this.id         = new SimpleIntegerProperty(id);
        this.nome       = new SimpleStringProperty(nome);
        this.codigo     = new SimpleStringProperty(codigo);
        this.categoria  = new SimpleStringProperty(categoria);
        this.creditos   = new SimpleIntegerProperty(creditos);
    }
    
    // encapsulamento
    public int getId() { 
        return id.get();
    }
    public void setId(int id) { 
        this.id.set(id);
    }
    public IntegerProperty idProperty(){
        return id;
    }
    
    public String getNome() { 
        return nome.get();
    }
    public void setNome(String nome) { 
        this.nome.set(nome);
    }
    public StringProperty nomeProperty(){
        return nome;
    }
    
    public String getCodigo() {
        return codigo.get(); 
    } 
    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }
    public StringProperty codigoProperty(){
        return codigo;
    }

    public int getCreditos() {
        return creditos.get(); 
    }
    public void setCreditos(int creditos) { 
        this.creditos.set(creditos);
    }
    public IntegerProperty creditosProperty(){
        return creditos;
    }

    public String getCategoria() { 
        return categoria.get(); 
    }
    public void setCategoria(String categoria) { 
        this.categoria.set(categoria);
    }
    public StringProperty categoriaProperty(){
        return categoria;
    }
}
