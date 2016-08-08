/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadordecreditosbcc;

import controladores.Acesso;
import dao.DataSource;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Usuario;

/**
 *
 * @author pauloaraujo
 */
public class ContadorDeCreditosBCCController implements Initializable {
    
    @FXML
    private Text txtMC;             // Matriz Curricular
  
    @FXML
    private GridPane gridPane;

    @FXML
    private Text txtDisc01;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // ajustando a cor de fundo da matriz
        //panDisc01.setStyle("-fx-background-color: #C0C0C0;");  
        System.out.println(Acesso.getUsuario());
    }    
    
    // método para receber o usuário e a sua tabela de disciplinas correspondentes
    // o envio é feito pela tela de login
    
    public void stop() throws Exception{
        System.out.println(getClass().getName());
    }
    
}
