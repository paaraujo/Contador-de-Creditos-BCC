package controle;

import dao.DataSource;
import model.Usuario;

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
