/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DataSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author pauloaraujo
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // iniciando banco de dados, caso contrário não executa o programa
        DataSource ds = new DataSource();
        if(ds.getConnection() != null){
            
            // camada de controle
            Acesso.setDS(ds);
            
            // inicializando programa com a tela de login        
            Parent root = FXMLLoader.load(getClass().getResource("/loginbcc/loginbcc.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("BCC - Contador de Créditos - Login");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            
        } else {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco!", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void stop () throws Exception{
        System.out.println("FECHOU");
        DataSource ds = Acesso.getDS();
        ds.closeDataSource();
        // TO DO: desconectar do banco de dados e retornar para a tela de login
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        Application.launch(Main.class, args);
    }
    
}
