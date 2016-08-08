/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginbcc;

import controladores.Acesso;
import dao.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author pauloaraujo
 */
public class LoginbccController implements Initializable {
  
    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblErro;

    @FXML
    private Button btnEntrar;

    @FXML
    void btnEntrarClick(ActionEvent event) throws IOException {
        
        UsuarioDAO usrDAO = new UsuarioDAO(Acesso.getDS());
        Usuario usr = usrDAO.buscaUsuario(txtLogin.getText());
        
        // verificando se o usuário preencheu os campos
        if(txtLogin.getText().equals("") || txtSenha.getText().equals("") ){
            lblErro.setText("Preencha os campos corretamenta!");
        } else {
            // verificando se a busca retornou algum usuário válido        
            if(usr != null){
                // verificando credenciais
                if(txtLogin.getText().equals(usr.getLogin()) &&
                        txtSenha.getText().equals(usr.getSenha())){
                    
                    // escondendo tela de login
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    
                    // limpando mensagem
                    lblErro.setText("");
                    
                    // camada de controle
                    Acesso.setUsuario(usr);
                    //Acesso.setDS(ds);
                    
                    // iniciando tela principal
                    Stage stage = new Stage();                 
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = loader.load(getClass().getResource("/contadordecreditosbcc/contadordecreditosbcc.fxml"));                   
                    Scene scene = new Scene(root);
                    
                    // inserindo handler para quando a janela principal for fechada
                    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                        @Override
                        public void handle(WindowEvent we) {
                            
                            try {
                                Stage st = new Stage();
                                Parent r;
                                r = FXMLLoader.load(getClass().getResource("/loginbcc/loginbcc.fxml"));
                                Scene s = new Scene(r);
                                st.setTitle("BCC - Contador de Créditos - Login");
                                st.setResizable(false);
                                st.setScene(s);
                                st.show();
                            } catch (IOException ex) {
                                System.out.println("ERRO: " + ex.getMessage());
                            }
                        }
                    });
                    
                    stage.setTitle("BCC - Contador de Créditos - " + usr.getLogin());
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    lblErro.setText("Senha incorreta!");
                }
                
            } else {
                lblErro.setText("Usuário inválido!");
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // iniciando a conexão com o banco para verificar as credenciais
        // do usuário e resgatar as informações pertinentes
    }    
    
    
    
}
