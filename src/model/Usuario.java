/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pauloaraujo
 */
public class Usuario {
    
    private String login;
    private String senha;
    private String listagem;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getListagem() {
        return listagem;
    }

    public void setListagem(String listagem) {
        this.listagem = listagem;
    }
    
}
