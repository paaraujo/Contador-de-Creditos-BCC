/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DataSource;
import model.Usuario;

/**
 *
 * @author pauloaraujo
 */
public abstract class Acesso {
    
    private static Usuario usuario;
    private static DataSource ds;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usr) {
        usuario = usr;
    }

    public static DataSource getDS() {
        return ds;
    }

    public static void setDS(DataSource d) {
        ds = d;
    }

}
